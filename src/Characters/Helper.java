package Characters;

import java.sql.SQLOutput;
import java.util.Objects;

public class Helper extends Character {

    public Helper(String name, String speach){
        super(name, 1, 0, speach);
    }

    @Override
    public void attack(Character character) {
        System.out.println("Im " + this.getNAME() + " I can't attack!");
    }

    public void giveClue(){
        if(Objects.equals(this.NAME, "Sage")){
            System.out.println("im sage Take this clue : blablabla");
        }
        else if(Objects.equals(this.NAME, "drunkard")){
            System.out.println("im drunkard Take this clue : blablabla");
        }
        else{
            System.out.println("This character doesn't exist!");
        }
    }
}
