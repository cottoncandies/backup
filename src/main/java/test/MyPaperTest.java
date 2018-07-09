package test;

import dao.*;
import entity.*;

import java.util.List;

public class MyPaperTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        MyPaperDao myPaperDao = new MyPaperDao();

        List<MyPaper> myPapers = myPaperDao.queryAll();

        myPaperDao.save(myPapers);

    }
}

