package mysql;

import entity.Subject;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WriteToMysql {

    public static void addUser(User user) {

        Statement stat = null;
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/exercisesdb";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            stat = conn.createStatement();
            //创建执行语句，发送sql命令
            String sql = "insert into sys_user_t values" +
                    "("
                    + user.getNg_id() + ",'"
                    + user.getSz_username() + "','"
                    + user.getSz_password() + "',"
                    + user.getNt_section() + ","
                    + user.getNg_subject_id() + ",'"
                    + user.getSz_nickname() + "'"
                    + ")";

            //处理执行结果
            stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addSubject(Subject subject) {

        Statement stat = null;
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/exercisesdb";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            stat = conn.createStatement();
            //创建执行语句，发送sql命令
            String sql = "insert into sys_subject_t values" +
                    "("
                    + subject.getNg_id() + ",'"
                    + subject.getSz_caption() + "','"
                    + subject.getSz_sections() + "'"
                    + ")";

            //处理执行结果
            stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
