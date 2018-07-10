package test;

import dao.SubjectDao;

public class SubjectTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        SubjectDao subjectDao = new SubjectDao();

        subjectDao.backup();
    }
}

