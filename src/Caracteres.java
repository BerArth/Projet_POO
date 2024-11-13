abstract class Caracteres {

    protected final String NAME;
    protected int pv;
    protected int strength;

    public Caracteres(String name, int pv, int strength) {
        this.NAME = name;
        this.pv = pv;
        this.strength = strength;
    }

    abstract void speek();

    public void attack(Caracteres target){
        if(target.pv > 0){
            target.pv -= this.strength;
        }else{
            System.out.println("Target has no life");
        }

    }

}
