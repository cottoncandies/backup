import dao.AbilityDao;
import entity.Ability;

import java.util.List;

public class Mytest {


    public static void main(String[] args) {
        selectFunction();
    }

    public static void selectFunction() {
        AbilityDao dao = new AbilityDao();
        List<Ability> abilities = dao.queryAll();
        for (Ability a : abilities) {
            System.out.println(a);
        }
        //List<Ability> abilities = Arrays.asList(new Ability(1L, 1, 1L, "1", 1,"1", 1),new Ability(2L, 1, 1L, "1", 1,"1", 1));
        dao.save(abilities);
    }
}

