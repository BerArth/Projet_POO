package Items;
import Characters.Character;

public class Weapon extends Item {

    private int damage;

    public Weapon(String name, int weight, int damage, String description) {
        super(name, weight, description);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void attack(Character character) {
        /*if(character instanceof Helper){
            System.out.println("You're trying to attack a defenseless character.");
            // scanner demande utilisateur pour le tuer quand même ?
        }else{
            character.attack(this.damage);
        }*/
        character.reducePv(this.damage);
    }

}
