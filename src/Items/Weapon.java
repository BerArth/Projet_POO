package Items;
import Characters.Character;
import Characters.Helper;

public class Weapon extends Item {

    private int Damage;

    public Weapon(String name, int damage) {
        super(name);
        this.Damage = damage;
    }

    public int getDamage() {
        return this.Damage;
    }
    public void setDamage(int damage) {
        this.Damage = damage;
    }


    public void attack(Character character) {
        /*if(character instanceof Helper){
            System.out.println("You're trying to attack a defenseless character.");
            // scanner demande utilisateur pour le tuer quand même ?
        }else{
            character.attack(this.Damage);
        }*/
        character.takeDamage(this.Damage);
    }

}
