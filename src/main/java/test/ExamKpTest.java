package test;

import dao.*;
import entity.*;

import java.util.List;

public class ExamKpTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamKpDao examKpDao = new ExamKpDao();

        List<ExamKp> examKps = examKpDao.queryAll();

        examKpDao.save(examKps);

    }
}

