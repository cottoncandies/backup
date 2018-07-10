package test;

import dao.PaperDao;

public class PaperTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        PaperDao paperDao = new PaperDao();

        paperDao.backup();

    }
}

