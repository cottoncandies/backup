package test;

import dao.ExamDao;

public class ExamTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamDao examDao = new ExamDao();

        examDao.backup();

    }
}

