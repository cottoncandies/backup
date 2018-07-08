package dao;

import entity.BookCatalog;

import java.util.List;

public class BookCatalogDao implements BaseDao<BookCatalog>{


    String sleectSql = "SELECT * FROM sys_bookcatalog_t";
    String insertSql = "insert into sys_bookcatalog_t(ng_id,nt_section,ng_subject_id,sz_caption,nt_state,tx_comment,nt_old_id) values(?,?,?,?,?,?,?)";

    public List<BookCatalog> queryAll() {
        return null;
    }

    public void save(List<BookCatalog> list) {

    }
}
