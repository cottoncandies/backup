package dao;

import entity.BookCatalog;
import util.MysqlUtil;
import util.PostgresqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookCatalogDao implements BaseDao<BookCatalog> {


    String selectSql = "SELECT * FROM sys_book_catalog_t";
    String insertSql = "insert into sys_book_catalog_t(ng_id,sz_num,sz_parent_num,sz_caption,ng_parent_id,nt_section,ng_subject_id,nt_grade,nt_serial,sz_descr,nt_show,tx_comment,nt_old_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public List<BookCatalog> queryAll() {
        List<BookCatalog> bookCatalogs = null;
        BookCatalog bookCatalog = null;

        try {
            //1.获取postgresql连接
            Connection conn = PostgresqlUtil.getConnection();

            // 2.获取SQL执行者
            PreparedStatement st = conn.prepareStatement(selectSql);

            // 3.执行sql语句
            ResultSet rs = st.executeQuery();

            // 4.处理数据
            bookCatalogs = new ArrayList<BookCatalog>();
            while (rs.next()) {
                bookCatalog = new BookCatalog();
                bookCatalog.setNg_id(rs.getLong("ng_id"));
                bookCatalog.setSz_num(rs.getString("sz_num"));
                bookCatalog.setSz_parent_num(rs.getString("sz_parent_num"));
                bookCatalog.setSz_caption(rs.getString("sz_caption"));
                bookCatalog.setNg_parent_id(rs.getLong("ng_parent_id"));
                bookCatalog.setNt_section(rs.getInt("nt_section"));
                bookCatalog.setNg_subject_id(rs.getLong("ng_subject_id"));
                bookCatalog.setNt_grade(rs.getInt("nt_grade"));
                bookCatalog.setNt_serial(rs.getInt("nt_serial"));
                bookCatalog.setSz_descr(rs.getString("sz_descr"));
                bookCatalog.setNt_show(rs.getInt("nt_show"));
                bookCatalog.setTx_comment(rs.getString("tx_comment"));
                bookCatalog.setNt_old_id(rs.getInt("nt_old_id"));
                bookCatalogs.add(bookCatalog);
            }

            // 5.释放资源
            PostgresqlUtil.close(conn, rs, st);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookCatalogs;
    }

    public void save(List<BookCatalog> list) {
        try {
            //1.获取mysql连接
            Connection conn = MysqlUtil.getConnection();

            PreparedStatement st = null;

            for (BookCatalog bookCatalog : list) {

                // 2.获取SQL执行者
                st = conn.prepareStatement(insertSql);

                st.setLong(1, bookCatalog.getNg_id());
                st.setString(2, bookCatalog.getSz_num());
                st.setString(3, bookCatalog.getSz_parent_num());
                st.setString(4, bookCatalog.getSz_caption());
                st.setLong(5, bookCatalog.getNg_parent_id());
                st.setInt(6, bookCatalog.getNt_section());
                st.setLong(7, bookCatalog.getNg_subject_id());
                st.setInt(8, bookCatalog.getNt_grade());
                st.setInt(9, bookCatalog.getNt_serial());
                st.setString(10, bookCatalog.getSz_descr());
                st.setInt(11, bookCatalog.getNt_show());
                st.setString(12, bookCatalog.getTx_comment());
                st.setInt(13, bookCatalog.getNt_old_id());


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
