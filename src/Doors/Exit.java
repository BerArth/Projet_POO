package Doors;

import Locations.Room;

public class Exit extends DoorExit{

    public Exit(String name, Room direction){
        super(name, direction);
        this.setOpen(true);
    }

    @Override
    public void close() {
        System.out.println("This exit don't have door");
    }

}
