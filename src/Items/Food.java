package Items;
import Characters.Character;

public class Food extends Item{

    private final int HEAL;

    public Food(String name, int weight, int heal, String description) {
        super(name, weight, description);
        this.HEAL = heal;
    }

    public int getHEAL(){
        return this.HEAL;
    }

    public void heal(Character character) {
        /*if(character instanceof Helper){
            System.out.println("You're trying to attack a defenseless character.");
            // scanner demande utilisateur pour le tuer quand même ?
        }else{
            character.attack(this.Damage);
        }*/
        character.restorePv(this.HEAL);
    }

}
