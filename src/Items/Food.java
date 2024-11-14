package Items;
import java.util.Random;

public class Food extends Item{

    private int Heal;

    public Food(String name, int heal){
        super(name);
        this.Heal = heal;
    }

    public int getHeal(){
        return this.Heal;
    }

}
