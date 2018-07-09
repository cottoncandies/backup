package dao;

import entity.ExamKind;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamKindDao implements BaseDao<ExamKind> {

    String sleectSql = "SELECT * FROM sys_examkind_t";
    String insertSql = "insert into sys_examkind_t(ng_id,ng_subject_id,nt_section,nt_state,nt_old_id,sz_caption,tx_comment) values(?,?,?,?,?,?,?)";

    public List<ExamKind> queryAll() {
        List<ExamKind> examKinds = null;
        ExamKind examKind = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(sleectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            examKinds = new ArrayList<ExamKind>();
            while (rs.next()) {
                examKind = new ExamKind();
                examKind.setNg_id(rs.getLong("ng_id"));
                examKind.setNg_subject_id(rs.getLong("ng_subject_id"));
                examKind.setNt_section(rs.getInt("nt_section"));
                examKind.setNt_state(rs.getInt("nt_state"));
                examKind.setNt_old_id(rs.getInt("nt_old_id"));
                examKind.setSz_caption(rs.getString("sz_caption"));
                examKind.setTx_comment(rs.getString("tx_comment"));
                examKinds.add(examKind);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return examKinds;
    }

    public void save(List<ExamKind> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (ExamKind examKind : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, examKind.getNg_id());
                st.setLong(2, examKind.getNg_subject_id());
                st.setInt(3, examKind.getNt_section());
                st.setInt(4, examKind.getNt_state());
                st.setInt(5, examKind.getNt_old_id());
                st.setString(6, examKind.getSz_caption());
                st.setString(7, examKind.getTx_comment());


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
