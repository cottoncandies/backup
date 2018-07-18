package dao;

import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaperExamDao {

    String selectSql = "SELECT * FROM sys_paper_exam_t";
    String insertSql = "insert into sys_paper_exam_t(ng_id,ng_paper_id,ng_exam_id,nt_index,nt_old_id,sz_kind,tx_comment) values(?,?,?,?,?,?,?)";

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
                mysqlPstm.setLong(2, rs.getLong("ng_paper_id"));
                mysqlPstm.setLong(3, rs.getLong("ng_exam_id"));
                mysqlPstm.setInt(4, rs.getInt("nt_index"));
                mysqlPstm.setInt(5, rs.getInt("nt_old_id"));
                mysqlPstm.setString(6, rs.getString("sz_kind"));
                mysqlPstm.setString(7, rs.getString("tx_comment"));

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
            PostgresqlUtil.close(postgresqlConn, PostgresqlPstm, rs);
            MysqlUtil.close(mysqlConn, mysqlPstm, null);
        }
    }
}
