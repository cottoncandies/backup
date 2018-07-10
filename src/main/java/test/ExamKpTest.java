package test;

import dao.ExamKpDao;

public class ExamKpTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamKpDao examKpDao = new ExamKpDao();

        examKpDao.backup();

    }
}

