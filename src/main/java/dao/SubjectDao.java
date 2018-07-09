package dao;

import entity.Subject;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao implements BaseDao<Subject> {

    String sleectSql = "SELECT * FROM sys_subject_t";
    String insertSql = "insert into sys_subject_t(ng_id,sz_caption,sz_sections) values(?,?,?)";

    public List<Subject> queryAll() {
        List<Subject> subjects = null;
        Subject subject = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(sleectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            subjects = new ArrayList<Subject>();
            while (rs.next()) {
                subject = new Subject();
                subject.setNg_id(rs.getLong("ng_id"));
                subject.setSz_caption(rs.getString("sz_caption"));
                subject.setSz_sections(rs.getString("sz_sections"));
                subjects.add(subject);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public void save(List<Subject> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (Subject subject : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, subject.getNg_id());
                st.setString(2, subject.getSz_caption());
                st.setString(3, subject.getSz_sections());

                // 3.执行sql语句
                st.executeUpdate();

            }

            // 5.释放资源
            MysqlUtil.close(conn, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

