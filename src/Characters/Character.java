package Characters;

public abstract class Character {

    protected final String NAME;
    protected int hp;
    protected int strength;
    protected final String SPEACH;
    protected final int MAX_HP;

    public Character(String name, int hp, int strength, String speach) {
        this.NAME = name;
        this.hp = hp;
        this.MAX_HP = hp;
        this.strength = strength;
        this.SPEACH = speach;
    }

    public int getHp() {
        return this.hp;
    }
    public String getNAME() { return this.NAME; }
    public int getStrength(){
        return this.strength;
    }

    public void speak(){
        System.out.println(SPEACH);
    }


    public void reducePv(int damage){
        if(this.hp > 0){
            this.hp -= damage;
            if(this.hp < 0){
                this.hp = 0;
            }
        }
        else{
            System.out.println("The target is already dead.");
        }
    }

    public boolean isDead(){
        return (this.getHp() == 0);
    }


    public void restorePv(int heal){
        if(this.hp > 0){
            if(this.hp + heal > this.MAX_HP){
                this.hp = this.MAX_HP;
            }else {
                this.hp += heal;
            }
        }else{
            System.out.println("The target is dead.");
        }
    }

    public void printStateHp(){
        System.out.println(this.NAME +" have: " + this.hp + " HP.\n");
    }


    public void attack(Character target){
        target.reducePv(this.getStrength());
    }

}
