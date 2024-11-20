import Characters.*;
import Doors.Door;
import Doors.DoorWithKey;
import Items.*;
import Locations.Exit;
import Locations.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Main {

    private static final String SAGE_SPEACH = "Little hero hello, \nTo discover a lot of things here, you are going. \nTo get out of my help you need.";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //test characterse

        Helper h1 = new Helper("Sage", SAGE_SPEACH);
        Helper h2 = new Helper("Ivrogne", "Hello im ivrogne");
        Hero hero = new Hero("Michel", "hello michel");
        Retailer retailer = new Retailer("Forging", "hello Forging");
        Boss boss = new Boss("Contre-Maitre", "hello contre-maitre");

        KeyPart keypartforest = new KeyPart(1);


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

        //test des rooms
        List<Item> itemsR1 = new ArrayList<>();
        itemsR1.add(keypartforest);

        Room startRoom = new Room("Clairiere", "Vous êtes dans une clairière tranquille entourée de sentiers.", retailer, null);
        Room forest = new Room("Forêt", "Vous êtes dans une forêt dense.", boss, null);


        Set<Integer> requiredParts = Set.of(1,2,3,4);
        //DoorWithKey door2forest = new DoorWithKey(requiredParts);
        Door clairere2forest = new Door();
        Door door2clairiere = new Door();

        Exit exit2forest = new Exit("forest", forest, clairere2forest);
        Exit forest2stratRoom = new Exit("clairiere", startRoom, door2clairiere);

        startRoom.addExit(exit2forest);
        forest.addExit(forest2stratRoom);

        Room currentRoom = startRoom;


        System.out.println("***********************************************");

        System.out.println("Bienvenue dans l'aventure !");
        System.out.println("Commandes : GO [direction], UNLOCK [direction], OPEN [direction], HELP, QUIT, INVENTORY, LOOK");
        System.out.println(currentRoom.getDescription());

        while(true) {

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
                    Exit exit = currentRoom.getExits().get(direction);
                    System.out.println("- " + direction + ": " + exit.getDoor());
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
                Exit exit = currentRoom.getExit(direction);

                System.out.println(direction);

                if(exit != null)
                {
                    if(!exit.getDoor().isOpen())
                    {
                        System.out.println("Cette porte est fermé");
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
                    System.out.println("Start combat");
                    hero.attack(currentRoom.getBoss());
                }

            }
            else if(command.startsWith("UNLOCK "))
            {
                String direction = command.substring(7).toLowerCase();
                Exit exit = currentRoom.getExit(direction);

                if (exit == null)
                {
                    System.out.println("Il n'y a pas de porte dans cette direction !");
                }
                else if (exit.getDoor() instanceof DoorWithKey keyDoor)
                {

                    Key key = (Key) hero.getBag().getItem("Key");
                    keyDoor.unlock(key);

                }
                else
                {
                    System.out.println("Pas besoins de clé");
                }
            }
            else if(command.startsWith("OPEN "))
            {
                String direction = command.substring(5).toLowerCase();
                Exit exit = currentRoom.getExit(direction);

                if (exit == null) {
                    System.out.println("Il n'y a pas de porte dans cette direction !");
                } else {
                    exit.getDoor().open();
                }
            }



        }//and while


    }

}