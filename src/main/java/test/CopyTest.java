package test;

import util.CopyUtil;

public class CopyTest {
//
//    String selectSql = "SELECT * FROM sys_ability_t";
//    String insertSql = "insert into sys_ability_t(ng_id,nt_section,ng_subject_id,sz_caption,nt_state,tx_comment,nt_old_id) values(?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_book_catalog_t";
//    String insertSql = "insert into sys_book_catalog_t(ng_id,sz_num,sz_parent_num,sz_caption,ng_parent_id,nt_section,ng_subject_id,nt_grade,nt_serial,sz_descr,nt_show,tx_comment,nt_old_id) " +
//            "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_exam_abi_t";
//    String insertSql = "insert into sys_exam_abi_t(ng_id,ng_exam_id,ng_abi_id) values(?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_exam_t";
//    String insertSql = "insert ignore into sys_exam_t(ng_id,ng_parent_id,ng_cat_id,ng_subject_id,ng_kind_id, sz_cat_full,  sz_prov, sz_city, sz_infor_src, sz_age, sz_infor_kind,  sz_wenli, sz_must,  sz_chart_kind, sz_paper_num,  sz_pager_level,  sz_paper_age, sz_paper_index,  tx_keywords, sz_listen,  tx_comment,  sz_kp_cap2,  tx_comment2, tx_err_descr,  sz_old_textbook, sz_chapter, sz_segment,  sz_edition, sz_kind_name,  sz_abi_cap, sz_kp_cap, tx_mingti,  tx_answer, tx_xuanxiang,  tx_jiexi, tx_tigan,  nt_num, nt_parent_num,  nt_sub_index,  nt_section,  nt_grade,  nt_term,  nt_deep,  nt_read_time,  nt_answer_time,  nt_score,  nt_objective,  nt_infor_trans,  nt_in_paper,  nt_view_times, nt_using_times,  nt_audit,  nt_state, ts_created, ts_updated, ts_auditing) " +
//            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_exam_kp_t";
//    String insertSql = "insert into sys_exam_kp_t(ng_id,ng_exam_id,ng_kp_id,nt_old_id) values(?,?,?,?)";
//
//
//    String selectSql = "SELECT * FROM sys_exam_kind_t";
//    String insertSql = "insert into sys_exam_kind_t(ng_id,ng_subject_id,nt_section,nt_state,nt_old_id,sz_caption,tx_comment) values(?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_favorite_t";
//    String insertSql = "insert into sys_favorite_t(ng_id,ng_user_id,ng_subject_id,ng_exam_id,nt_section,ts_created) values(?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_know_point_t";
//    String insertSql = "insert into sys_know_point_t(ng_id,ng_parent_id,ng_subject_id,sz_num,sz_caption,tx_comment,nt_section,nt_state,nt_old_id) values(?,?,?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_my_paper_t";
//    String insertSql = "insert into sys_my_paper_t(ng_id,ng_user_id,ng_subject_id, sz_caption, sz_scope, sz_time_len, sz_person, tx_data,  sz_file_store,  sz_answer_store, nt_section,  nt_grade, nt_total, nt_download_times,  nt_title_bar,  nt_info_bar,  nt_input_bar,  nt_tongfen_bar,  nt_show_answer,  nt_show_defen,  nt_file_kind,  nt_pingfen_bar,  nt_page_size,  nt_state,  ts_finished) " +
//            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_paper_t";
//    String insertSql = "insert into sys_paper_t(ng_id,sz_num,sz_caption,sz_kind,sz_age,ng_cat_id,nt_section,ng_subject_id,sz_wenli,sz_prov,sz_city,nt_term,nt_grade,nt_score,nt_score_ex,nt_cost_resp,ts_created,ts_updated,ts_auditing,tx_comment,sz_infor_src,sz_infor_kind,nt_old_id) " +
//            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_paper_exam_t";
//    String insertSql = "insert into sys_paper_exam_t(ng_id,ng_paper_id,ng_exam_id,nt_index,nt_old_id,sz_kind,tx_comment) values(?,?,?,?,?,?,?)";
//
//    String selectSql = "SELECT * FROM sys_subject_t";
//    String insertSql = "insert into sys_subject_t(ng_id,sz_caption,sz_sections) values(?,?,?)";

    static String selectSql = "SELECT * FROM sys_user_t";
    static String insertSql = "insert into sys_user_t(ng_id,sz_username,sz_password,nt_section,ng_subject_id,sz_nickname) " +
            "values(?,?,?,?,?,?)";

    public static void main(String[] args) {

        CopyUtil.copy(selectSql, insertSql);

    }


}

