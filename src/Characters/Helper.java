package Characters;

import java.sql.SQLOutput;

public class Helper extends Character {

    public Helper(String name, String speach){
        super(name, 1, 0, speach);
    }

    @Override
    public void attack(Character character) {
        System.out.println("Im " + this.getNAME() + " I can't attack!");
    }
}
