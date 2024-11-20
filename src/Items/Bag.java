package Items;

import java.util.List;
import Characters.Character;
import Characters.Hero;

public class Bag extends Item {

    private final int MAX_CAPACITY = 100;
    private int capacity;
    private List<Item> items;
    private Hero owner;

    public Bag(String name, int weight) {
        super(name, weight);
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
    public List<Item> getItem(Item item) {
        return items;
    }

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

    public void printStateBag(Item item, String msgAfterNameItem){
        item.printName();
        System.out.println(item.getName() + msgAfterNameItem);
    }

    public void addItem(Item item){
        if(this.capacity + item.weight <= this.MAX_CAPACITY){
            this.capacity += item.weight;
            this.items.add(item);
            printStateBag(item, "has been added to your bag.");
        }else{
            printStateBag(item, "is too heavy for your bag.");
        }
    }

    public void removeItem(Item item){
        if(this.items.contains(item)){      // vérifier fonctionnement contains
            this.capacity -= item.weight;
            this.items.remove(item);
            printStateBag(item, "has been removed from your bag.");
        }else{
            printStateBag(item, "is actually not in your bag.");
        }
    }

    public boolean containItem(Item item){
        return this.items.contains(item);
    }
}
