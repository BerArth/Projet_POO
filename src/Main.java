import Characters.*;
import Items.Weapon;

public class Main {
    public static void main(String[] args) {

        Helper h1 = new Helper("Saje", 0);
        Helper h2 = new Helper("Ivrogne", 1);
        Weapon w1 = new Weapon("Epee", 50);
        h1.speek();
        h2.speek();

        //test item
        System.out.println("h1 pv : " + h1.getPv());    // 100
        w1.attack(h1);
        System.out.println("h1 pv : " + h1.getPv());    // 50


    }
}