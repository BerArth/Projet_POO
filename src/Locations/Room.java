package Locations;

import Characters.Boss;
import Characters.Character;
import Items.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Room {

    private final String NAME;
    private final String description;
    private Map<String, Exit> exits;
    private Character chara;
    private List<Item> items;

    public Room(String name, String description, Character chara, List<Item> items) {
        this.NAME = name;
        this.description = description;
        this.exits = new HashMap<String, Exit>();
        this.chara = chara;
        this.items = items;
    }

    public void addExit(Exit exit) {
        exits.put(exit.getDescription(), exit);
    }

    public Exit getExit(String direction) {
        return exits.get(direction);
    }

    public Map<String, Exit> getExits() {
        return exits;
    }

    public String getDescription() {
        return description;
    }

    public Character getChara() {
        return chara;
    }

    public List<Item> getItems() {
        return items;
    }

    public void printItems(){
        for(Item item : items){
            item.printName();
        }
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean haveBosse(){
        if(getChara() instanceof Boss){
            System.out.println("This room have a bosse");
            return true;
        }else{
            return false;
        }
    }

    public Boss getBoss(){
        return (Boss) getChara();
    }

}
