package Items;

import java.util.Random;

public class Flacon extends Item{


    private boolean isFull;

    public Flacon(String name, int weight) {
        super(name, weight);
    }

    public void set_isFull() {
        this.isFull = true;
    }

    public boolean get_IsFull() {
        return this.isFull;
    }


}
