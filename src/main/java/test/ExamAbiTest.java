package test;

import dao.*;
import entity.*;

import java.util.List;

public class ExamAbiTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamAbiDao examAbiDao = new ExamAbiDao();

        List<ExamAbi> examAbis = examAbiDao.queryAll();

        examAbiDao.save(examAbis);

    }
}

