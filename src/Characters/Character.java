package Characters;

public abstract class Character {

    protected final String NAME;
    protected int pv;
    protected int strength;


    public Character(String name, int pv, int strength) {
        this.NAME = name;
        this.pv = pv;
        this.strength = strength;
    }

    public int getPv() {
        return this.pv;
    }
    public void setPv(int pv) { this.pv = pv ;}

    abstract public void speek();

    public void takeDamage(int damage){
        if(this.pv > 0){
            this.pv -= damage;
        }else{
            System.out.println("The target is already dead.");
        }
    }


}
