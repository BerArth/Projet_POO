package Characters;

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
            System.out.println("Hello little hero,\nTo go outside you have to find the answer to the universe, life and everything.");
        }
        else if(Objects.equals(this.NAME, "Reynold the Drunkard")){
            System.out.println("1234 one is correct and one is at the wrong place \n5703 nothing is correct \n4261 three are at the wrong place\n1845 two are correct");
        }
        else{
            System.out.println("This character doesn't exist!");
        }
    }
}
