package dao;

import entity.Ability;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AbilityDao implements BaseDao<Ability> {

    String selectSql = "SELECT * FROM sys_ability_t";
    String insertSql = "insert into sys_ability_t(ng_id,nt_section,ng_subject_id,sz_caption,nt_state,tx_comment,nt_old_id) values(?,?,?,?,?,?,?)";

    public List<Ability> queryAll() {

        List<Ability> abilities = null;
        Ability ability = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            abilities = new ArrayList<Ability>();
            while (rs.next()) {
                ability = new Ability();
                ability.setNg_id(rs.getLong("ng_id"));
                ability.setSz_caption(rs.getString("sz_caption"));
                ability.setNg_subject_id(rs.getLong("ng_subject_id"));
                ability.setNt_section(rs.getInt("nt_section"));
                ability.setNt_state(rs.getInt("nt_state"));
                ability.setTx_comment(rs.getString("tx_comment"));
                ability.setNt_old_id(rs.getInt("nt_old_id"));
                abilities.add(ability);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return abilities;
    }

    public void save(List<Ability> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (Ability ability : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, ability.getNg_id());
                st.setInt(2, ability.getNt_section());
                st.setLong(3, ability.getNg_subject_id());
                st.setString(4, ability.getSz_caption());
                st.setInt(5, ability.getNt_state());
                st.setString(6, ability.getTx_comment());
                st.setInt(7, ability.getNt_old_id());

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
