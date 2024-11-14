package Caracteres;

abstract class Caractere {

    protected final String NAME;
    protected int pv;
    protected int strength;


    public Caractere(String name, int pv, int strength) {
        this.NAME = name;
        this.pv = pv;
        this.strength = strength;
    }

    abstract public void speek();

    public void attack(Caractere target){
        if(target.pv > 0){
            target.pv -= this.strength;
        }else{
            System.out.println("Target has no life");
        }

    }

}
