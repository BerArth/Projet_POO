package Items;

import java.util.Random;
public class Flacon extends Item{


    private boolean isFull;

    public Flacon(String name) {
        super(name);
    }

    public void set_isFull(boolean full) {
        isFull = true;
    }

    public boolean get_IsFull() {
        return this.isFull;
    }


}
