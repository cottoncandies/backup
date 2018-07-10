package dao;


import entity.Paper;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaperDao {

    String selectSql = "SELECT * FROM sys_paper_t";
    String insertSql = "insert into sys_paper_t(ng_id,sz_num,sz_caption,sz_kind,sz_age,ng_cat_id,nt_section,ng_subject_id,sz_wenli,sz_prov,sz_city,nt_term,nt_grade,nt_score,nt_score_ex,nt_cost_resp,ts_created,ts_updated,ts_auditing,tx_comment,sz_infor_src,sz_infor_kind,nt_old_id) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public List<Paper> queryAll() {
        List<Paper> papers = null;
        Paper paper = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            papers = new ArrayList<Paper>();
            while (rs.next()) {
                paper = new Paper();
                paper.setNg_id(rs.getLong("ng_id"));
                paper.setSz_num(rs.getString("sz_num"));
                paper.setSz_caption(rs.getString("sz_caption"));
                paper.setSz_kind(rs.getString("sz_kind"));
                paper.setSz_age(rs.getString("sz_age"));
                paper.setNg_cat_id(rs.getLong("ng_cat_id"));
                paper.setNt_section(rs.getInt("nt_section"));
                paper.setNg_subject_id(rs.getLong("ng_subject_id"));
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
                papers.add(paper);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return papers;
    }

    public void save(List<Paper> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (Paper paper : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, paper.getNg_id());
                st.setString(2, paper.getSz_num());
                st.setString(3, paper.getSz_caption());
                st.setString(4, paper.getSz_kind());
                st.setString(5, paper.getSz_age());
                st.setLong(6, paper.getNg_cat_id());
                st.setInt(7, paper.getNt_section());
                st.setLong(8, paper.getNg_subject_id());
                st.setString(9, paper.getSz_wenli());
                st.setString(10, paper.getSz_prov());
                st.setString(11, paper.getSz_city());
                st.setInt(12, paper.getNt_term());
                st.setInt(13, paper.getNt_grade());
                st.setInt(14, paper.getNt_score());
                st.setInt(15, paper.getNt_score_ex());
                st.setInt(16, paper.getNt_cost_resp());
                if (paper.getTs_created()==null) {
                    st.setDate(17, null);

                } else {
                    st.setDate(17, new java.sql.Date(paper.getTs_created().getTime()));

                }
                if(paper.getTs_updated()==null){
                    st.setDate(18, null);

                }else {
                    st.setDate(18, new java.sql.Date(paper.getTs_updated().getTime()));

                }
                if(paper.getTs_auditing()==null){
                    st.setDate(19, null);

                }else {
                    st.setDate(19, new java.sql.Date(paper.getTs_auditing().getTime()));
                }
                st.setString(20, paper.getTx_comment());
                st.setString(21, paper.getSz_infor_src());
                st.setString(22, paper.getSz_infor_kind());
                st.setInt(23, paper.getNt_old_id());

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
