package test;

import util.CopyUtil;

public class UserTest {


    static String selectSql = "SELECT * FROM sys_user_t";
    static String insertSql = "insert into sys_user_t(ng_id,sz_username,sz_password,nt_section,ng_subject_id,sz_nickname) " +
            "values(?,?,?,?,?,?)";


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {

        CopyUtil.copy(selectSql, insertSql);

    }
}

