import Characters.*;
import Doors.*;
import Items.*;
import Locations.Room;

import java.util.*;

public class Main {

    private static final String SAGE_SPEACH = "Little hero hello, \nTo discover a lot of things here, you are going. \nTo get out of my help you need.";
    private static final String DRUNKARD_SPEACH =  "Eh! Oh! You! Yes, you! Why are you looking at me like that? \n No! No, no, no, I'm not drunk.\n \nEh ?! \nAre you an adventurer or something like that? \n...I was an adventurer when I was younger. I EVEN had a boat... \n I like you! If you find my code, I give you my boat. Yeh! So...";
    private static final String FOREMAN_SPEACH = "YOU HERE! \nWhen your foreman speaks, you listen! \nYou really think you can stand in front of your foreman and do nothing. Go to work now or I'll put you there pronto!";
    private static final String BLACKSMITH_SPEACH = "Hey friend! \nIt seems that you need my blacksmithing skills to obtain a complete key. \nBring me the key parts and I'll help you.";
    private static final String HERBERT_SPEACH = "Welcome to my humble shop. \nSince the city is close, I don't have many products. I can just sell you a glass flacon.";

    private static final String SQUAREN = """
            You are to the north of the square.\s
               \s
            In front of you you can see a small rusty gate that leads to the cemetery and a huge building.\s
               \s
            This building is built directly into the stone. At the top of its door you can read TEMPLE:\s
               \s
            To acquire knowledge, one must study;\s
            To acquire wisdom, one must observe.
               \s
            
            Behind you you can hear the water fall from the fountain.""";

    private static final String SQUARES = """
            You are to the south of the square.
               \s
            There is Herbert's shop and right next to it a small and dark alley.
               \s
            Behind you you can hear the water fall from the fountain.""";

    private static final String SQUAREW = """
            You are to the west of the square.\s
               \s
            There's a lot of noise here. On one side of an alley you have the blacksmith, and on the other side you have the tavern.
               \s
            Behind you you can hear the water fall from the fountain.""";

    private static final String SQUAREE = """
            You are to the east of the square.\s
               \s
            This is you'r favorite place to be. Just in front of the alley to outside of the earth. You can see your house and the library.\s
               \s
            Behind you you can hear the water fall from the fountain.""";

    private static final String OUTSIDE = "Finally released!";

    private static final String SAGE_ROOM = "You are now in a quiet place. Kneeling on a carpet, an old man drinks his tea.";
    private static final String TEMPLE = "You are in the temple. It's huge room covered in mosaic. In the center of the room is a giant statue of Gaia.";
    private static final String STATUE = "Wow, the inside of the statue is completely covered with gold.";
    private static final String CEMETERY = """
            You are in the cemetery, The graves are lined up next to each other.\s
               \s
            Flowers don't grow here, so it's hard to honor the dead that way.""";

    private static final String LIBRARY = "The interior of this library is very sad, only a few books rest on the dusty shelves.";
    private static final String ALLEYW = "You are in the west alley. At the end of the path there is a gate but it is completely blocked by rocks.";
    private static final String HOUSE = "You are in your house";

    private static final String STORE = "You are in the store. Strangely, the store is empty. Behind the counter waits the seller.";
    private static final String ALLEYS = "You are in the south alley. It's a dark alley.";

    private static final String CAVEL = "Wow, you're in a cave with lots of fireflies lighting up the vault. It's wonderful.";
    private static final String ISLAND = "You are on the island. You can see the shore of the cave.\nMoored to the land there is the boat.";
    private static final String CAVESTL = "You are surrounded by stalactites and stalagmites.\nImpossible to get out of here.";
    private static final String SPRING = "At your feet flows an underground spring.\nAt this point it forms like a lake with an island in the center.\nMoored to the land there is a boat.";
    private static final String BOAT = "You are on the boat in the middle of the water.\nOn one side there is the shore of the cave, on the other the island.";

    private static final String ALLEYE = "You are in the east alley. It's a dark alley, like a chimney flue.";
    private static final String SMITHY = "You are at the blacksmith's. It is very hot and the noise from the forge is deafening.";
    private static final String TAVERN = "You are in the tavern. Apart from a half-unconscious drunk man there is no one there.";

    private static final String MINEABD = "Cuck-oo, cuck-oo, cuck-oo\nThis mine is clearly abandoned";
    private static final String MINEEXP = "Cuck-oo, cuck-oo, cuck-oo\nYou are in the exploited part of the mine.\nIf you stay here, you're going to have to work with others. Move on.";
    private static final String MINEG = "Cuck-oo, cuck-oo, cuck-oo\nThis is the famous gold mine.";
    private static final String GALLERYS = "This is a simple gallery. There is nobody.";
    private static final String GALLERYN = "Cuck-oo, cuck-oo, cuck-oo\nNothing here.";
    private static final String GALLERYM = "Cuck-oo, cuck-oo, cuck-oo\nYou are in the main gallery.";
    private static final String MINEENT = "Cuck-oo, cuck-oo, cuck-oo\nYou are at the entrance to the mine. There is a warning sign.";

