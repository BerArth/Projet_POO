package Characters;

import Items.Bag;
import Items.Flacon;
import Items.Item;
import Items.Net;
import Locations.Room;

import java.util.List;
import java.util.Objects;

public class Hero extends Character {

    private int gold;
    private Bag bag = null;

    public Hero(String name, String speach){
        super(name, 100, 5, speach);
        this.gold = 0;
    }

    public Bag getBag(){
        return this.bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
        System.out.println("Great ! Now you have a bag!");
    }

    public int getGold(){
        return this.gold;
    }

    public void addGold(int amount){
        this.gold += amount;
        System.out.println(amount + " gold added. Your total of gold is : " + this.gold);
    }

    public void removeGold(int amount){
        if(this.gold >= amount){
            this.gold -= amount;
            System.out.println(amount + " gold spend. Your total of gold is : " + this.gold);
        }else{
            System.out.println("You don't have enough gold.");
        }
    }

    public void printGold(){
        System.out.println("You have " + this.gold + " gold.");
    }


    public void takeItemFromRoom(Room room, String nameItem) {
        List<Item> items = room.getItems();

        if (this.getBag() == null) {  // l'utilisateur n'a pas de sac
            if (nameItem.equals("Bag")) { // si l'item à ajouter est un sac
                boolean foundBag = false;
                for (Item item : items) {    // on cherche si la pièce à un item Bag
                    if (item instanceof Bag) {
                        this.setBag((Bag) item);
                        room.removeItem(item);
                        foundBag = true;
                        break;
                    }
                }
                if (!foundBag) { // il n'y a pas de sac dans la pièce
                    System.out.println("There is no bag here!");
                }
            } else { // l'item à ajouter n'est pas un sac et il n'a pas de sac
                System.out.println("You need a bag to add item.");
            }
        } else {  //l'utilisateur a un sac
            Item item = room.getItem(nameItem);
            if(item != null){ // l'item est dans la pièce
                if(!nameItem.equals("Firefly")){
                    if (this.getBag().addItem(item)) { // bool isAdd
                        room.removeItem(item);  // on supprime l'item de la pièce si ajout
                    }
                }else{  // l'item à prendre est une luciole
                    if(this.getBag().haveItem("Net")){
                        Net net = (Net) this.getBag().getItem("Net");
                        net.Catch((Flacon) this.getBag().getItem("Flacon"));
                    }else{
                        System.out.println("You need a net to catch some fireflies.");
                    }
                }
            }else{  // l'item n'est pas dans la pièce
                System.out.println("This room don't have this item.");
            }
        }
    }

    public boolean haveWeapon(){
        return this.getBag().haveItem("Pickaxe");
    }

}
