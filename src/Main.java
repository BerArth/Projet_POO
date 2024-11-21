import Characters.*;
import Doors.AutoLockDoorExit;
import Doors.DoorExit;
import Doors.DoorWithKeyExit;
import Doors.Exit;
import Items.*;
import Locations.Room;

import java.util.Set;
import java.util.Scanner;

public class Main {

    private static final String SAGE_SPEACH = "Little hero hello, \nTo discover a lot of things here, you are going. \nTo get out of my help you need.";
    private static final String DRUNKARD_SPEACH =  "Eh! Oh! You! Yes, you! Why are you looking at me like that? \n No! No, no, no, I'm not drunk.\n \nEh ?! \nAre you an adventurer or something like that? \n...I was an adventurer when I was younger. I EVEN had a boat... \n I like you! If you find my code, I give you my boat. Yeh! So...";
    private static final String FOREMAN_SPEACH = "YOU HERE! \nWhen your foreman speaks, you listen! \nYou really think you can stand in front of your foreman and do nothing. Go to work now or I'll put you there pronto!";
    private static final String BLACKSMITH_SPEACH = "Hey friend! \nIt seems that you need my blacksmithing skills to obtain a complete key. \nBring me the key parts and I'll help you.";
    private static final String HERBERT_SPEACH = "Welcome to my humble shop. \nSince the city is close, I don't have many products. I can just sell you a glass flacon.";

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        //Characters
        Helper SAGE = new Helper("Sage", SAGE_SPEACH);
        Helper drunkard = new Helper("Reynold the Drunkard", DRUNKARD_SPEACH);
        Boss boss = new Boss("Foreman", FOREMAN_SPEACH);
        Hero hero = new Hero("Michel", "Hello!");
        Retailer blacksmith = new Retailer("Ragnard the blacksmith", BLACKSMITH_SPEACH);
        Retailer shopkeeper = new Retailer("Herbert", HERBERT_SPEACH);

        //Items
        Book history = new Book("History", 25, "You can just read the title <<History of gold mining>>, by squinting your eyes, you can guess some characters and a name : ... 3 Caesar \n");
        Net net = new Net("Net", 5, "It's a simple net with very tiny mesh.");
        Flacon flacon = new Flacon("Flacon", 20, "It's just a flacon with a pierced cap.");
        Weapon pickaxe = new Weapon("Pickaxe", 50, 50, "This pickaxe seems very sturdy. But it seeams that it's not dust but blood that there is. There appears to be blood on the metal.");
        Food bread = new Food("Bread", 10, 50, "A generous slice of bread!");
        Firefly firefly = new Firefly("Firefly", 3, "An insect that is active during the night and whose tail produces light - Cambridge Dicrionary");
        PublicNotice mosaic = new PublicNotice("Mosaic", 5000, "...");
        PublicNotice publicNotice = new PublicNotice("PublicNotice", 2000, "Public Notice : \n Due to a collapse access to the outside of the earth is no impossible. \n The sage revealed to us that another door to the outside still exist. \nWe call on all citizens to find this door and open it. \nREWARD : 2000 GOLD BARS and a free beer.\n         Mayor");
        PublicNotice minesWarning = new PublicNotice("Warning", 3000, "Access to the mine only for workers. \nRelatives, please wait outside \nNotice to the workers: Don't forget to listen to the cuckoo");

        hero.getBag().addItem(pickaxe);

    /*
        System.out.println("Bag inventory before exchange :");
        hero.getBag().printItems();

        retailer.exchangeKeyPart(hero);

        System.out.println("Bag inventory after exchange :");
        hero.getBag().printItems();

        hero.addGold(30);
        hero.printGold();

        Flacon flacon = new Flacon("Flacon", 5);
        retailer.addInventory(flacon, 20);
        retailer.sellItem(flacon, hero);
        hero.getBag().printItems();


        hero.getBag().addItem(new KeyPart(1));
        hero.getBag().addItem(new KeyPart(2));
        hero.getBag().addItem(new KeyPart(3));
        hero.getBag().addItem(new KeyPart(4));


        //test item
        Weapon w1 = new Weapon("Sword",40, 50);
        Food food = new Food("Potato",5, 10);
        Bag bag = new Bag("Bag", 10);
        Net net = new Net("Net", 5);

        hero.getBag().addItem(w1);
     */
        //test des rooms

