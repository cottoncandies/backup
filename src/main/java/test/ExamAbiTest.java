package test;

import dao.ExamAbiDao;

public class ExamAbiTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamAbiDao examAbiDao = new ExamAbiDao();

        examAbiDao.backup();

    }
}

