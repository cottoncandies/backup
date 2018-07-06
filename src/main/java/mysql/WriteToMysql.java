package mysql;

import entity.*;

import java.sql.*;

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
            //为了提高效率,避免做空值判断,程序这里取巧,将所有的ts_updated 和ts_auditing 设为null,因为原数据库这两个字段的值都是null
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
                    + paper.getTs_created() + "','null','null',"
                    + paper.getTx_comment() + ",'"
                    + paper.getSz_infor_src() + "','"
                    + paper.getSz_infor_kind() + "',"
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

    public static void addAbility(Ability ability) {

        Statement stat = null;
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/exercisesdb";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            stat = conn.createStatement();

            String sql = "insert into sys_ability_t values" +
                    "("
                    + ability.getNg_id() + ","
                    + ability.getNt_section() + ","
                    + ability.getNg_subject_id() + ",'"
                    + ability.getSz_caption() + "',"
                    + ability.getNt_state() +",'"
                    + ability.getTx_comment()+"',"
                    + ability.getNt_old_id()
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

    public static void addBookCatalog(BookCatalog bookCatalog) {

        PreparedStatement pstm = null;
        Connection conn = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/exercisesdb?useSSL=false";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);

            String sql = "insert into sys_book_catalog_t values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1,bookCatalog.getNg_id());
            pstm.setString(2,bookCatalog.getSz_num());
            pstm.setString(3,bookCatalog.getSz_parent_num());
            pstm.setString(4,bookCatalog.getSz_caption());
            pstm.setLong(5,bookCatalog.getNg_parent_id());
            pstm.setInt(6,bookCatalog.getNt_section());
            pstm.setLong(7,bookCatalog.getNg_subject_id());
            pstm.setInt(8,bookCatalog.getNt_grade());
            pstm.setInt(9,bookCatalog.getNt_serial());
            pstm.setString(10,bookCatalog.getSz_descr());
            pstm.setInt(11,bookCatalog.getNt_show());
            pstm.setString(12,bookCatalog.getTx_comment());
            pstm.setInt(13,bookCatalog.getNt_old_id());
            //处理执行结果
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
