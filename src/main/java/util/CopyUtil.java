package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CopyUtil {

    //实现从Postgresql拷贝数据到MySQL
    public static void copy(String selectSql, String insertSql) {

        Connection postgresqlConn = null;
        Connection mysqlConn = null;

        PreparedStatement postgresqlPstm = null;
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
            postgresqlPstm = postgresqlConn.prepareStatement(selectSql, ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            postgresqlPstm.setFetchSize(1000);
            postgresqlPstm.setFetchDirection(ResultSet.FETCH_FORWARD);

            mysqlPstm = mysqlConn.prepareStatement(insertSql);


            // 3.执行sql语句
            rs = postgresqlPstm.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                count++;
                for (int i = 1; i <= columnCount; i++) {
                    mysqlPstm.setObject(i, rs.getString(i));
                }
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
            PostgresqlUtil.close(postgresqlConn, postgresqlPstm, rs);
            MysqlUtil.close(mysqlConn, mysqlPstm, null);
        }
    }


}
