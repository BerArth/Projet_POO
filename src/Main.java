import Characters.*;
import Doors.Door;
import Doors.DoorWithKey;
import Items.*;
import Locations.Exit;
import Locations.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //test characterse

        Helper h1 = new Helper("Sage", "Hello im Sage");
        Helper h2 = new Helper("Ivrogne", "Hello im ivrogne");
        Hero hero = new Hero("Michel", "hello michel");
        Retailer retailer = new Retailer("Forging", "hello Forging");
        h1.speek();
        h2.speek();

        Boss boss = new Boss("Contre-Maitre", "hello contre-maitre");
        boss.attack(hero);
        hero.printStateHp();
        h1.attack(boss);
        h1.giveClue(h1);
        hero.giveClue(hero);

        System.out.println("***********************************************");

        //test echange et achat
        hero.getBag().addItem(new KeyPart(1));
        hero.getBag().addItem(new KeyPart(2));
        hero.getBag().addItem(new KeyPart(3));
        hero.getBag().addItem(new KeyPart(4));

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

        System.out.println("***********************************************");


        //test item
        Weapon w1 = new Weapon("Sword",40, 50);
        Food food = new Food("Potato",5, 10);
        Bag bag = new Bag("Bag", 10);
        Net net = new Net("Net", 5);

        h1.printStateHp();    // 100
        w1.attack(h1);
        h1.printStateHp();    // 50
        food.heal(h1);          //  maxHP ?
        h1.printStateHp();    // 60
//        net.Catch(null);
//        net.Catch(flacon);

        //test des rooms
        Room startRoom = new Room("Clairiere", "Vous êtes dans une clairière tranquille entourée de sentiers.", null);
        Room forest = new Room("Forêt", "Vous êtes dans une forêt dense.", null);

        DoorWithKey door2forest = new DoorWithKey(12);
        Door door2clairiere = new Door();

        Exit exit2forest = new Exit("forest", forest, door2forest);
        Exit forest2stratRoom = new Exit("clairiere", startRoom, door2clairiere);

        startRoom.addExit(exit2forest);
        forest.addExit(forest2stratRoom);

        Room currentRoom = startRoom;

        System.out.println("Bienvenue dans l'aventure !");
        System.out.println("Commandes : GO [direction], UNLOCK [direction], OPEN [direction], HELP, QUIT");

        /*
        while(true) {
            System.out.println(currentRoom.getDescription());

            System.out.println("Sorties disponibles :");
            for (String direction : currentRoom.getExits().keySet())
            {
                Exit exit = currentRoom.getExits().get(direction);
                System.out.println("- " + direction + ": " + exit.getDoor());
            }

            System.out.print("> ");
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("QUIT")) {
                System.out.println("Merci d'avoir joué !");
                break;
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
                    keyDoor.unlock(k);
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
        }

        */
    }

}