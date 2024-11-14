package Items;

public class Key {
    private final int KEYNB;

    public Key(KeyPart a, KeyPart b){
        this.KEYNB = assembly(a, b);
    }

    public int getKeyNB() {
        return KEYNB;
    }

    public void printnb(){
        System.out.println(KEYNB);
    }

    public int assembly(KeyPart a, KeyPart b) {
        return a.getKeyPartNb() + b.getKeyPartNb();
    }

}
