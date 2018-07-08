package dao;

import entity.PaperExam;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaperExamDao implements BaseDao<PaperExam> {

    String sleectSql = "SELECT * FROM sys_paperexam_t";
    String insertSql = "insert into sys_paperexam_t(ng_id,ng_paper_id,ng_exam_id,nt_index,nt_old_id,sz_kind,tx_comment) values(?,?,?,?,?,?,?)";

    public List<PaperExam> queryAll() {
        List<PaperExam> paperExams = null;
        PaperExam paperExam = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(sleectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            paperExams = new ArrayList<PaperExam>();
            while (rs.next()) {
                paperExam = new PaperExam();
                paperExam.setNg_id(rs.getLong("ng_id"));
                paperExam.setNg_paper_id(rs.getLong("ng_paper_id"));
                paperExam.setNg_exam_id(rs.getLong("ng_exam_id"));
                paperExam.setNt_index(rs.getInt("nt_index"));
                paperExam.setNt_old_id(rs.getInt("nt_old_id"));
                paperExam.setSz_kind(rs.getString("sz_kind"));
                paperExam.setTx_comment(rs.getString("tx_comment"));
                paperExams.add(paperExam);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperExams;
    }

    public void save(List<PaperExam> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (PaperExam paperExam : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, paperExam.getNg_id());
                st.setLong(2, paperExam.getNg_paper_id());
                st.setLong(3, paperExam.getNg_exam_id());
                st.setInt(4, paperExam.getNt_index());
                st.setInt(5, paperExam.getNt_old_id());
                st.setString(6, paperExam.getSz_kind());
                st.setString(7, paperExam.getTx_comment());

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
