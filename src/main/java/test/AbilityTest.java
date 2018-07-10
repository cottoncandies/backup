package test;

import dao.AbilityDao;

public class AbilityTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {
        AbilityDao abilityDao = new AbilityDao();

        abilityDao.backup();

    }
}

