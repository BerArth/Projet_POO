package Characters;

import java.sql.SQLOutput;

public class Helper extends Character {

    private final int loc;


    public Helper(String name, int loc){
        super(name, 100, 20);
        this.loc = loc;
    }


    @Override
    public void speek() {
        if(this.loc == 0){
            System.out.println("Bonjour je suis " + this.NAME + " je suis a la localisation Fontaine");
        }
        else if(this.loc == 1){
            System.out.println("Bonjour je suis " + this.NAME + " je suis a la localisation Bar");
        }
    }

    @Override
    public void attack(Character target) {
        System.out.println("I am helper i cant attack");
    }
}
