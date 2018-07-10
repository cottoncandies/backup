package test;

import dao.KnowPointDao;

public class KnowPointTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        KnowPointDao knowPointDao = new KnowPointDao();

        knowPointDao.backup();

    }
}

