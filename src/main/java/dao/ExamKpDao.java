package dao;

import entity.ExamKp;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamKpDao implements BaseDao<ExamKp> {

    String sleectSql = "SELECT * FROM sys_examkp_t";
    String insertSql = "insert into sys_examkp_t(ng_id,ng_exam_id,ng_kp_id,nt_old_id) values(?,?,?,?)";

    public List<ExamKp> queryAll() {
        List<ExamKp> examKps = null;
        ExamKp examKp = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(sleectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            examKps = new ArrayList<ExamKp>();
            while (rs.next()) {
                examKp = new ExamKp();
                examKp.setNg_id(rs.getLong("ng_id"));
                examKp.setNg_exam_id(rs.getLong("ng_exam_id"));
                examKp.setNg_kp_id(rs.getLong("ng_kp_id"));
                examKp.setNt_old_id(rs.getInt("nt_old_id"));
                examKps.add(examKp);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return examKps;
    }

    public void save(List<ExamKp> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (ExamKp examKp : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, examKp.getNg_id());
                st.setLong(2, examKp.getNg_exam_id());
                st.setLong(3, examKp.getNg_kp_id());
                st.setInt(4, examKp.getNt_old_id());


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
