package Doors;


public class AutoLockDoor extends Door {

    private boolean locked = true;

    public AutoLockDoor() {
        super();
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
            System.out.println("Door is locked");
        } else {
            super.open();
        }
    }

    @Override
    public void close() {
        if (locked) {
            System.out.println("Door is already locked");
        }else{
            super.close();
            setLocked(true);
        }
    }

    public void unlock() {
        if (locked) {
            locked = false;
        }else{
            System.out.println("Door is not locked");
        }
    }



    @Override
    public String toString() {
        return "Class = " + this.getClass().getSimpleName()
                + ", open = " + isOpen()
                + ", locked = " + isLocked();
    }

}
