package Characters;

import java.sql.SQLOutput;
import java.util.Objects;

public abstract class Character {

    protected final String NAME;
    protected int hp;
    protected int strength;

    public Character(String name, int hp, int strength) {
        this.NAME = name;
        this.hp = hp;
        this.strength = strength;
    }

    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) { this.hp = hp; }
    public String getNAME() { return this.NAME; }
    public int getStrength(){
        return this.strength;
    }

    abstract public void speek();

    public void reducePv(int damage){
        if(this.hp > 0){
            this.hp -= damage;
        }else{
            System.out.println("The target is already dead.");
        }
    }

    public boolean isDead(){
        return (this.getHp() <= 0);
    }

    public void attack(Character target){
        if(!isDead()){
            target.reducePv(this.getStrength());
            if(target.getHp() <= 0){
                System.out.println("The target is dead.");
            }else {
                System.out.println("The target take " + this.getStrength() + " damage.");
            }
        }
    }

    public void restorePv(int heal){
        if(this.hp > 0){
            /* // dans le cas où on a un maxHP pour ne pas heal plus que le max
            if(this.hp + heal > this.maxHP){
                this.hp = this.maxHP;
            }else {*/
            this.hp += heal;
        }else{
            System.out.println("The target is dead.");
        }
    }

    public void printStateHp(){
        System.out.println(this.NAME +" have: " + this.hp + " HP.\n");
    }

    public void giveClue(Character speeker){
        if(speeker instanceof Helper){
            if(Objects.equals(speeker.getNAME(), "Saje")){
                System.out.println(this.getNAME() + " says : I'll give you a clue");
            }
        }
    }

}
