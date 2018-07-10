package dao;

import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends CommonBackup {

    String selectSql = "SELECT * FROM sys_user_t";
    String insertSql = "insert into sys_user_t(ng_id,sz_username,sz_password,nt_section,ng_subject_id,sz_nickname) values(?,?,?,?,?,?)";

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

            // 2.获取SQL执行者
            PostgresqlPstm = postgresqlConn.prepareStatement(selectSql);
            mysqlPstm = mysqlConn.prepareStatement(insertSql);

            // 3.执行sql语句
            rs = PostgresqlPstm.executeQuery();

            // 4.处理数据
            while (rs.next()) {
                mysqlPstm.setLong(1, rs.getLong("ng_id"));
                mysqlPstm.setString(2, rs.getString("sz_username"));
                mysqlPstm.setString(3, rs.getString("sz_password"));
                mysqlPstm.setInt(4, rs.getInt("nt_section"));
                mysqlPstm.setLong(5, rs.getLong("ng_subject_id"));
                mysqlPstm.setString(6, rs.getString("sz_nickname"));

                // 3.执行sql语句
                mysqlPstm.executeUpdate();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                // 5.释放资源
                PostgresqlUtil.close(postgresqlConn, rs, PostgresqlPstm);
                MysqlUtil.close(mysqlConn, mysqlPstm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




