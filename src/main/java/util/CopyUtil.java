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
            //获取数据库表的字段个数
            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                count++;
                for (int i = 1; i <= columnCount; i++) {
                    mysqlPstm.setObject(i, rs.getString(i));
                }
                //添加到批操作
                mysqlPstm.addBatch();
                //每5000条insert语句发送给数据库并执行一次数据库操作
                if (count % 5000 == 0) {
                    mysqlPstm.executeBatch();
                    mysqlConn.commit();
                    mysqlPstm.clearBatch();        //提交后，Batch清空。
                }
            }
            //不足5000条数据,将剩下的发送给数据库执行操作。
            mysqlPstm.executeBatch();
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
