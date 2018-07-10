package test;

import dao.FavoriteDao;

public class FavoriteTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        FavoriteDao favoriteDao = new FavoriteDao();

        favoriteDao.backup();

    }
}

