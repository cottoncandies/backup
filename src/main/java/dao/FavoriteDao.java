package dao;


import entity.Favorite;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDao {

    String selectSql = "SELECT * FROM sys_favorite_t";
    String insertSql = "insert into sys_favorite_t(ng_id,ng_user_id,ng_subject_id,ng_exam_id,nt_section,ts_created) values(?,?,?,?,?,?)";

    public List<Favorite> queryAll() {
        List<Favorite> favorites = null;
        Favorite favorite = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            favorites = new ArrayList<Favorite>();
            while (rs.next()) {
                favorite = new Favorite();
                favorite.setNg_id(rs.getLong("ng_id"));
                favorite.setNg_user_id(rs.getLong("ng_user_id"));
                favorite.setNg_subject_id(rs.getLong("ng_subject_id"));
                favorite.setNg_exam_id(rs.getLong("ng_exam_id"));
                favorite.setNt_section(rs.getInt("nt_section"));
                favorite.setTs_created(rs.getDate("ts_created"));
                favorites.add(favorite);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return favorites;
    }

    public void save(List<Favorite> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (Favorite favorite : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, favorite.getNg_id());
                st.setLong(2, favorite.getNg_user_id());
                st.setLong(3, favorite.getNg_subject_id());
                st.setLong(4, favorite.getNg_exam_id());
                st.setInt(5, favorite.getNt_section());
                st.setDate(6, new java.sql.Date(favorite.getTs_created().getTime()));


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
