package Doors;

import Items.*;
import Locations.Room;

import java.util.Set;

public class DoorWithKeyExit extends AutoLockDoorExit {


    public DoorWithKeyExit(String name, Room direction) {
        super(name, direction);
    }

    @Override
    public void unlock() {
        System.out.println("We need key for unlock this door");
    }


    public void unlock(Key key){
        if(key != null) {
            super.unlock();
        }else{
            System.out.println("We need key for unlock this door");
        }
    }
}
