package Characters;

import Items.Bag;
import Items.Item;
import Locations.Room;

import java.util.List;
import java.util.Objects;

public class Hero extends Character {

    private int gold;
    private Bag bag;

    public Hero(String name, String speach){
        super(name, 100, 20, speach);
        this.bag = new Bag("Bag", 100);
        this.gold = 0;
    }

    public Bag getBag(){
        return this.bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
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

    public void takeItem(Room room, String nameItem){
        List<Item> items = room.getItems();

        for(Item item : items){
            if(Objects.equals(item.getName(), nameItem)){
                this.getBag().addItem(item);
                items.remove(item);
                break;
            }else{
                System.out.println("This room dont have this item.");
            }
        }
    }

    public void attack(Character target){
        if(this.getBag().getItem("Sword") == null){
            System.out.println("Oh no you don't have weapon you can't attack this character.");
        }else{
            System.out.println("you attack");
        }
    }

}
