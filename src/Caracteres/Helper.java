package Caracteres;

public class Helper extends Caractere {

    private final int loc;

    public Helper(String name, int loc){
        super(name, 100, 20);
        this.loc = loc;
    }


    @Override
    public void speek() {
        if(this.loc == 0){
            System.out.println("Bonjour je suis " + this.NAME + " je suis a la localisation Fontaine");
        }
        else if(this.loc == 1){
            System.out.println("Bonjour je suis " + this.NAME + " je suis a la localisation Bar");
        }
    }
}
