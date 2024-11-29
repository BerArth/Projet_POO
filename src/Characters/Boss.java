package Characters;

public class Boss extends Character {

    private final int MAX_HP;

    public Boss(String name, String speach){
        super(name, 200, 20, speach);
        this.MAX_HP = 200;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }
}
