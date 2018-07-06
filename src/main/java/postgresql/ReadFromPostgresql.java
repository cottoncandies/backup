package postgresql;


import entity.Paper;
import entity.Subject;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromPostgresql {
    //查询sys_user_t
    public static List<User> getUsers() {
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        List<User> users = new ArrayList<User>();
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.1.211:5432/exercisesdb";
            String username = "postgres";
            String password = "pgsqlpwd";
            conn = DriverManager.getConnection(url, username, password);

            stat = conn.createStatement();
            String sql = "select * from sys_user_t";
            rs = stat.executeQuery(sql);
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setNg_id(rs.getLong("ng_id"));
                user.setNg_subject_id(rs.getLong("ng_subject_id"));
                user.setNt_section(rs.getInt("nt_section"));
                user.setSz_username(rs.getString("sz_username"));
                user.setSz_password(rs.getString("sz_password"));
                user.setSz_nickname(rs.getString("sz_nickname"));
                users.add(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    //查询sys_subject_t
    public static List<Subject> getSubjects() {
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        List<Subject> subjects = new ArrayList<Subject>();
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.1.211:5432/exercisesdb";
            String username = "postgres";
            String password = "pgsqlpwd";
            conn = DriverManager.getConnection(url, username, password);

            stat = conn.createStatement();
            String sql = "select * from sys_subject_t";
            rs = stat.executeQuery(sql);
            Subject subject = null;
            while (rs.next()) {
                subject = new Subject();
                subject.setNg_id(rs.getLong("ng_id"));
                subject.setSz_caption(rs.getString("sz_caption"));
                subject.setSz_sections(rs.getString("sz_sections"));
                subjects.add(subject);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return subjects;
    }

    //查询sys_paper_t
    public static List<Paper> getPapers() {
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        List<Paper> papers = new ArrayList<Paper>();
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.1.211:5432/exercisesdb";
            String username = "postgres";
            String password = "pgsqlpwd";
            conn = DriverManager.getConnection(url, username, password);

            stat = conn.createStatement();
            String sql = "select * from sys_paper_t";
            rs = stat.executeQuery(sql);
            Paper paper = null;
            while (rs.next()) {
                paper = new Paper();
                paper.setNg_id(rs.getLong("ng_id"));
                paper.setSz_num(rs.getString("sz_num"));
                paper.setSz_caption(rs.getString("sz_caption"));
                paper.setSz_kind(rs.getString("sz_kind"));
                paper.setSz_age(rs.getString("sz_age"));
                paper.setNg_cat_id(rs.getLong("ng_cat_id"));
                paper.setNg_subject_id(rs.getLong("ng_subject_id"));
                paper.setNt_section(rs.getInt("nt_section"));
                paper.setSz_wenli(rs.getString("sz_wenli"));
                paper.setSz_prov(rs.getString("sz_prov"));
                paper.setSz_city(rs.getString("sz_city"));
                paper.setNt_term(rs.getInt("nt_term"));
                paper.setNt_grade(rs.getInt("nt_grade"));
                paper.setNt_score(rs.getInt("nt_score"));
                paper.setNt_score_ex(rs.getInt("nt_score_ex"));
                paper.setNt_cost_resp(rs.getInt("nt_cost_resp"));
                paper.setTs_created(rs.getDate("ts_created"));
                paper.setTs_updated(rs.getDate("ts_updated"));
                paper.setTs_auditing(rs.getDate("ts_auditing"));
                paper.setTx_comment(rs.getString("tx_comment"));
                paper.setSz_infor_src(rs.getString("sz_infor_src"));
                paper.setSz_infor_kind(rs.getString("sz_infor_kind"));
                paper.setNt_old_id(rs.getInt("nt_old_id"));

            }


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
        return papers;
    }
}
