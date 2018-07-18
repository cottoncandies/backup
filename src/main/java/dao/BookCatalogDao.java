package dao;

import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookCatalogDao {


    String selectSql = "SELECT * FROM sys_book_catalog_t";
    String insertSql = "insert into sys_book_catalog_t(ng_id,sz_num,sz_parent_num,sz_caption,ng_parent_id,nt_section,ng_subject_id,nt_grade,nt_serial,sz_descr,nt_show,tx_comment,nt_old_id) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

            if (rs.next()) {

                System.out.println(rs.getString(1));
//                count++;
//                mysqlPstm.setLong(1, rs.getLong("ng_id"));
//                mysqlPstm.setString(2, rs.getString("sz_num"));
//                mysqlPstm.setString(3, rs.getString("sz_parent_num"));
//                mysqlPstm.setString(4, rs.getString("sz_caption"));
//                mysqlPstm.setLong(5, rs.getLong("ng_parent_id"));
//                mysqlPstm.setInt(6, rs.getInt("nt_section"));
//                mysqlPstm.setLong(7, rs.getLong("ng_subject_id"));
//                mysqlPstm.setInt(8, rs.getInt("nt_grade"));
//                mysqlPstm.setInt(9, rs.getInt("nt_serial"));
//                mysqlPstm.setString(10, rs.getString("sz_descr"));
//                mysqlPstm.setInt(11, rs.getInt("nt_show"));
//                mysqlPstm.setString(12, rs.getString("tx_comment"));
//                mysqlPstm.setInt(13, rs.getInt("nt_old_id"));
//                mysqlPstm.addBatch();

//                if (count % 5000 == 0) {
//                    mysqlPstm.executeBatch();
//                    mysqlConn.commit();
//                    mysqlPstm.clearBatch();        //提交后，Batch清空。
//                }
            }
//            mysqlPstm.executeBatch();
//            //优化插入第三步       提交，批量插入数据库中。
//            mysqlConn.commit();
//            mysqlPstm.clearBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
            PostgresqlUtil.close(postgresqlConn, PostgresqlPstm, rs);
            MysqlUtil.close(mysqlConn, mysqlPstm, null);
        }
    }
}
