package dao;

import entity.ExamAbi;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamAbiDao implements BaseDao<ExamAbi>{

    String sleectSql = "SELECT * FROM sys_examabi_t";
    String insertSql = "insert into sys_examabi_t(ng_id,ng_exam_id,ng_abi_id) values(?,?,?)";

    public List<ExamAbi> queryAll() {
        List<ExamAbi> examAbis = null;
        ExamAbi examAbi = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(sleectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            examAbis = new ArrayList<ExamAbi>();
            while (rs.next()) {
                examAbi = new ExamAbi();
                examAbi.setNg_id(rs.getLong("ng_id"));
                examAbi.setNg_exam_id(rs.getLong("ng_exam_id"));
                examAbi.setNg_abi_id(rs.getLong("ng_abi_id"));
                examAbis.add(examAbi);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return examAbis;
    }

    public void save(List<ExamAbi> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (ExamAbi examAbi : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, examAbi.getNg_id());
                st.setLong(2, examAbi.getNg_exam_id());
                st.setLong(3, examAbi.getNg_abi_id());


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
