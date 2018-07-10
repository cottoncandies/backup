package dao;


import entity.ExamAbi;
import entity.MyPaper;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyPaperDao {

    String selectSql = "SELECT * FROM sys_my_paper_t";
    String insertSql = "insert into sys_my_paper_t(ng_id,ng_user_id,ng_subject_id, sz_caption, sz_scope, sz_time_len, sz_person, tx_data,  sz_file_store,  sz_answer_store, nt_section,  nt_grade, nt_total, nt_download_times,  nt_title_bar,  nt_info_bar,  nt_input_bar,  nt_tongfen_bar,  nt_show_answer,  nt_show_defen,  nt_file_kind,  nt_pingfen_bar,  nt_page_size,  nt_state,  ts_finished) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public List<MyPaper> queryAll() {
        List<MyPaper> myPapers = null;
        MyPaper myPaper = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            myPapers = new ArrayList<MyPaper>();
            while (rs.next()) {
                myPaper = new MyPaper();
                myPaper.setNg_id(rs.getLong("ng_id"));
                myPaper.setNg_user_id(rs.getLong("ng_user_id"));
                myPaper.setNg_subject_id(rs.getLong("ng_subject_id"));
                myPaper.setSz_caption(rs.getString("sz_caption"));
                myPaper.setSz_scope(rs.getString("sz_scope"));
                myPaper.setSz_time_len(rs.getString("sz_time_len"));
                myPaper.setSz_person(rs.getString("sz_person"));
                myPaper.setTx_data(rs.getString("tx_data"));
                myPaper.setSz_file_store(rs.getString("sz_file_store"));
                myPaper.setSz_answer_store(rs.getString("sz_answer_store"));
                myPaper.setNt_section(rs.getInt("nt_section"));
                myPaper.setNt_grade(rs.getInt("nt_grade"));
                myPaper.setNt_total(rs.getInt("nt_total"));
                myPaper.setNt_download_times(rs.getInt("nt_download_times"));
                myPaper.setNt_title_bar(rs.getInt("nt_title_bar"));
                myPaper.setNt_info_bar(rs.getInt("nt_info_bar"));
                myPaper.setNt_input_bar(rs.getInt("nt_input_bar"));
                myPaper.setNt_tongfen_bar(rs.getInt("nt_tongfen_bar"));
                myPaper.setNt_show_answer(rs.getInt("nt_show_answer"));
                myPaper.setNt_show_defen(rs.getInt("nt_show_defen"));
                myPaper.setNt_file_kind(rs.getInt("nt_file_kind"));
                myPaper.setNt_pingfen_bar(rs.getInt("nt_pingfen_bar"));
                myPaper.setNt_page_size(rs.getInt("nt_page_size"));
                myPaper.setNt_state(rs.getInt("nt_state"));
                myPaper.setTs_finished(rs.getDate("ts_finished"));
                myPapers.add(myPaper);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myPapers;
    }

    public void save(List<MyPaper> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (MyPaper myPaper : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, myPaper.getNg_id());
                st.setLong(2, myPaper.getNg_user_id());
                st.setLong(3, myPaper.getNg_subject_id());
                st.setString(4, myPaper.getSz_caption());
                st.setString(5, myPaper.getSz_scope());
                st.setString(6, myPaper.getSz_time_len());
                st.setString(7, myPaper.getSz_person());
                st.setString(8, myPaper.getTx_data());
                st.setString(9, myPaper.getSz_file_store());
                st.setString(10, myPaper.getSz_answer_store());
                st.setInt(11, myPaper.getNt_section());
                st.setInt(12, myPaper.getNt_grade());
                st.setInt(13, myPaper.getNt_total());
                st.setInt(14, myPaper.getNt_download_times());
                st.setInt(15, myPaper.getNt_title_bar());
                st.setInt(16, myPaper.getNt_info_bar());
                st.setInt(17, myPaper.getNt_input_bar());
                st.setInt(18, myPaper.getNt_tongfen_bar());
                st.setInt(19, myPaper.getNt_show_answer());
                st.setInt(20, myPaper.getNt_show_defen());
                st.setInt(21, myPaper.getNt_file_kind());
                st.setInt(22, myPaper.getNt_pingfen_bar());
                st.setInt(23, myPaper.getNt_page_size());
                st.setInt(24, myPaper.getNt_state());
                if (myPaper.getTs_finished() == null) {
                    st.setDate(25, null);
                } else {
                    st.setDate(25, new java.sql.Date(myPaper.getTs_finished().getTime()));
                }


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
