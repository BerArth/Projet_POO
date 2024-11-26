package Locations;

import Characters.Boss;
import Characters.Character;
import Characters.Hero;
import Doors.DoorExit;
import Items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Room {

    private final String NAME;
    private final String description;
    private final Map<String, DoorExit> exits;
    private Character chara;
    private List<Item> items;

    public Room(String name, String description, Character chara, List<Item> items) {
        this.NAME = name;
        this.description = description;
        this.exits = new HashMap<String, DoorExit>();
        this.chara = chara;
        this.items = items;
    }

    public void addExit(DoorExit exit) {
        exits.put(exit.getName(), exit);
    }

    public DoorExit getExit(String direction) {
        return exits.get(direction);
    }

    public Map<String, DoorExit> getExits() {
        return exits;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return NAME;
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

    public boolean haveBoss(){
        if(getChara() instanceof Boss){
            System.out.println("This room have a boss.");
            return true;
        }else{
            return false;
        }
    }

    public Boss getBoss(){
        return (Boss) getChara();
    }

    public void fight(Boss boss, Hero hero){
        if(hero.haveWeapon()){
            Weapon pickaxe = hero.getBag().getWeapon();
            while (true){
                pickaxe.attack(boss);
                System.out.println(boss.getNAME() + " take " + pickaxe.getDamage() + " damage!");

                if(boss.isDead()){
                    break;
                }

                boss.attack(hero);
                System.out.println("You take " + boss.getStrength() + " damage!");

                if(hero.isDead()){
                    break;
                }
            }
        }else{
            System.out.println("OH NO, you don't have a weapon.");
            while (true){
                hero.attack(boss);
                System.out.println(boss.getNAME() + " take " + hero.getStrength() + " damage!");

                if(boss.isDead()){
                    break;
                }

                boss.attack(hero);
                System.out.println("You take " + boss.getStrength() + " damage!");

                if(hero.isDead()){
                    break;
                }
            }
        }

        if (boss.isDead()){
            System.out.println("Good job, " + boss.getNAME() + " is dead!");
            this.chara = null;
        }else {
            System.out.println("Oh no, you are dead!");
        }
    }

    public Item getItem(String name){
        boolean isfound = false;
        Item found = null;
        if (this.items == null) { // liste vide
            this.items = new ArrayList<>();
        }else {
            for (Item item : items) {
                if (item.getName().equals(name)) {
                    return item;
                }
            }
        }

        System.out.println("Item " + name + " not found!");
        return null;
    }


    public void addItem(Item item){
        if(this.items == null){
            this.items = new ArrayList<Item>();
            this.items.add(item);
        }else{
            this.items.add(item);
        }
    }

}