        Room startRoom = new Room("Clairiere", "Vous êtes dans une clairière tranquille entourée de sentiers.", blacksmith, null);
        Room forest = new Room("Forêt", "Vous êtes dans une forêt dense.", boss, null);


        Set<Integer> requiredParts = Set.of(1,2,3,4);
        //DoorWithKey door2forest = new DoorWithKey(requiredParts);

        AutoLockDoorExit exit2forest = new AutoLockDoorExit("forest", forest);
        Exit forest2stratRoom = new Exit("clairiere", startRoom);

        startRoom.addExit(exit2forest);
        forest.addExit(forest2stratRoom);

        Room currentRoom = startRoom;


        System.out.println("***********************************************");

        System.out.println("Bienvenue dans l'aventure !");
        System.out.println("Commandes : GO [direction], UNLOCK [direction], OPEN [direction], HELP, QUIT, INVENTORY, LOOK");
        System.out.println(currentRoom.getDescription());

        while(true) {

            if(hero.isDead()){
                System.out.println("You are dead, try again!");
                break;
            }


            System.out.print("> ");
            String command = scanner.nextLine().trim();

            if (command.equals("QUIT")) {
                System.out.println("Merci d'avoir joué !");
                break;
            }

            if(command.equals("LOOK")){
                System.out.println(currentRoom.getDescription());
                if(currentRoom.getItems() != null){
                    System.out.println("Item in this room : ");
                    currentRoom.printItems();
                }
                System.out.println("Sorties disponibles :");
                for (String direction : currentRoom.getExits().keySet())
                {
                    DoorExit exit = currentRoom.getExits().get(direction);
                    System.out.println("- " + direction);
                }

            }

            if(command.startsWith("TAKE ")){
                String item = command.substring(5);
                System.out.println(item);
                hero.takeItem(currentRoom, item);
            }

            if(command.equals("INVENTORY")) {
                hero.getBag().printItems();
            }
            else if(command.startsWith("GO "))
            {

                String direction = command.substring(3).toLowerCase();
                DoorExit exit = currentRoom.getExit(direction);

                if(exit != null)
                {
                    if(exit instanceof Exit){
                        currentRoom = exit.getDirection();
                    }
                    else if(!exit.isOpen())
                    {
                        System.out.println(direction + " is closed");
                    }
                    else
                    {
                        currentRoom = exit.getDirection();
                    }
                }
                else
                {
                    System.out.println("Il n'y a pas de sortie dans cette direction");
                }

                if(currentRoom.haveBosse()){
                    boss.speek();
                    System.out.println("Start combat");
                    System.out.println("Boss health : " + boss.getHp() + "\n" + "Hero life : " + hero.getHp());
                    currentRoom.fight(boss, hero);
                }

            }
            else if(command.startsWith("UNLOCK "))
            {
                String direction = command.substring(7).toLowerCase();
                DoorExit exit = currentRoom.getExit(direction);

                if (exit == null)
                {
                    System.out.println("Il n'y a pas de porte dans cette direction !");
                }
                else if (exit instanceof DoorWithKeyExit keyDoor)
                {

                    Key key = (Key) hero.getBag().getItem("Key");
                    keyDoor.unlock(key);

                }
                else if (exit instanceof AutoLockDoorExit lockDoor){
                    lockDoor.unlock();
                }
                else
                {
                    System.out.println("Pas besoins de clé");
                }
            }
            else if(command.startsWith("OPEN "))
            {
                String direction = command.substring(5).toLowerCase();
                DoorExit exit = currentRoom.getExit(direction);

                if (exit == null) {
                    System.out.println("Il n'y a pas de porte dans cette direction !");
                } else {
                    exit.open();
                }
            }



        }//and while


    }

}