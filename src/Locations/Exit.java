package Locations;

import Doors.*;

public class Exit {

    private final String DESCRIPTION;
    private final Room DIRECTION;
    private final Door door;

    public Exit(String description, Room direction, Door door) {
        this.DESCRIPTION = description;
        this.DIRECTION = direction;
        this.door = door;
    }

    public Room getDirection(){
        return DIRECTION;
    }

    public String getDescription(){
        return DESCRIPTION;
    }

    public Door getDoor(){
        return door;
    }

}
