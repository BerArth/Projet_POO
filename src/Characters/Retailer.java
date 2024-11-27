package Characters;

import Items.*;

import java.util.*;
import java.util.stream.Collectors;

public class Retailer extends Character{

    private final Map<Item, List<Item>> inventory;

    public Retailer(String name, String speech){
        super(name, 1, 0, speech);
        this.inventory = new HashMap<>();
    }

    @Override
    public void attack(Character character) {
        System.out.println("Im " + this.getNAME() + " I can't attack!");
    }

    public void addInventory(Item item, List<Item> price){
        this.inventory.put(item, price);
    }

    public void removeInventory(Item item){
        if(inventory.containsKey(item)){
            this.inventory.remove(item);
        }
    }

    public void displayInventory() {
        System.out.println(this.getNAME() + " Inventory:");
        for (Map.Entry<Item, List<Item>> entry : inventory.entrySet()) {
            String prices = entry.getValue().stream()
                    .map(Item::getName)
                    .collect(Collectors.joining(", "));
            System.out.println(entry.getKey().getName() + " - Exchange for: " + prices);
        }
    }

    public void Trade(Hero hero, String itemName){
        Item itemToTrade = null;
        for(Item item : inventory.keySet()){
            if(item.getName().equals(itemName)){
                itemToTrade = item;
                break;
            }
        }

        if(itemToTrade == null){
            System.out.println("Sorry, " + itemName + " doesn't exist!");
            return;
        }

        List<Item> requiredItems = inventory.get(itemToTrade);

        if(!hero.getBag().haveItems(requiredItems)){
            System.out.println("Sorry, you don't have the required items!");
            return;
        }

        hero.getBag().removeItems(requiredItems);
        hero.getBag().addItem(itemToTrade);
        removeInventory(itemToTrade);

        System.out.println("Trade successful! You received: " + itemToTrade.getName());
    }
}
