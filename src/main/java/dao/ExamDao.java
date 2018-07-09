package dao;


import entity.Exam;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamDao implements BaseDao<Exam> {

    String selectCountSql = "SELECT count(*) FROM sys_exam_t";
    String selectSql = "SELECT * FROM sys_exam_t limit ? offset ?";
    String insertSql = "insert into sys_exam_t(ng_id,ng_parent_id,ng_cat_id,ng_subject_id,ng_kind_id, sz_cat_full,  sz_prov, sz_city, sz_infor_src, sz_age, sz_infor_kind,  sz_wenli, sz_must,  sz_chart_kind, sz_paper_num,  sz_pager_level,  sz_paper_age, sz_paper_index,  tx_keywords, sz_listen,  tx_comment,  sz_kp_cap2,  tx_comment2, tx_err_descr,  sz_old_textbook, sz_chapter, sz_segment,  sz_edition, sz_kind_name,  sz_abi_cap, sz_kp_cap, tx_mingti,  tx_answer, tx_xuanxiang,  tx_jiexi, tx_tigan,  nt_num, nt_parent_num,  nt_sub_index,  nt_section,  nt_grade,  nt_term,  nt_deep,  nt_read_time,  nt_answer_time,  nt_score,  nt_objective,  nt_infor_trans,  nt_in_paper,  nt_view_times, nt_using_times,  nt_audit,  nt_state, ts_created, ts_updated, ts_auditing) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public List<Exam> queryAll() {
        List<Exam> exams = null;
        Exam exam = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            exams = new ArrayList<Exam>();
            while (rs.next()) {
                exam = new Exam();
                exam.setNg_id(rs.getLong("ng_id"));
                exam.setNg_parent_id(rs.getLong("ng_parent_id"));
                exam.setNg_cat_id(rs.getLong("ng_cat_id"));
                exam.setNg_subject_id(rs.getLong("ng_subject_id"));
                exam.setNg_kind_id(rs.getLong("ng_kind_id"));
                exam.setSz_cat_full(rs.getString("sz_cat_full"));
                exam.setSz_prov(rs.getString("sz_prov"));
                exam.setSz_city(rs.getString("sz_city"));
                exam.setSz_infor_src(rs.getString("sz_infor_src"));
                exam.setSz_age(rs.getString("sz_age"));
                exam.setSz_infor_kind(rs.getString("sz_infor_kind"));
                exam.setSz_wenli(rs.getString("sz_wenli"));
                exam.setSz_must(rs.getString("sz_must"));
                exam.setSz_chart_kind(rs.getString("sz_chart_kind"));
                exam.setSz_paper_num(rs.getString("sz_paper_num"));
                exam.setSz_pager_level(rs.getString("sz_pager_level"));
                exam.setSz_paper_age(rs.getString("sz_paper_age"));
                exam.setSz_paper_index(rs.getString("sz_paper_index"));
                exam.setTx_keywords(rs.getString("tx_keywords"));
                exam.setSz_listen(rs.getString("sz_listen"));
                exam.setTx_comment(rs.getString("tx_comment"));
                exam.setSz_kp_cap2(rs.getString("sz_kp_cap2"));
                exam.setTx_comment2(rs.getString("tx_comment2"));
                exam.setTx_err_descr(rs.getString("tx_err_descr"));
                exam.setSz_old_textbook(rs.getString("sz_old_textbook"));
                exam.setSz_chapter(rs.getString("sz_chapter"));
                exam.setSz_segment(rs.getString("sz_segment"));
                exam.setSz_edition(rs.getString("sz_edition"));
                exam.setSz_kind_name(rs.getString("sz_kind_name"));
                exam.setSz_abi_cap(rs.getString("sz_abi_cap"));
                exam.setSz_kp_cap(rs.getString("sz_kp_cap"));
                exam.setTx_mingti(rs.getString("tx_mingti"));
                exam.setTx_answer(rs.getString("tx_answer"));
                exam.setTx_xuanxiang(rs.getString("tx_xuanxiang"));
                exam.setTx_jiexi(rs.getString("tx_jiexi"));
                exam.setTx_tigan(rs.getString("tx_tigan"));
                exam.setNt_num(rs.getInt("nt_num"));
                exam.setNt_parent_num(rs.getInt("nt_parent_num"));
                exam.setNt_sub_index(rs.getInt("nt_sub_index"));
                exam.setNt_section(rs.getInt("nt_section"));
                exam.setNt_grade(rs.getInt("nt_grade"));
                exam.setNt_term(rs.getInt("nt_term"));
                exam.setNt_deep(rs.getInt("nt_deep"));
                exam.setNt_read_time(rs.getInt("nt_read_time"));
                exam.setNt_answer_time(rs.getInt("nt_answer_time"));
                exam.setNt_score(rs.getInt("nt_score"));
                exam.setNt_objective(rs.getInt("nt_objective"));
                exam.setNt_infor_trans(rs.getInt("nt_infor_trans"));
                exam.setNt_in_paper(rs.getInt("nt_in_paper"));
                exam.setNt_view_times(rs.getInt("nt_view_times"));
                exam.setNt_using_times(rs.getInt("nt_using_times"));
                exam.setNt_audit(rs.getInt("nt_audit"));
                exam.setNt_state(rs.getInt("nt_state"));
                exam.setTs_created(rs.getDate("ts_created"));
                exam.setTs_updated(rs.getDate("ts_updated"));
                exam.setTs_auditing(rs.getDate("ts_auditing"));
                exams.add(exam);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exams;
    }

    public void save(List<Exam> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (Exam exam : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, exam.getNg_id());
                st.setLong(2, exam.getNg_parent_id());
                st.setLong(3, exam.getNg_cat_id());
                st.setLong(4, exam.getNg_subject_id());
                st.setLong(5, exam.getNg_kind_id());
                st.setString(6, exam.getSz_cat_full());
                st.setString(7, exam.getSz_prov());
                st.setString(8, exam.getSz_city());
                st.setString(9, exam.getSz_infor_src());
                st.setString(10, exam.getSz_age());
                st.setString(11, exam.getSz_infor_kind());
                st.setString(12, exam.getSz_wenli());
                st.setString(13, exam.getSz_must());
                st.setString(14, exam.getSz_chart_kind());
                st.setString(15, exam.getSz_paper_num());
                st.setString(16, exam.getSz_pager_level());
                st.setString(17, exam.getSz_paper_age());
                st.setString(18, exam.getSz_paper_index());
                st.setString(19, exam.getTx_keywords());
                st.setString(20, exam.getSz_listen());
                st.setString(21, exam.getTx_comment());
                st.setString(22, exam.getSz_kp_cap2());
                st.setString(23, exam.getTx_comment2());
                st.setString(24, exam.getTx_err_descr());
                st.setString(25, exam.getSz_old_textbook());
                st.setString(26, exam.getSz_chapter());
                st.setString(27, exam.getSz_segment());
                st.setString(28, exam.getSz_edition());
                st.setString(29, exam.getSz_kind_name());
                st.setString(30, exam.getSz_abi_cap());
                st.setString(31, exam.getSz_kp_cap());
                st.setString(32, exam.getTx_mingti());
                st.setString(33, exam.getTx_answer());
                st.setString(34, exam.getTx_xuanxiang());
                st.setString(35, exam.getTx_jiexi());
                st.setString(36, exam.getTx_tigan());
                st.setInt(37, exam.getNt_num());
                st.setInt(38, exam.getNt_parent_num());
                st.setInt(39, exam.getNt_sub_index());
                st.setInt(40, exam.getNt_section());
                st.setInt(41, exam.getNt_grade());
                st.setInt(42, exam.getNt_term());
                st.setInt(43, exam.getNt_deep());
                st.setInt(44, exam.getNt_read_time());
                st.setInt(45, exam.getNt_answer_time());
                st.setInt(46, exam.getNt_score());
                st.setInt(47, exam.getNt_objective());
                st.setInt(48, exam.getNt_infor_trans());
                st.setInt(49, exam.getNt_in_paper());
                st.setInt(50, exam.getNt_view_times());
                st.setInt(51, exam.getNt_using_times());
                st.setInt(52, exam.getNt_audit());
                st.setInt(53, exam.getNt_state());
                st.setDate(54, new java.sql.Date(exam.getTs_created().getTime()));
                st.setDate(55, new java.sql.Date(exam.getTs_updated().getTime()));
                st.setDate(56, new java.sql.Date(exam.getTs_auditing().getTime()));


                // 3.执行sql语句
                st.executeUpdate();

            }

            // 5.释放资源
            MysqlUtil.close(conn, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int queryCount() {

        int count = 0;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectCountSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            while (rs.next()) {
                count = rs.getInt(1);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
