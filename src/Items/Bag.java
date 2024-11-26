package Items;

import java.util.ArrayList;
import java.util.List;
import Characters.Character;
import Characters.Hero;

public class Bag extends Item {

    private final int MAX_CAPACITY = 100;
    private int capacity;
    private List<Item> items;
    private Hero owner;

    public Bag(String name, int weight, String description) {
        super(name, weight, description);
        this.items = new ArrayList<>();
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }
    public int getCapacity() {
        return capacity;
    }
    public Character getOwner() {
        return owner;
    }
    public List<Item> getItems() {
        return items;
    }

//    public List<Item> getItem(Item item) {
//        return items;
//    }

    public void setOwner(Hero newOwner) {
        if (this.owner != null) {
            this.owner.setBag(null);    // remove actual owner
        }

        this.owner = newOwner;  // set new owner to the bag

        if(newOwner != null) {
            newOwner.setBag(this); // link the bag to the new owner
        }
    }

    public void printOwner(){
        if(owner != null){
            System.out.println(this.owner.getNAME());
        }
    }

    public boolean addItem(Item item){
        if(this.capacity + item.weight <= this.MAX_CAPACITY){
            this.capacity += item.weight;
            this.items.add(item);
            System.out.println(item.getName() + " has been added to your bag.");
            return true;
        }else{
            System.out.println(item.getName() + " is too heavy for your bag.");
            return false;
        }
    }

    public void removeItem(Item item){
        if(this.items.contains(item)){
            this.capacity -= item.weight;
            this.items.remove(item);
            System.out.println(item.getName() + " has been removed from your bag.");
        }else{
            System.out.println(item.getName() + " is actually not in your bag.");
        }
    }

    public List<KeyPart> getKeyParts(){
        List<KeyPart> keyParts = new ArrayList<>();
        for(Item item : items){
            if(item instanceof KeyPart){
                keyParts.add((KeyPart) item);
            }
        }
        return keyParts;
    }

    public Weapon getWeapon(){
        Weapon found = null;
        for(Item item : items){
            if(item instanceof Weapon){
                found = (Weapon) item;
            }
        }
        return found;
    }

    public Item getItem(String name){
        Item foundItem = null;
        for(Item item : items){
            if(item.getName().equals(name)){
                foundItem = item;
            }
        }
        return foundItem;
    }

    public boolean haveItem(String name){
        return this.items.contains(this.getItem(name));
    }

    public void printItems(){
        if(items.isEmpty()){
            System.out.println("There is no item in your bag.");
        }else{
            System.out.println("Items in your bag:");
            for(Item item : items){
                item.printName();
            }
        }
    }


}
