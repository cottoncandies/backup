package test;

import dao.*;
import entity.*;

import java.util.List;

public class BookCatalogTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        BookCatalogDao bookCatalogDao = new BookCatalogDao();

        List<BookCatalog> bookCatalogs = bookCatalogDao.queryAll();

        bookCatalogDao.save(bookCatalogs);

    }
}

