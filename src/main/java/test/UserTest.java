package test;

import dao.UserDao;

public class UserTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        UserDao userDao = new UserDao();

        userDao.backup();

    }
}

