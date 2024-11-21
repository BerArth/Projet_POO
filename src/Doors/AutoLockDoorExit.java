package Doors;


import Locations.Room;

public class AutoLockDoorExit extends DoorExit {

    private boolean locked = true;

    public AutoLockDoorExit(String name, Room direction) {
        super(name, direction);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public void open() {
        if (locked) {
            System.out.println(this.getName() + " is locked");
        } else {
            super.open();
        }
    }

    @Override
    public void close() {
        if (locked) {
            System.out.println(this.getName() + " is already locked");
        }else{
            super.close();
            setLocked(true);
        }
    }

    public void unlock() {
        if (locked) {
            locked = false;
            System.out.println(this.getName() + " is unlocked");
        }else{
            System.out.println(this.getName() + " is not locked");
        }
    }



    @Override
    public String toString() {
        return "Class = " + this.getClass().getSimpleName()
                + ", open = " + isOpen()
                + ", locked = " + isLocked();
    }

}
