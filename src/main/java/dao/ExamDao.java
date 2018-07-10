package dao;


import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDao {

    String selectSql = "SELECT * FROM sys_exam_t";
    String insertSql = "insert ignore into sys_exam_t(ng_id,ng_parent_id,ng_cat_id,ng_subject_id,ng_kind_id, sz_cat_full,  sz_prov, sz_city, sz_infor_src, sz_age, sz_infor_kind,  sz_wenli, sz_must,  sz_chart_kind, sz_paper_num,  sz_pager_level,  sz_paper_age, sz_paper_index,  tx_keywords, sz_listen,  tx_comment,  sz_kp_cap2,  tx_comment2, tx_err_descr,  sz_old_textbook, sz_chapter, sz_segment,  sz_edition, sz_kind_name,  sz_abi_cap, sz_kp_cap, tx_mingti,  tx_answer, tx_xuanxiang,  tx_jiexi, tx_tigan,  nt_num, nt_parent_num,  nt_sub_index,  nt_section,  nt_grade,  nt_term,  nt_deep,  nt_read_time,  nt_answer_time,  nt_score,  nt_objective,  nt_infor_trans,  nt_in_paper,  nt_view_times, nt_using_times,  nt_audit,  nt_state, ts_created, ts_updated, ts_auditing) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public void backup() {

        Connection postgresqlConn = null;
        Connection mysqlConn = null;

        PreparedStatement PostgresqlPstm = null;
        PreparedStatement mysqlPstm = null;

        ResultSet rs = null;

        int count = 0;

        try {
            //1.获取Connection连接
            postgresqlConn = PostgresqlUtil.getConnection();
            mysqlConn = MysqlUtil.getConnection();

            //设置AutoCommit属性为false,这个一定要用
            //配合设置setFetchSize(10)   setFetchDirection(ResultSet.FETCH_FORWARD)等属性
            //避免大量数据读写时出现java.lang.OutOfMemoryError: Java heap space
            postgresqlConn.setAutoCommit(false);
            mysqlConn.setAutoCommit(false);


            // 2.获取SQL执行者
            PostgresqlPstm = postgresqlConn.prepareStatement(selectSql, ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            PostgresqlPstm.setFetchSize(1000);
            PostgresqlPstm.setFetchDirection(ResultSet.FETCH_FORWARD);

            mysqlPstm = mysqlConn.prepareStatement(insertSql);


            // 3.执行sql语句
            rs = PostgresqlPstm.executeQuery();

            while (rs.next()) {
                count++;
                mysqlPstm.setLong(1, rs.getLong("ng_id"));
                mysqlPstm.setLong(2, rs.getLong("ng_parent_id"));
                mysqlPstm.setLong(3, rs.getLong("ng_cat_id"));
                mysqlPstm.setLong(4, rs.getLong("ng_subject_id"));
                mysqlPstm.setLong(5, rs.getLong("ng_kind_id"));
                mysqlPstm.setString(6, rs.getString("sz_cat_full"));
                mysqlPstm.setString(7, rs.getString("sz_prov"));
                mysqlPstm.setString(8, rs.getString("sz_city"));
                mysqlPstm.setString(9, rs.getString("sz_infor_src"));
                mysqlPstm.setString(10, rs.getString("sz_age"));
                mysqlPstm.setString(11, rs.getString("sz_infor_kind"));
                mysqlPstm.setString(12, rs.getString("sz_wenli"));
                mysqlPstm.setString(13, rs.getString("sz_must"));
                mysqlPstm.setString(14, rs.getString("sz_chart_kind"));
                mysqlPstm.setString(15, rs.getString("sz_paper_num"));
                mysqlPstm.setString(16, rs.getString("sz_pager_level"));
                mysqlPstm.setString(17, rs.getString("sz_paper_age"));
                mysqlPstm.setString(18, rs.getString("sz_paper_index"));
                mysqlPstm.setString(19, rs.getString("tx_keywords"));
                mysqlPstm.setString(20, rs.getString("sz_listen"));
                mysqlPstm.setString(21, rs.getString("tx_comment"));
                mysqlPstm.setString(22, rs.getString("sz_kp_cap2"));
                mysqlPstm.setString(23, rs.getString("tx_comment2"));
                mysqlPstm.setString(24, rs.getString("tx_err_descr"));
                mysqlPstm.setString(25, rs.getString("sz_old_textbook"));
                mysqlPstm.setString(26, rs.getString("sz_chapter"));
                mysqlPstm.setString(27, rs.getString("sz_segment"));
                mysqlPstm.setString(28, rs.getString("sz_edition"));
                mysqlPstm.setString(29, rs.getString("sz_kind_name"));
                mysqlPstm.setString(30, rs.getString("sz_abi_cap"));
                mysqlPstm.setString(31, rs.getString("sz_kp_cap"));
                mysqlPstm.setString(32, rs.getString("tx_mingti"));
                mysqlPstm.setString(33, rs.getString("tx_answer"));
                mysqlPstm.setString(34, rs.getString("tx_xuanxiang"));
                mysqlPstm.setString(35, rs.getString("tx_jiexi"));
                mysqlPstm.setString(36, rs.getString("tx_tigan"));
                mysqlPstm.setInt(37, rs.getInt("nt_num"));
                mysqlPstm.setInt(38, rs.getInt("nt_parent_num"));
                mysqlPstm.setInt(39, rs.getInt("nt_sub_index"));
                mysqlPstm.setInt(40, rs.getInt("nt_section"));
                mysqlPstm.setInt(41, rs.getInt("nt_grade"));
                mysqlPstm.setInt(42, rs.getInt("nt_term"));
                mysqlPstm.setInt(43, rs.getInt("nt_deep"));
                mysqlPstm.setInt(44, rs.getInt("nt_read_time"));
                mysqlPstm.setInt(45, rs.getInt("nt_answer_time"));
                mysqlPstm.setInt(46, rs.getInt("nt_score"));
                mysqlPstm.setInt(47, rs.getInt("nt_objective"));
                mysqlPstm.setInt(48, rs.getInt("nt_infor_trans"));
                mysqlPstm.setInt(49, rs.getInt("nt_in_paper"));
                mysqlPstm.setInt(50, rs.getInt("nt_view_times"));
                mysqlPstm.setInt(51, rs.getInt("nt_using_times"));
                mysqlPstm.setInt(52, rs.getInt("nt_audit"));
                mysqlPstm.setInt(53, rs.getInt("nt_state"));
                mysqlPstm.setDate(54, rs.getDate("ts_created"));
                mysqlPstm.setDate(55, rs.getDate("ts_updated"));
                mysqlPstm.setDate(56, rs.getDate("ts_auditing"));

                mysqlPstm.addBatch();

                if (count % 5000 == 0) {
                    mysqlPstm.executeBatch();
                    mysqlConn.commit();
                    mysqlPstm.clearBatch();        //提交后，Batch清空。
                }
            }
            mysqlPstm.executeBatch();
            //优化插入第三步       提交，批量插入数据库中。
            mysqlConn.commit();
            mysqlPstm.clearBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
            try {
                PostgresqlUtil.close(postgresqlConn, rs, PostgresqlPstm);
                MysqlUtil.close(mysqlConn, mysqlPstm);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
