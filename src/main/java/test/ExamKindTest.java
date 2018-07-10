package test;

import dao.ExamKindDao;

public class ExamKindTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamKindDao examKindDao = new ExamKindDao();

        examKindDao.backup();

    }
}

