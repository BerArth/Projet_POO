package Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flacon extends Item{

    private List<Firefly> fireflies;
    private boolean isFull;

    public Flacon(String name, int weight, String description) {
        super(name, weight, description);
        this.fireflies = new ArrayList<>();

    }

    private void set_isFull() {
        this.isFull = true;
    }

    public boolean get_IsFull() {
        return this.isFull;
    }

    public void addFireflies(int n) {
        if(this.isFull){
            System.out.println("Flacon is already full.\n");
        }else{
            Firefly f = new Firefly("Firefly", 1, "Bright little insects");
            for (int i = 0; i < n && (!this.isFull); i++) {
                fireflies.add(f);
            }

            int size = fireflies.size();
            if(size == 5){
                this.set_isFull();
                System.out.println("Flacon is now full.\n");
            }else{
                System.out.println("You have " + size + " fireflies.\n");
            }
        }
    }

}
