package Doors;

import java.util.*;

public class Door {

    private boolean open;

    public Door() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void open() {
        setOpen(true);
        System.out.println("You opened the door");
    }
    public void close() {
        setOpen(false);
    }

    @Override
    public String toString() {
        return "Class = " + this.getClass().getSimpleName()
                + ", open = " + isOpen();
    }

    public void printDoorList(List<? extends Door> dl){
        for(Door d : dl){
            System.out.println(d);
        }
    }
}

