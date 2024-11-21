package Locations;

import Characters.Boss;
import Characters.Character;
import Characters.Hero;
import Doors.DoorExit;
import Items.*;

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
            System.out.println("OH NO, you don't have weapon");
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

}
