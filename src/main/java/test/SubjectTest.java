package test;

import dao.*;
import entity.*;

import java.util.List;

public class SubjectTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        SubjectDao subjectDao = new SubjectDao();

        List<Subject> subjects = subjectDao.queryAll();

        subjectDao.save(subjects);
    }
}

