package Locations;

import java.util.HashMap;
import java.util.Map;

public class Room {

    private final String NAME;
    private final String description;
    private Map<String, Exit> exits;
    public final boolean HAVE_BOSS;

    public Room(String name, String description, boolean haveBoss) {
        this.NAME = name;
        this.description = description;
        this.HAVE_BOSS = haveBoss;
        this.exits = new HashMap<String, Exit>();
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
