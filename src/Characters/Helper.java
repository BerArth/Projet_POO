package Characters;

import java.sql.SQLOutput;

public class Helper extends Character {

    public Helper(String name, String speach){
        super(name, 1, 0, speach);
    }


    @Override
    public void attack(Character target) {
        System.out.println("I am helper i cant attack");
    }
}
