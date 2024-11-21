package Items;
import java.util.Random;
import java.util.Scanner;

public class Net extends Item{

    //Filet pour luciole

    public Net(String name, int weight, String description) {
        super(name, weight, description);
    }

    private int HowManyCatch(){
        Random randomNumbers = new Random();
        if(randomNumbers.nextInt(10) < 5){  // 1/2 success
            return randomNumbers.nextInt(1, 5); // 1/5 firefly
        }else{
            return 0;
        }
    }

    public void Catch(Flacon flacon){
        Random randNum = new Random();
        Scanner scanner = new Scanner(System.in);

        if(randNum.nextInt(10) < 5){  // 1/2 success
            int r = randNum.nextInt(1, 6); // catch between 1 & 6 firefly
            if(r == 1){
                System.out.println("Well done, you catch a firefly.\n");
            }
            else{ // 2-5 fireflies
                System.out.println("Well done, you managed to catch " + r + " fireflies.\n");
            }

            System.out.println("Would you like to keep them ? (yes/no)\n");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("yes")){
                if(flacon != null){
                    flacon.addFireflies(r);
                }else{
                    System.out.println("You have nothing to keep them. The fireflies are now free.\n");
                }
            }else{
                System.out.println("The fireflies are now free.\n");
            }
        }
        else{  // fail
            System.out.println("You failed, you didn't catch any firefly.\n");
        }
    }
}
