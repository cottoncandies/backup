package dao;

import entity.User;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<User> {

    String sleectSql = "SELECT * FROM sys_user_t";
    String insertSql = "insert into sys_user_t(ng_id,sz_username,sz_password,nt_section,ng_subject_id,sz_nickname) values(?,?,?,?,?,?)";

    public List<User> queryAll() {
        List<User> users = null;
        User user = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(sleectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            users = new ArrayList<User>();
            while (rs.next()) {
                user = new User();
                user.setNg_id(rs.getLong("ng_id"));
                user.setSz_username(rs.getString("sz_username"));
                user.setSz_password(rs.getString("sz_password"));
                user.setNt_section(rs.getInt("nt_section"));
                user.setNg_subject_id(rs.getLong("ng_subject_id"));
                user.setSz_nickname(rs.getString("sz_nickname"));
                users.add(user);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void save(List<User> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (User user : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, user.getNg_id());
                st.setString(2, user.getSz_username());
                st.setString(3, user.getSz_password());
                st.setInt(4, user.getNt_section());
                st.setLong(5, user.getNg_subject_id());
                st.setString(6, user.getSz_nickname());

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
