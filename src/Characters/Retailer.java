package Characters;

import Items.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Retailer extends Character{

    private Map<Item, Integer> inventory;

    public Retailer(String name, String speach){
        super(name, 1, 0, speach);
        this.inventory = new HashMap<>();
    }

    @Override
    public void attack(Character character) {
        System.out.println("Im " + this.getNAME() + " I can't attack!");
    }

    public void addInventory(Item item, int price){
        this.inventory.put(item, price);
    }

    public void removeInventory(Item item){
        if(inventory.containsKey(item)){
            this.inventory.remove(item);
        }
    }

    public void displayInventory(){
        System.out.println(this.getNAME() + " Inventory:");
        for(Map.Entry<Item, Integer> entry : inventory.entrySet()){
            System.out.println(entry.getKey().getName() + " - " + entry.getValue());
        }
    }

    public void sellItem(Item item, Hero buyer){
        if(inventory.containsKey(item)){
            int price = inventory.get(item);

            if(buyer.getGold() >= price){
                if(buyer.getBag() != null){
                    buyer.removeGold(price);
                    buyer.getBag().addItem(item);
                    inventory.remove(item);
                    System.out.println("You have buy " + item.getName() + "!");
                }else{
                    System.out.println("You don't have bag!");
                }
            }else{
                System.out.println("You don't have enough gold!");
            }
        }else {
            System.out.println(item.getName() + " does not exist!");
        }
    }

    public void exchangeKeyPart(Hero hero){
        Bag bag = hero.getBag();
        List<KeyPart> keyParts = bag.getKeyParts();

        if(keyParts.size() < 4){
            System.out.println("You don't have enough key parts!");
        }else{
            for(int i = 0; i < 4; i++){
                bag.removeItem(keyParts.get(i));
            }

            Key key = new Key(Set.of(1,2,3,4), "A part of a key, it must take several to get the complete key.");
            bag.addItem(key);
            System.out.println("You have exchange your 4 key parts!");
        }
    }

}
