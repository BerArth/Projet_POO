package Doors;

import Items.*;

import java.util.Set;

public class DoorWithKey extends AutoLockDoor {

    private final Set<Integer> requiredParts;

    public DoorWithKey(Set<Integer> requiredParts) {
        this.requiredParts = requiredParts;
    }

    @Override
    public void unlock() {
        System.out.println("We need key for unlock this door");
    }


    public void unlock(Key key){
        if(key != null && key.getKeyParts().containsAll(requiredParts)){
            super.unlock();
        }else {
            System.out.println("We need key for unlock this door");
        }
    }



    @Override
    public String toString() {
        return "Class = " + this.getClass().getSimpleName()
                + ", open = " + isOpen()
                + ", locked = " + isLocked();
    }

}
