package test;

import dao.BookCatalogDao;

public class BookCatalogTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        BookCatalogDao bookCatalogDao = new BookCatalogDao();

        bookCatalogDao.backup();

    }
}

