package Items;
import Characters.Character;

public class Food extends Item{

    private int heal;

    public Food(String name, int weight, int heal) {
        super(name, weight);
        this.heal = heal;
    }

    public int getHeal(){
        return this.heal;
    }

    public void heal(Character character) {
        /*if(character instanceof Helper){
            System.out.println("You're trying to attack a defenseless character.");
            // scanner demande utilisateur pour le tuer quand même ?
        }else{
            character.attack(this.Damage);
        }*/
        character.restorePv(this.heal);
    }

}
