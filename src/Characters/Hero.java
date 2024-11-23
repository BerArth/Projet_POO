package Characters;

import Items.Bag;
import Items.Item;
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

    public boolean isCollectable(String nameItem){
        return(nameItem.equals("PublicNotice")||nameItem.equals("Warning")||nameItem.equals("Mosaic"));
    }

    public void takeItemFromRoom(Room room, String nameItem) {
        List<Item> items = room.getItems();
        if(!isCollectable(nameItem)) {   // l'item n'est pas une PublicNotice
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
                        System.out.println("There is no bag here !");
                    }
                } else { // l'item à ajouter n'est pas un sac et il n'a pas de sac
                    System.out.println("You need a bag to add item.");
                }
            } else {  //l'utilisateur a un sac
                boolean foundItem = false;
                for (Item item : items) { // on cherche si l'item à ajouter est dans la pièce
                    if (Objects.equals(item.getName(), nameItem)) {
                        if (this.getBag().addItem(item)) { // l'item a bien été ajouté
                            room.removeItem(item);  // on supprime l'item de la pièce
                        }   //else pas d'ajout -> la fonction addItem renvoie le problème (capacity)
                        foundItem = true;
                        break;
                    }
                }
                if (!foundItem) {  // l'item n'est pas dans la pièce
                    System.out.println("This room dont have this item.");
                }
            }
        }else{ // l'item à ajouter est une publicNotice
            boolean foundNotice = false;
            for (Item item : items) { // on cherche si la notice est dans la pièce
                if (Objects.equals(item.getName(), nameItem)) {
                    item.printDescription();    // affiche la notice
                    foundNotice = true;
                    break;
                }
            }
            if (!foundNotice) {  // cette Notice n'est pas dans la pièce
                System.out.println("This room dont have this item.");
            }
        }

    }

    public boolean haveWeapon(){
        return this.getBag().haveItem("Pickaxe");
    }

}
