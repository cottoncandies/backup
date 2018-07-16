package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlUtil {

    public static String drivername = null;
    public static String url = null;
    public static String user = null;
    public static String password = null;
    public static Connection conn = null;

    static {
        try {
            Properties props = new Properties();
            InputStream in = MysqlUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
            props.load(in);

            drivername = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception {
        if (conn != null) {
            return conn;
        }

        Class.forName(drivername);
        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    public static void close(Connection conn, PreparedStatement preparedStatement) {

        try {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, PreparedStatement preparedStatement, ResultSet rs) {

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

