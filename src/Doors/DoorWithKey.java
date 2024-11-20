package Doors;

import Items.*;

public class DoorWithKey extends AutoLockDoor {


    public DoorWithKey() {

    }

    @Override
    public void unlock() {
        System.out.println("We need key for unlock this door");
    }


    public void unlock(Key k){

    }



    @Override
    public String toString() {
        return "Class = " + this.getClass().getSimpleName()
                + ", open = " + isOpen()
                + ", locked = " + isLocked()
                + ", keyNb = " + getKeyDoorNb();
    }

}
