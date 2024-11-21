package Items;

public class KeyPart extends Item {

    private final int KEY_PART_NB;

    public KeyPart(int keypartnb, String description) {
        super("keypart-" + keypartnb, 1, description);
        this.KEY_PART_NB = keypartnb;
    }

    public int getKeyPartNb(){
        return KEY_PART_NB;
    }

}
