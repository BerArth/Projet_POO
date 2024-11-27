
package Test;

import Characters.*;
import Items.*;
import Locations.Room;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class RoomTest {

    private Room room;
    private Room roomWithBoss;
    private Boss boss;
    private Hero hero;
    private Weapon pickaxe;

    @Before
    public void setUp() {

        boss = new Boss("BadGuy", "Ouaf");
        hero = new Hero("Michel", "Miaou");
        Weapon pickaxe = new Weapon("Pickaxe", 50, 50, "Desc pickaxe");

        room = new Room("Test Room", "A room for testing", null, null);
        roomWithBoss = new Room("Test Room", "A room for testing", boss, null);

    }

}
