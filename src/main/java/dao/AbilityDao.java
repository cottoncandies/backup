package dao;

import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbilityDao implements BaseDao {

    String selectSql = "SELECT * FROM sys_ability_t";
    String insertSql = "insert into sys_ability_t(ng_id,nt_section,ng_subject_id,sz_caption,nt_state,tx_comment,nt_old_id) values(?,?,?,?,?,?,?)";

    public void backup() {

        Connection postgresqlConn = null;
        Connection mysqlConn = null;

        PreparedStatement PostgresqlPstm = null;
        PreparedStatement mysqlPstm = null;

        ResultSet rs = null;

        try {
            //1.获取Connection连接
            postgresqlConn = PostgresqlUtil.getConnection();
            mysqlConn = MysqlUtil.getConnection();

            //设置AutoCommit属性为false,这个一定要用
            //配合设置setFetchSize(10)   setFetchDirection(ResultSet.FETCH_FORWARD)等属性
            //避免大量数据读写时出现java.lang.OutOfMemoryError: Java heap space
            postgresqlConn.setAutoCommit(false);


            // 2.获取SQL执行者
            PostgresqlPstm = postgresqlConn.prepareStatement(selectSql,ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            PostgresqlPstm.setFetchSize(1000);
            PostgresqlPstm.setFetchDirection(ResultSet.FETCH_FORWARD);

            mysqlPstm = mysqlConn.prepareStatement(insertSql);


            // 3.执行sql语句
            rs = PostgresqlPstm.executeQuery();

            while (rs.next()) {

                mysqlPstm.setLong(1, rs.getLong("ng_id"));
                mysqlPstm.setInt(2, rs.getInt("nt_section"));
                mysqlPstm.setLong(3, rs.getLong("ng_subject_id"));
                mysqlPstm.setString(4, rs.getString("sz_caption"));
                mysqlPstm.setInt(5, rs.getInt("nt_state"));
                mysqlPstm.setString(6, rs.getString("tx_comment"));
                mysqlPstm.setInt(7, rs.getInt("nt_old_id"));

                // 3.执行sql语句
                mysqlPstm.executeUpdate();

            }
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
