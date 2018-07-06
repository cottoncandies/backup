package backup;

import entity.*;
import mysql.WriteToMysql;
import postgresql.ReadFromPostgresql;

import java.util.List;

public class JdbcBackup {

    public static void main(String[] args) {
       /* //从postgresql数据库读取数据
        List<User> users = ReadFromPostgresql.getUsers();
        //写入mysql数据库
        for (User user : users) {
            WriteToMysql.addUser(user);
        }*/

/*        //从postgresql数据库读取数据
        List<Subject> subjects = ReadFromPostgresql.getSubjects();
        //写入mysql数据库
        for (Subject subject : subjects) {
            WriteToMysql.addSubject(subject);
        }*/

//        //从postgresql数据库读取数据
//        List<Paper> papers = ReadFromPostgresql.getPapers();
//        //写入mysql数据库
//        for (Paper paper : papers) {
//            WriteToMysql.addPaper(paper);
//        }
        //从postgresql数据库读取数据
//        List<Ability> abilitys = ReadFromPostgresql.getAbilitys();
//        //写入mysql数据库
//        for (Ability ability : abilitys) {
//            WriteToMysql.addAbility(ability);
//        }

        List<BookCatalog> bookCatalogs = ReadFromPostgresql.getBookCatalogs();
        //写入mysql数据库
        for (BookCatalog bookCatalog : bookCatalogs) {
            WriteToMysql.addBookCatalog(bookCatalog);
        }
    }
}
