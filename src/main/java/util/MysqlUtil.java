package util;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
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

//
//    /**
//     * * 查询数据库的方法
//     * * @param sql        字符串，要执行的sql语句  如果其中有变量的话，就用  ‘"+变量+"’
//     */
//    public void R(String sql, List<ResultSet> args) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            for (int i = 0; i < args.size(); i++) {
//                preparedStatement.setObject(i + 1, args.get(i));
//            }
//            resultSet = preparedStatement.executeQuery();
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            int columnCount = resultSetMetaData.getColumnCount();
//            while (resultSet.next() != false) {
//                //这里可以执行一些其他的操作
//                for (int i = 1; i <= columnCount; i++) {
//                    System.out.println(resultSet.getString(i));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            release(connection, preparedStatement, resultSet);
//        }
//    }
//
//    /**
//     * 数据库记录增删改的方法
//     *
//     * @param sql 字符串，要执行的sql语句  如果其中有变量的话，就用  ‘"+变量+"’
//     */
//    public void CUD(String sql, Object... args) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        int result = 0;
//        try {
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            for (int i = 0; i < args.length; i++) {
//                preparedStatement.setObject(i + 1, args[i]);
//            }
//            result = preparedStatement.executeUpdate();
//            //这里可以根据返回结果(影响记录的条数)进行判断，该语句是否执行成功
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            release(connection, preparedStatement, null);
//        }
//    }
}

