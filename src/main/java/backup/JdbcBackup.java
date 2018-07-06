package backup;

import entity.Paper;
import entity.Subject;
import entity.User;
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

        //从postgresql数据库读取数据
        List<Paper> papers = ReadFromPostgresql.getPapers();
        //写入mysql数据库
        for (Paper paper : papers) {
            //WriteToMysql.addPaper(paper);
            System.out.println(paper);
        }
    }
}
