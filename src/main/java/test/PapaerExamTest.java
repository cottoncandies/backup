package test;

import dao.PaperExamDao;

public class PapaerExamTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        PaperExamDao paperExamDao = new PaperExamDao();

        paperExamDao.backup();

    }
}

