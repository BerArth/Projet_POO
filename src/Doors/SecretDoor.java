package Doors;

public class SecretDoor extends AutoLockDoor {

    private final int CODE;

    public SecretDoor(int code) {
        super();
        this.CODE = code;
    }

    @Override
    public void unlock() {
        System.out.println("We need code for unlock door");
    }

    public void unlock(int code) {
        if(super.isLocked()){
            if(code == this.CODE){
                super.unlock();
            }else{
                System.out.println("Is not the good code");
            }
        }else{
            System.out.println("The door is already locked");
        }
    }

}
