package Exit;

import Locations.Room;

import java.util.*;

public class DoorExit {

    private final String NAME;
    private final Room DIRECTION;
    private boolean open;

    public DoorExit(String name, Room direction) {
        this.open = false;
        this.NAME = name;
        this.DIRECTION = direction;
    }

    public Room getDirection(){
        return DIRECTION;
    }

    public String getName(){
        return NAME;
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

    public void printDoorList(List<? extends DoorExit> dl){
        for(DoorExit d : dl){
            System.out.println(d);
        }
    }
}

