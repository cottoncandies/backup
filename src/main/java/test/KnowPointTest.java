package test;

import dao.*;
import entity.*;

import java.util.List;

public class KnowPointTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        KnowPointDao knowPointDao = new KnowPointDao();

        List<KnowPoint> knowPoints = knowPointDao.queryAll();

        knowPointDao.save(knowPoints);

    }
}

