import Characters.*;
import Items.Bag;
import Items.Food;
import Items.Weapon;

public class Main {
    public static void main(String[] args) {

        Helper h1 = new Helper("Saje", 0);
        Helper h2 = new Helper("Ivrogne", 1);
        Hero hero = new Hero("Michel");
        h1.speek();
        h2.speek();

        //test item
        Weapon w1 = new Weapon("Sword",40, 50);
        Food food = new Food("Potato",5, 10);
        Bag bag = new Bag("Bag", 10);

        h1.printStateHp();    // 100
        w1.attack(h1);
        h1.printStateHp();    // 50
        food.heal(h1);  // voir pour maxHP ?
        h1.printStateHp();    // 60


    }
}