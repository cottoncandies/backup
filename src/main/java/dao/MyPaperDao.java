package dao;


import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyPaperDao {

    String selectSql = "SELECT * FROM sys_my_paper_t";
    String insertSql = "insert into sys_my_paper_t(ng_id,ng_user_id,ng_subject_id, sz_caption, sz_scope, sz_time_len, sz_person, tx_data,  sz_file_store,  sz_answer_store, nt_section,  nt_grade, nt_total, nt_download_times,  nt_title_bar,  nt_info_bar,  nt_input_bar,  nt_tongfen_bar,  nt_show_answer,  nt_show_defen,  nt_file_kind,  nt_pingfen_bar,  nt_page_size,  nt_state,  ts_finished) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
                mysqlPstm.setLong(2, rs.getLong("ng_user_id"));
                mysqlPstm.setLong(3, rs.getLong("ng_subject_id"));
                mysqlPstm.setString(4, rs.getString("sz_caption"));
                mysqlPstm.setString(5, rs.getString("sz_scope"));
                mysqlPstm.setString(6, rs.getString("sz_time_len"));
                mysqlPstm.setString(7, rs.getString("sz_person"));
                mysqlPstm.setString(8, rs.getString("tx_data"));
                mysqlPstm.setString(9, rs.getString("sz_file_store"));
                mysqlPstm.setString(10, rs.getString("sz_answer_store"));
                mysqlPstm.setInt(11, rs.getInt("nt_section"));
                mysqlPstm.setInt(12, rs.getInt("nt_grade"));
                mysqlPstm.setInt(13, rs.getInt("nt_total"));
                mysqlPstm.setInt(14, rs.getInt("nt_download_times"));
                mysqlPstm.setInt(15, rs.getInt("nt_title_bar"));
                mysqlPstm.setInt(16, rs.getInt("nt_info_bar"));
                mysqlPstm.setInt(17, rs.getInt("nt_input_bar"));
                mysqlPstm.setInt(18, rs.getInt("nt_tongfen_bar"));
                mysqlPstm.setInt(19, rs.getInt("nt_show_answer"));
                mysqlPstm.setInt(20, rs.getInt("nt_show_defen"));
                mysqlPstm.setInt(21, rs.getInt("nt_file_kind"));
                mysqlPstm.setInt(22, rs.getInt("nt_pingfen_bar"));
                mysqlPstm.setInt(23, rs.getInt("nt_page_size"));
                mysqlPstm.setInt(24, rs.getInt("nt_state"));
                mysqlPstm.setDate(25, rs.getDate("ts_finished"));

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
