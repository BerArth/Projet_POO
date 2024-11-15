package Items;
import java.util.Random;

public class Net extends Item{

    //Filet pour luciole

    public Net(String name, int weight) {
        super(name, weight);
    }

    public boolean Catch(){
        Random randomNumbers = new Random();
        return (randomNumbers.nextInt(10) < 5);
    }
}
