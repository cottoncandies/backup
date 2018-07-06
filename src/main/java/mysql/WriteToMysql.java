package mysql;

import entity.Paper;
import entity.Subject;
import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        } finally {
            try {
                stat.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        } finally {
            try {
                stat.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addPaper(Paper paper) {

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
            String sql = "insert into sys_paper_t values" +
                    "("
                    + paper.getNg_id() + ",'"
                    + paper.getSz_num() + "','"
                    + paper.getSz_caption() + "','"
                    + paper.getSz_kind() + "','"
                    + paper.getSz_age() + "',"
                    + paper.getNg_cat_id() + ","
                    + paper.getNt_section() + ","
                    + paper.getNg_subject_id() + ",'"
                    + paper.getSz_wenli() + "','"
                    + paper.getSz_prov() + "','"
                    + paper.getSz_city() + "',"
                    + paper.getNt_term() + ","
                    + paper.getNt_grade() + ","
                    + paper.getNt_score() + ","
                    + paper.getNt_score_ex() + ","
                    + paper.getNt_cost_resp() + ",'"
                    + paper.getTs_created() + "','"
                    + paper.getTs_updated() + "','"
                    + paper.getTs_auditing() + "',"
                    + paper.getTx_comment() + ","
                    + paper.getSz_infor_src() + ","
                    + paper.getSz_infor_kind() + ","
                    + paper.getNt_old_id()
                    + ")";

            //处理执行结果
            stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stat.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
