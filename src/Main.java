import Characters.*;
import Characters.Character;
import Doors.*;
import Items.*;
import Locations.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Main {

    private static final String SAGE_SPEACH = "Little hero hello, \nTo discover a lot of things here, you are going. \nTo get out of my help you need.";
    private static final String DRUNKARD_SPEACH =  "Eh! Oh! You! Yes, you! Why are you looking at me like that? \n No! No, no, no, I'm not drunk.\n \nEh ?! \nAre you an adventurer or something like that? \n...I was an adventurer when I was younger. I EVEN had a boat... \n I like you! If you find my code, I give you my boat. Yeh! So...";
    private static final String FOREMAN_SPEACH = "YOU HERE! \nWhen your foreman speaks, you listen! \nYou really think you can stand in front of your foreman and do nothing. Go to work now or I'll put you there pronto!";
    private static final String BLACKSMITH_SPEACH = "Hey friend! \nIt seems that you need my blacksmithing skills to obtain a complete key. \nBring me the key parts and I'll help you.";
    private static final String HERBERT_SPEACH = "Welcome to my humble shop. \nSince the city is close, I don't have many products. I can just sell you a glass flacon.";

    private static final String SQUAREN = "";
    private static final String SQUARES = "";
    private static final String SQUAREW = "";
    private static final String SQUAREE = "";
    private static final String OUTSIDE = "";

    private static final String SAGE_ROOM = "";
    private static final String TEMPLE = "";
    private static final String STATUE = "";
    private static final String CEMETERY = "";

    private static final String LIBRARY = "";
    private static final String ALLEYW = "";
    private static final String HOUSE = "";

    private static final String STORE = "";
    private static final String ALLEYS = "";

    private static final String CAVEL = "";
    private static final String ISLAND = "";
    private static final String CAVESTL = "";
    private static final String SPRING = "";
    private static final String BOAT = "";

    private static final String ALLEYE = "";
    private static final String SMITHY = "";
    private static final String TAVERN = "";

    private static final String MINEABD = "";
    private static final String MINEEXP = "";
    private static final String MINEG = "";
    private static final String GALLERYS = "";
    private static final String GALLERYN = "";
    private static final String GALLERYM = "";
    private static final String MINEENT = "";

    public static void help(){
        System.out.println("Controls :\n -GO [Name of exit]\n -UNLOCK [Name of exit]\n -OPEN [Name of exit]\n -HELP\n -QUIT\n -INVENTORY\n -LOOK");
    }
    public static boolean startsWithIgnoreCase(String input, String prefix){
        if (input.length() < prefix.length()) {
            return false;
        }
        return input.substring(0, prefix.length()).equalsIgnoreCase(prefix);
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        //Characters
        Helper sage = new Helper("Sage", SAGE_SPEACH);
        Helper drunkard = new Helper("Reynold the Drunkard", DRUNKARD_SPEACH);
        Boss boss = new Boss("Foreman", FOREMAN_SPEACH);
        Hero hero = new Hero("Michel", "Hello!");
        Retailer blacksmith = new Retailer("Ragnard the blacksmith", BLACKSMITH_SPEACH);
        Retailer shopkeeper = new Retailer("Herbert", HERBERT_SPEACH);

        //Items
        Bag bag = new Bag("Bag", 100, "It's just a simple bag!");
        Book history = new Book("History", 25, "You can just read the title <<History of gold mining>>, by squinting your eyes, you can guess some characters and a name : ... 3 Caesar \n");
        Net net = new Net("Net", 5, "It's a simple net with very tiny mesh.");
        Flacon flacon = new Flacon("Flacon", 20, "It's just a flacon with a pierced cap.");
        Weapon pickaxe = new Weapon("Pickaxe", 50, 50, "This pickaxe seems very sturdy. But it seems that it's not dust but blood that there is. There appears to be blood on the metal.");
        Food bread = new Food("Bread", 10, 50, "A generous slice of bread!");
        Firefly firefly = new Firefly("Firefly", 3, "An insect that is active during the night and whose tail produces light - Cambridge Dicrionary");
        PublicNotice mosaic = new PublicNotice("Mosaic", 5000, "...");
        PublicNotice publicNotice = new PublicNotice("PublicNotice", 2000, "Public Notice : \n Due to a collapse access to the outside of the earth is now impossible. \n The sage revealed to us that another door to the outside still exist. \nWe call on all citizens to find this door and open it. \nREWARD : 2000 GOLD BARS and a free beer.\n         Mayor");
        PublicNotice minesWarning = new PublicNotice("Warning", 3000, "Access to the mine only for workers. \nRelatives, please wait outside \nNotice to the workers: Don't forget to listen to the cuckoo");

        KeyPart keyTemple1 = new KeyPart(1);
        KeyPart keyMine2 = new KeyPart(2);
        KeyPart keyIsland3 = new KeyPart(3);

        //List items for room
        List<Item> itemsTemple = new ArrayList<>();
        itemsTemple.add(mosaic);
        List<Item> itemsStatue = new ArrayList<>();
        itemsStatue.add(keyTemple1);
        List<Item> itemsCemetry = new ArrayList<>();
        itemsCemetry.add(pickaxe);
        List<Item> itemsSquareW = new ArrayList<>();
        itemsSquareW.add(net);
        List<Item>  itemsLibrary = new ArrayList<>();
        //itemsLibrary.add(book);
        List<Item> itemsLalleyW = new ArrayList<>();
        itemsLibrary.add(publicNotice);
        List<Item> itemsHouse = new ArrayList<>();
        itemsHouse.add(bag);
        List<Item> itemsCavel = new ArrayList<>();
        itemsCavel.add(firefly);
        List<Item> itemsIsland = new ArrayList<>();
        itemsIsland.add(keyIsland3);
        List<Item> itemsMineAbd = new ArrayList<>();
        itemsMineAbd.add(keyMine2);
        List<Item> itemsEnt = new ArrayList<>();
        itemsEnt.add(minesWarning);
        List<Item> itemsTavern = new ArrayList<>();
        itemsTavern.add(bread);


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

        //Room
        //Square
        Room squareN = new Room("Square",SQUAREN, null, null);
        Room squareS = new Room("Square",SQUARES, null, null);
        Room squareW = new Room("Square",SQUAREW, null, itemsSquareW);
        Room squareE = new Room("Square",SQUAREE, null, null);
        Room outside = new Room("Outside", OUTSIDE, null, null);
        //North
        Room sageRoom = new Room("Sage's Room", SAGE_ROOM, sage, null);
        Room temple = new Room("Temple", TEMPLE, null, itemsTemple);
        Room statue = new Room("Statue", STATUE, null, itemsStatue);
        Room cemetery = new Room("Cemetery", CEMETERY, null, itemsCemetry);
        //West
        Room library = new Room("Library", LIBRARY, null, itemsLibrary);
        Room alleyW = new Room("Alley", ALLEYW, null, itemsLalleyW);
        Room house = new Room("House", HOUSE,null, itemsHouse);
        //South
        Room store = new Room("Store",STORE, shopkeeper, null);
        Room alleyS = new Room("Alley", ALLEYS, null, null);
        //Cave
        Room caveL = new Room("Light Cave", CAVEL, null, itemsCavel);
        Room island = new Room("Island", ISLAND, null, itemsIsland);
        Room caveStl = new Room("Stalactite Cave", CAVESTL, null, null);
        Room spring = new Room("Underground Spring", SPRING, null, null);
        Room boat = new Room("Boat", BOAT, null, null);
        //East

        Room alley = new Room("Alley", ALLEYE, null, null);
        Room smithy = new Room("Smithy", SMITHY, blacksmith, null);
        Room tavern = new Room("Tavern", TAVERN, drunkard, itemsTavern);
        //Mine
        Room mineAbd = new Room("Abandoned Mine", MINEABD, null, itemsMineAbd);
        Room mineExp = new Room("Exploited Mine", MINEEXP, null, null);
        Room mineG = new Room("Gold Mine", MINEG, null, null); //gestion de l'or????
        Room galleryS = new Room("South Gallery", GALLERYS, null, null);
        Room galleryN = new Room("North Gallery", GALLERYN, null, null);
        Room galleryM = new Room("Main Gallery", GALLERYM, boss, null);
        Room mineEnt = new Room("Mine Entrance", MINEENT, null, itemsEnt);

        //exit
        Exit exitToSageRoom = new Exit("To Sage's Room", sageRoom);
        Exit exitToTemple = new Exit("To Temple", temple);
        Exit exitToLibrary = new Exit("To Library", library);
        Exit exitToHouse = new Exit("To House", house);
        Exit exitToSquareN = new Exit("To Square North", squareN);
        Exit exitToSquareS = new Exit("To Square South", squareS);
        Exit exitToSquareW = new Exit("To Square West", squareW);
        Exit exitToSquareE = new Exit("To Square East", squareE);
        Exit exitToStore = new Exit("To Store", store);
        Exit exitToAlleyS = new Exit("To South Alley", alleyS);
        Exit exitToAlleyW = new Exit("To West Alley", alleyW);
        Exit exitToAlleyE = new Exit("To East Alley", alley);
        Exit exitToSmithy = new Exit("To Smithy", smithy);
        Exit exitToTavern = new Exit("To Tavern", tavern);
        Exit exitToCemetery = new Exit("To Cemetery", cemetery);

        Exit exitToMineExp = new Exit("To Exploited Mine", mineExp);
        Exit exitToMineG = new Exit("To Gold Mine", mineG);
        Exit exitToGalleryS = new Exit("To South Gallery", galleryS);
        Exit exitToGalleryN = new Exit("To North Gallery", galleryN);
        Exit exitToGalleryM = new Exit("To Main Gallery", galleryM);
        Exit exitToMineEnt = new Exit("To Mine Entrance", mineEnt);

        Exit exitToCaveL = new Exit("To Light Cave", caveL);
        Exit exitToIsland = new Exit("To Island", island);

        //pour le moment juste des exits
        Exit exitToCaveStl = new Exit("To Stalactite Cave", caveStl);
        Exit exitToSpring = new Exit("To Underground Spring", spring);

        Set<Integer> requiredParts = Set.of(1,2,3);
        DoorWithKeyExit exitToOutside = new DoorWithKeyExit("Fountain", outside, requiredParts);

        SecretCodeDoorExit exitTempleToSquareN = new SecretCodeDoorExit("To Square North", squareN, 666);
        SecretCodeDoorExit exitToBoat = new SecretCodeDoorExit("Boat", boat, 666);
        SecretCodeDoorExit exitToMineAbd = new SecretCodeDoorExit("To Abandoned Mine", mineAbd, 666);
        SecretCodeDoorExit exitToStatue = new SecretCodeDoorExit("Statue", statue, 666);

        squareN.addExit(exitToCemetery);
        squareN.addExit(exitToTemple);
        squareN.addExit(exitToSquareE);
        squareN.addExit(exitToSquareW);

        squareS.addExit(exitToAlleyS);
        squareS.addExit(exitToStore);
        squareS.addExit(exitToSquareE);
        squareS.addExit(exitToSquareW);

        squareW.addExit(exitToAlleyW);
        squareW.addExit(exitToHouse);
        squareW.addExit(exitToLibrary);
        squareW.addExit(exitToSquareS);
        squareW.addExit(exitToSquareN);

        squareE.addExit(exitToAlleyE);
        squareE.addExit(exitToTavern);
        squareE.addExit(exitToSmithy);
        squareE.addExit(exitToSquareS);
        squareE.addExit(exitToSquareN);

        sageRoom.addExit(exitToTemple);
        temple.addExit(exitToSageRoom);
        temple.addExit(exitTempleToSquareN);
        temple.addExit(exitToStatue);
        statue.addExit(exitToTemple);
        cemetery.addExit(exitToSquareN);

        library.addExit(exitToSquareW);
        house.addExit(exitToSquareW);
        alleyW.addExit(exitToSquareW);

        store.addExit(exitToSquareS);
        alleyS.addExit(exitToSquareS);
        alleyS.addExit(exitToCaveL);

        caveL.addExit(exitToAlleyS);
        caveL.addExit(exitToCaveStl);
        caveL.addExit(exitToSpring);
        island.addExit(exitToBoat);
        spring.addExit(exitToCaveL);
        //spring.addExit(boat);
        boat.addExit(exitToIsland);
        boat.addExit(exitToSpring);

        alley.addExit(exitToSquareE);
        alley.addExit(exitToMineEnt);
        smithy.addExit(exitToSquareE);
        tavern.addExit(exitToSquareE);

        mineEnt.addExit(exitToAlleyE);
        mineEnt.addExit(exitToGalleryM);
        mineEnt.addExit(exitToGalleryN);
        mineEnt.addExit(exitToGalleryS);
        galleryS.addExit(exitToMineEnt);
        galleryN.addExit(exitToMineEnt);
        galleryM.addExit(exitToMineAbd);
        galleryM.addExit(exitToMineExp);
        galleryM.addExit(exitToMineEnt);
        mineAbd.addExit(exitToGalleryM);
        mineExp.addExit(exitToGalleryM);
        mineExp.addExit(exitToMineG);
        mineG.addExit(exitToMineExp);
        mineG.addExit(exitToCaveL);

        Room currentRoom = squareN;



        System.out.println("***********************************************");

        System.out.println("Welcome in [nom du jeux] !");
        help();
        System.out.println(currentRoom.getDescription());

        while(true) {

            if(hero.isDead()){
                System.out.println("You are dead, try again!");
                break;
            }


            System.out.print("> ");
            String command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("QUIT")) {
                System.out.println("Thank's for playing! Goodbye!");
                break;
            }
            if(command.equalsIgnoreCase("HELP")){
                help();
            }
            if(command.equalsIgnoreCase("LOOK")){
                System.out.println(currentRoom.getDescription());
                if(currentRoom.getItems() == null ||currentRoom.getItems().isEmpty()){
                    System.out.println("This room contains no items!");
                }else{
                    System.out.println("Item in this room : ");
                    currentRoom.printItems();
                }
                System.out.println("Available exits :");
                for (String direction : currentRoom.getExits().keySet())
                {
                    DoorExit exit = currentRoom.getExits().get(direction);
                    System.out.println("- " + direction);
                }

                if(currentRoom.getChara() != null){
                    System.out.println("Character in  this room :\n -" + currentRoom.getChara().getNAME());
                }

            }

            if(startsWithIgnoreCase(command,"LOOK ")){
                String sitem = command.substring(5);
                Item item = currentRoom.getItem(sitem);
                if (item != null){
                    System.out.println(item.getDescription());
                }

            }

            if(command.equalsIgnoreCase("SPEEK")) {
                if(currentRoom.getChara() != null){
                    currentRoom.getChara().speek();
                    if(currentRoom.getChara() instanceof Helper){
                        System.out.println("You want a clue ? ");
                        System.out.print("> ");
                        String commands = scanner.nextLine().trim();
                        if(commands.equalsIgnoreCase("YES")) {
                            Helper helper = (Helper) currentRoom.getChara();
                            helper.giveClue();
                        }
                    }
                }else{
                    System.out.println("You're alone, do you like talking to yourself?");
                }
            }

            if(startsWithIgnoreCase(command, "TAKE ")){
                String item = command.substring(5);
                //System.out.println(item);
                hero.takeItemFromRoom(currentRoom, item);
            }

            if(command.equalsIgnoreCase("INVENTORY")) {
                if(hero.getBag() != null){
                    hero.getBag().printItems();
                }else{
                    System.out.println("You need a bag to have some items !");
                }
            }
            else if(startsWithIgnoreCase(command,"GO "))
            {

                String direction = command.substring(3);
                System.out.println(direction);
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
                    System.out.println("There is no exit in this direction.");
                }

                if(currentRoom.haveBoss()){
                    boss.speek();
                    System.out.println("Start combat");
                    System.out.println("Boss health : " + boss.getHp() + "\n" + "Hero life : " + hero.getHp());
                    currentRoom.fight(boss, hero);
                }

            }
            else if(startsWithIgnoreCase(command,"UNLOCK "))
            {
                String direction = command.substring(7);
                DoorExit exit = currentRoom.getExit(direction);

                switch (exit) {
                    case null -> System.out.println("There is no door in this direction.");
                    case DoorWithKeyExit keyDoor -> {

                        Key key = (Key) hero.getBag().getItem("Key");
                        keyDoor.unlock(key);
                    }
                    case SecretCodeDoorExit secretDoor -> {
                        System.out.println("This exit need a code!\nPlease enter the code : ");
                        int code = scanner.nextInt();
                        secretDoor.unlock(code);
                    }
                    case AutoLockDoorExit lockDoor -> lockDoor.unlock();
                    default -> System.out.println("You don't need a key.");
                }
            }
            else if(startsWithIgnoreCase(command,"OPEN "))
            {
                String direction = command.substring(5);
                DoorExit exit = currentRoom.getExit(direction);

                if (exit == null) {
                    System.out.println("There is no door in this direction.");
                } else {
                    exit.open();
                }
            }

        }//end while


    }

}