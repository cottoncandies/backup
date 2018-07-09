package test;

import dao.*;
import entity.*;

import java.util.List;

public class ExamTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamDao examDao = new ExamDao();

        //List<Exam> exams = examDao.queryAll();

        System.out.println(examDao.queryCount());

        //examDao.save(exams);

    }
}

