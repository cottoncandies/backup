package test;

import dao.*;
import entity.*;

import java.util.List;

public class FavoriteTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        FavoriteDao favoriteDao = new FavoriteDao();

        List<Favorite> favorites = favoriteDao.queryAll();

        favoriteDao.save(favorites);

    }
}

