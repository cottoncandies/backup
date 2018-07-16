package test;

import dao.userDao;

public class userTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        userDao userDao = new userDao();

        userDao.backup();

    }
}

