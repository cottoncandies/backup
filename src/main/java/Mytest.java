import dao.*;
import entity.*;

import java.util.List;

public class Mytest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {
        //AbilityDao abilityDao = new AbilityDao();
        BookCatalogDao bookCatalogDao = new BookCatalogDao();
        ExamAbiDao examAbiDao = new ExamAbiDao();
        ExamDao examDao = new ExamDao();
        ExamKindDao examKindDao = new ExamKindDao();
        ExamKpDao examKpDao = new ExamKpDao();
        FavoriteDao favoriteDao = new FavoriteDao();
        KnowPointDao knowPointDao = new KnowPointDao();
        MyPaperDao myPaperDao = new MyPaperDao();
        PaperDao paperDao = new PaperDao();
        PaperExamDao paperExamDao = new PaperExamDao();
        SubjectDao subjectDao = new SubjectDao();
        UserDao userDao = new UserDao();



        //List<Ability> abilities = abilityDao.queryAll();
        List<BookCatalog> bookCatalogs = bookCatalogDao.queryAll();
        List<ExamAbi> examAbis = examAbiDao.queryAll();
        List<ExamKind> examKinds = examKindDao.queryAll();
        List<ExamKp> examKps = examKpDao.queryAll();
        List<Favorite> favorites = favoriteDao.queryAll();
        List<KnowPoint> knowPoints = knowPointDao.queryAll();
        List<MyPaper> myPapers = myPaperDao.queryAll();
        List<Paper> papers = paperDao.queryAll();
        List<PaperExam> paperExams = paperExamDao.queryAll();
        List<Subject> subjects = subjectDao.queryAll();
        //List<User> users = userDao.queryAll();






        //abilityDao.save(abilities);
        bookCatalogDao.save(bookCatalogs);
        examAbiDao.save(examAbis);
        examKindDao.save(examKinds);
        examKpDao.save(examKps);
        favoriteDao.save(favorites);
        knowPointDao.save(knowPoints);
        myPaperDao.save(myPapers);
        paperDao.save(papers);
        paperExamDao.save(paperExams);
        subjectDao.save(subjects);
        //userDao.save(users);
    }
}

