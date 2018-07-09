package test;

import dao.*;
import entity.*;

import java.util.List;

public class AbilityTest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {
        AbilityDao abilityDao = new AbilityDao();

        List<Ability> abilities = abilityDao.queryAll();

        abilityDao.save(abilities);

    }
}