    private static final String BAG = "It's juste a simple bag!";
    private static final String HISTORY = "You can just read the title <<History of gold mining>>,by squinting your eyes, you can guess some characters : 1110101";
    private static final String NET = "It's a simple net with very tiny mesh.";
    private static final String PICKAXE = "This pickaxe seems very sturdy.\nThere appears to be blood on the metal.";
    private static final String BREAD = "A generous slice of bread!";
    private static final String FIREFLY = "An insect that is active during the night and whose tail produces light\n-\nCambridge Dicrionary";
    private static final String MOSAIC = """
            
            ..........     ..........     .
                     .     .              .
                     .     .              .
                     .     .              .
            ..........     ..........     .
            .              .         .    .
            .              .         .    .
            .              .         .    .
            ..........     ..........     .
            """;
    private static final String PUBLICNOTICE = "Public Notice :\n Due to a collapse access to the outside of the earth is no impossible.\n The sage revealed to us that another door to the outside still exist.\nWe call on all citizens to find this door and open it.\nREWARD : 2000 GOLD BARS and a free beer.\n         Mayor";
    private static final String WARNING = "Access to the mine only for workers.\nRelatives, please wait outside\nNotice to the workers: Don't forget to listen to the cuckoo.";

    public static void help(){
        System.out.println("Controls :\n -GO [Name of exit]\n -UNLOCK [Name of exit]\n -OPEN [Name of exit]\n -HELP\n -QUIT\n -INVENTORY\n -LOOK\n -SPEAK");
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
        blacksmith.addInventory(new Key("Key"), List.of(new KeyPart("KeyTemple1"), new KeyPart("KeyMine2"), new KeyPart("KeyIsland3")));
        Retailer shopkeeper = new Retailer("Herbert", HERBERT_SPEACH);
        shopkeeper.addInventory(new Net("Flacon",20, "It's just a flacon with a pierced cap."), List.of(new Gold()));

        //Items
        Bag bag = new Bag("Bag", 100, BAG);
        Book history = new Book("History", 25, HISTORY);
        Net net = new Net("Net", 5, NET);

        Weapon pickaxe = new Weapon("Pickaxe", 50, 50, PICKAXE);
        Food bread = new Food("Bread", 10, 50, BREAD);
        Firefly firefly = new Firefly("Firefly", 3, FIREFLY);
        PublicNotice mosaic = new PublicNotice("Mosaic", 5000, MOSAIC);
        PublicNotice publicNotice = new PublicNotice("PublicNotice", 2000, PUBLICNOTICE);
        PublicNotice minesWarning = new PublicNotice("Warning", 3000, WARNING);
        Gold gold = new Gold();

        KeyPart keyTemple1 = new KeyPart("KeyTemple1");
        KeyPart keyMine2 = new KeyPart("KeyMine2");
        KeyPart keyIsland3 = new KeyPart("KeyIsland3");

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
        List<Item> itemsMineG = new ArrayList<>();
        itemsMineG.add(gold);

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
        Room mineG = new Room("Gold Mine", MINEG, null, itemsMineG); //gestion de l'or????
        Room galleryS = new Room("South Gallery", GALLERYS, null, null);
        Room galleryN = new Room("North Gallery", GALLERYN, null, null);
        Room galleryM = new Room("Main Gallery", GALLERYM, boss, null);
        Room mineEnt = new Room("Mine Entrance", MINEENT, null, itemsEnt);

        //exit
        Exit exitToSageRoom = new Exit("Sage's room", sageRoom);
        Exit exitToTemple = new Exit("Temple", temple);
        Exit exitToLibrary = new Exit("Library", library);
        Exit exitToHouse = new Exit("House", house);
        Exit exitToSquareN = new Exit("Square north", squareN);
        Exit exitToSquareS = new Exit("Square south", squareS);
        Exit exitToSquareW = new Exit("Square west", squareW);
        Exit exitToSquareE = new Exit("Square east", squareE);
        Exit exitToStore = new Exit("Store", store);
        Exit exitToAlleyS = new Exit("South alley", alleyS);
        Exit exitToAlleyW = new Exit("West alley", alleyW);
        Exit exitToAlleyE = new Exit("East alley", alley);
        Exit exitToSmithy = new Exit("Smithy", smithy);
        Exit exitToTavern = new Exit("Tavern", tavern);
        Exit exitToCemetery = new Exit("Cemetery", cemetery);

        Exit exitToMineExp = new Exit("Exploited mine", mineExp);
        Exit exitToMineG = new Exit("Gold mine", mineG);
        Exit exitToGalleryS = new Exit("South gallery", galleryS);
        Exit exitToGalleryN = new Exit("North gallery", galleryN);
        Exit exitToGalleryM = new Exit("Main gallery", galleryM);
        Exit exitToMineEnt = new Exit("Mine entrance", mineEnt);

        Exit exitToCaveL = new Exit("Light cave", caveL);
        Exit exitToIsland = new Exit("Island", island);

        //pour le moment juste des exits
        Exit exitToCaveStl = new Exit("Stalactite cave", caveStl);
        Exit exitToSpring = new Exit("Underground spring", spring);

        DoorWithKeyExit exitToOutside = new DoorWithKeyExit("Fountain", outside);

        SecretCodeDoorExit exitTempleToSquareN = new SecretCodeDoorExit("Square north", squareN, 666);
        SecretCodeDoorExit exitToBoat = new SecretCodeDoorExit("Boat", boat, 666);
        SecretCodeDoorExit exitToMineAbd = new SecretCodeDoorExit("Abandoned mine", mineAbd, 666);
        SecretCodeDoorExit exitToStatue = new SecretCodeDoorExit("Statue", statue, 666);

        squareN.addExit(exitToCemetery);
        squareN.addExit(exitToTemple);
        squareN.addExit(exitToSquareE);
        squareN.addExit(exitToSquareW);
        squareN.addExit(exitToOutside);

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
        spring.addExit(exitToBoat);
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
        Bag bagTest = new Bag("BagForTest", 200, "testbag");
        hero.setBag(bagTest);
        hero.getBag().addItem(pickaxe);
        hero.getBag().addItem(keyTemple1);
        hero.getBag().addItem(keyMine2);
        hero.getBag().addItem(keyIsland3);
        hero.getBag().addItem(gold);
        blacksmith.Trade(hero, "Key");

        System.out.println("***********************************************");

        System.out.println("Welcome in [nom du jeux] !");
        help();
        System.out.println(currentRoom.getDescription());

        while(true) {

            if(hero.isDead()){
                System.out.println("You are dead, try again!");
                break;
            }

            if(currentRoom == outside){
                System.out.println(currentRoom.getDescription() + "\nEnter QUIT for quit the game!");
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
                if(Objects.equals(currentRoom.getName(), "Underground Spring")){
                    System.out.println("This room is too dark, you need a light to be able to see.");
                }else{
                    System.out.println(currentRoom.getDescription());
                    if(currentRoom.getItems() == null ||currentRoom.getItems().isEmpty()){
                        System.out.println("This room don't contains items!");
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
            }

            if(startsWithIgnoreCase(command,"LOOK ")){
                String sitem = command.substring(5);
                Item item = currentRoom.getItem(sitem);
                if (item != null){
                    System.out.println(item.getDescription());
                }

            }

            if(command.equalsIgnoreCase("SPEAK")) {
                if(currentRoom.getChara() != null){
                    currentRoom.getChara().speak();
                    if(currentRoom.getChara() instanceof Helper){
                        System.out.println("You want a clue ? ");
                        System.out.print("> ");
                        String commands = scanner.nextLine().trim();
                        if(commands.equalsIgnoreCase("YES")) {
                            Helper helper = (Helper) currentRoom.getChara();
                            helper.giveClue();
                        }
                    }else if(currentRoom.getChara() instanceof Retailer){
                        ((Retailer) currentRoom.getChara()).displayInventory();
                    }
                }else{
                    System.out.println("You're alone, do you like talking to yourself?");
                }
            }

            if(command.equalsIgnoreCase("TRADE")){
                if(currentRoom.getChara() != null){
                    if(currentRoom.getChara() instanceof Retailer){
                        System.out.println("Enter the name of the desired item:");
                        String desiredItem = scanner.nextLine().trim();
                        ((Retailer) currentRoom.getChara()).Trade(hero, desiredItem);
                    }else {
                        System.out.println("you need a retailer to exchange your items");
                    }
                }else{
                    System.out.println("You're alone, you want to trade with the wind?");
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
                DoorExit exit = currentRoom.getExit(direction);

                if(exit != null)
                {
                    if(exit instanceof Exit){
                        currentRoom = exit.getDirection();
                        System.out.println(currentRoom.getDescription());
                    }
                    else if(!exit.isOpen())
                    {
                        System.out.println(direction + " is closed");
                    }
                    else {
                        currentRoom = exit.getDirection();
                    }
                }
                else
                {
                    System.out.println("There is no exit in this direction.");
                }

                if(currentRoom.haveBoss()){
                    boss.speak();
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
                        System.out.println("je suis la");
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