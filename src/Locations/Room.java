package Locations;

import Characters.*;
import Characters.Character;

import java.util.HashMap;
import java.util.Map;

public class Room {

    private final String NAME;
    private final String description;
    private Map<String, Exit> exits;
    private Character chara;

    public Room(String name, String description, Character chara) {
        this.NAME = name;
        this.description = description;
        this.exits = new HashMap<String, Exit>();
        this.chara = chara;
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

}
