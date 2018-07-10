package test;

import dao.MyPaperDao;
import entity.MyPaper;

import java.util.List;

public class MyPaperTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        MyPaperDao myPaperDao = new MyPaperDao();

        myPaperDao.backup();

    }
}

