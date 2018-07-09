package test;

import dao.*;
import entity.*;

import java.util.List;

public class ExamKindTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        ExamKindDao examKindDao = new ExamKindDao();

        List<ExamKind> examKinds = examKindDao.queryAll();

        examKindDao.save(examKinds);

    }
}

