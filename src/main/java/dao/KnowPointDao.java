package dao;

import entity.KnowPoint;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KnowPointDao implements BaseDao<KnowPoint> {

    String selectSql = "SELECT * FROM sys_know_point_t";
    String insertSql = "insert into sys_know_point_t(ng_id,ng_parent_id,ng_subject_id,sz_num,sz_caption,tx_comment,nt_section,nt_state,nt_old_id) values(?,?,?,?,?,?,?,?,?)";

    public List<KnowPoint> queryAll() {
        List<KnowPoint> knowPoints = null;
        KnowPoint knowPoint = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            knowPoints = new ArrayList<KnowPoint>();
            while (rs.next()) {
                knowPoint = new KnowPoint();
                knowPoint.setNg_id(rs.getLong("ng_id"));
                knowPoint.setNg_parent_id(rs.getLong("ng_parent_id"));
                knowPoint.setNg_subject_id(rs.getLong("ng_subject_id"));
                knowPoint.setSz_num(rs.getString("sz_num"));
                knowPoint.setSz_caption(rs.getString("sz_caption"));
                knowPoint.setTx_comment(rs.getString("tx_comment"));
                knowPoint.setNt_section(rs.getInt("nt_section"));
                knowPoint.setNt_state(rs.getInt("nt_state"));
                knowPoint.setNt_old_id(rs.getInt("nt_old_id"));
                knowPoints.add(knowPoint);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return knowPoints;
    }

    public void save(List<KnowPoint> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (KnowPoint knowPoint : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, knowPoint.getNg_id());
                st.setLong(2, knowPoint.getNg_parent_id());
                st.setLong(3, knowPoint.getNg_subject_id());
                st.setString(4, knowPoint.getSz_num());
                st.setString(5, knowPoint.getSz_caption());
                st.setString(6, knowPoint.getTx_comment());
                st.setInt(7, knowPoint.getNt_section());
                st.setInt(8, knowPoint.getNt_state());
                st.setInt(9, knowPoint.getNt_old_id());

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
