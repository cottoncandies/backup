package test;

import dao.*;
import entity.*;

import java.util.List;

public class PaperTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        PaperDao paperDao = new PaperDao();

        List<Paper> papers = paperDao.queryAll();

        paperDao.save(papers);

    }
}

