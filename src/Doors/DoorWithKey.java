package Doors;

import Items.*;

public class DoorWithKey extends AutoLockDoor {

    private final int KEYNB;

    public DoorWithKey(int KEYNB) {
        this.KEYNB = KEYNB;
    }

    @Override
    public void unlock() {
        System.out.println("We need key for unlock this door");
    }

    public int getKeyDoorNb(){
        return this.KEYNB;
    }

    public void unlock(Key k){
        if(k instanceof KeyPart){
            System.out.println("Its key part, we need a key for unlock this door");
        }else{
            if(getKeyDoorNb() == k.getKeyNB()){
                super.unlock();
            }else {
                System.out.println("Ce n'est pas la bonne clé");
            }
        }

    }

    @Override
    public String toString() {
        return "Class = " + this.getClass().getSimpleName()
                + ", open = " + isOpen()
                + ", locked = " + isLocked()
                + ", keyNb = " + getKeyDoorNb();
    }

}
