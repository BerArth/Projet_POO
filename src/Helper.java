public class Helper extends Caracteres{

    public Helper(String name){
    super(name, 100, 20);
    }


    @Override
    void speek() {
        System.out.println("Bonjour je suis " + this.NAME);
    }
}
