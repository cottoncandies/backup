package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlUtil {
    public static String DRIVERNAME = null;
    public static String URL = null;
    public static String USER = null;
    public static String PASSWORD = null;

    public static Connection conn = null;

    static {
        try {

            Properties props = new Properties();
            InputStream in = MysqlUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
            props.load(in);

            DRIVERNAME = props.getProperty("driver");
            URL = props.getProperty("url");
            USER = props.getProperty("user");
            PASSWORD = props.getProperty("password");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception {
        if (conn != null) {
            return conn;
        }

        Class.forName(DRIVERNAME);
        conn = DriverManager.getConnection(URL, USER, PASSWORD);

        return conn;
    }

    public static void close(Connection conn, PreparedStatement pstm) throws SQLException {
        pstm.close();
        conn.close();
    }

    public static void close(Connection conn, ResultSet rs, PreparedStatement pstm) throws SQLException {
        pstm.close();
        rs.close();
        conn.close();
    }
}

