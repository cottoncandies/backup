package test;

import dao.*;
import entity.*;

import java.util.List;

public class PapaerExamTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        PaperExamDao paperExamDao = new PaperExamDao();

        List<PaperExam> paperExams = paperExamDao.queryAll();

        paperExamDao.save(paperExams);

    }
}

