package Items;

public class KeyPart extends Item {

    private final int KEY_PART_NB;

    public KeyPart(int keypartnb) {
        super("keypart-" + keypartnb, 1, "Just one part of the key, it must take several to assemble the complete key.");
        this.KEY_PART_NB = keypartnb;
    }

    public int getKeyPartNb(){
        return KEY_PART_NB;
    }

}
