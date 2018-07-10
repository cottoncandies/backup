package dao;


import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaperDao {

    String selectSql = "SELECT * FROM sys_paper_t";
    String insertSql = "insert into sys_paper_t(ng_id,sz_num,sz_caption,sz_kind,sz_age,ng_cat_id,nt_section,ng_subject_id,sz_wenli,sz_prov,sz_city,nt_term,nt_grade,nt_score,nt_score_ex,nt_cost_resp,ts_created,ts_updated,ts_auditing,tx_comment,sz_infor_src,sz_infor_kind,nt_old_id) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void backup() {

        Connection postgresqlConn = null;
        Connection mysqlConn = null;

        PreparedStatement PostgresqlPstm = null;
        PreparedStatement mysqlPstm = null;

        ResultSet rs = null;

        int count = 0;

        try {
            //1.获取Connection连接
            postgresqlConn = PostgresqlUtil.getConnection();
            mysqlConn = MysqlUtil.getConnection();

            //设置AutoCommit属性为false,这个一定要用
            //配合设置setFetchSize(10)   setFetchDirection(ResultSet.FETCH_FORWARD)等属性
            //避免大量数据读写时出现java.lang.OutOfMemoryError: Java heap space
            postgresqlConn.setAutoCommit(false);
            mysqlConn.setAutoCommit(false);


            // 2.获取SQL执行者
            PostgresqlPstm = postgresqlConn.prepareStatement(selectSql, ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            PostgresqlPstm.setFetchSize(1000);
            PostgresqlPstm.setFetchDirection(ResultSet.FETCH_FORWARD);

            mysqlPstm = mysqlConn.prepareStatement(insertSql);


            // 3.执行sql语句
            rs = PostgresqlPstm.executeQuery();

            while (rs.next()) {
                count++;
                mysqlPstm.setLong(1, rs.getLong("ng_id"));
                mysqlPstm.setString(2, rs.getString("sz_num"));
                mysqlPstm.setString(3, rs.getString("sz_caption"));
                mysqlPstm.setString(4, rs.getString("sz_kind"));
                mysqlPstm.setString(5, rs.getString("sz_age"));
                mysqlPstm.setLong(6, rs.getLong("ng_cat_id"));
                mysqlPstm.setInt(7, rs.getInt("nt_section"));
                mysqlPstm.setLong(8, rs.getLong("ng_subject_id"));
                mysqlPstm.setString(9, rs.getString("sz_wenli"));
                mysqlPstm.setString(10, rs.getString("sz_prov"));
                mysqlPstm.setString(11, rs.getString("sz_city"));
                mysqlPstm.setInt(12, rs.getInt("nt_term"));
                mysqlPstm.setInt(13, rs.getInt("nt_grade"));
                mysqlPstm.setInt(14, rs.getInt("nt_score"));
                mysqlPstm.setInt(15, rs.getInt("nt_score_ex"));
                mysqlPstm.setInt(16, rs.getInt("nt_cost_resp"));
                mysqlPstm.setDate(17, rs.getDate("ts_created"));
                mysqlPstm.setDate(18, rs.getDate("ts_updated"));
                mysqlPstm.setDate(19, rs.getDate("ts_auditing"));
                mysqlPstm.setString(20, rs.getString("tx_comment"));
                mysqlPstm.setString(21, rs.getString("sz_infor_src"));
                mysqlPstm.setString(22, rs.getString("sz_infor_kind"));
                mysqlPstm.setInt(23, rs.getInt("nt_old_id"));

                mysqlPstm.addBatch();

                if (count % 5000 == 0) {
                    mysqlPstm.executeBatch();
                    mysqlConn.commit();
                    mysqlPstm.clearBatch();        //提交后，Batch清空。
                }
            }
            mysqlPstm.executeBatch();
            //优化插入第三步       提交，批量插入数据库中。
            mysqlConn.commit();
            mysqlPstm.clearBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
            try {
                PostgresqlUtil.close(postgresqlConn, rs, PostgresqlPstm);
                MysqlUtil.close(mysqlConn, mysqlPstm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
