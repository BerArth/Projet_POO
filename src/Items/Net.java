package Items;
import java.util.Random;

public class Net extends Item{

    //Filet pour luciole

    public Net(String name){
        super(name);
    }

    public boolean Catch(){
        Random randomNumbers = new Random();
        return (randomNumbers.nextInt(10) < 5);
    }
}
