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
    private Bag bag;
    private Bag bag2;
    private Weapon pickaxe;
    private Weapon sword;

    @Before
    public void setUp() {

        boss = new Boss("BadGuy", "Ouaf");
        hero = new Hero("Michel", "Miaou");
        pickaxe = new Weapon("Pickaxe", 50, 50, "Desc pickaxe");
        sword = new Weapon("Sword", 50, 70, "Desc sword");
        bag = new Bag("Bag", 10, "a bag");
        bag2 = new Bag("Bag2", 10, "a bag");
        room = new Room("Test Room", "A room for testing", null, null);
        roomWithBoss = new Room("Test Room", "A room with a boss", boss, null);

    }

    @Test
    public void testFightWithPickaxe() {
        bag.setOwner(hero);
        hero.getBag().addItem(pickaxe);
        roomWithBoss.fight(boss, hero);

        assertTrue(boss.isDead());
        assertFalse(hero.isDead());
    }

    /*@Test
    public void testFightWithSword() {
        bag.setOwner(hero);
        hero.getBag().addItem(sword);
        roomWithBoss.fight(boss, hero);

        assertTrue(boss.isDead());
        assertFalse(hero.isDead());
    }*/

    @Test
    public void testFightWithoutWeapon() {
        roomWithBoss.fight(boss, hero);

        assertTrue(hero.isDead());
        assertFalse(boss.isDead());
    }

    @Test
    public void haveBoss(){
        assertTrue(roomWithBoss.haveBoss());
        assertFalse(room.haveBoss());
    }

    @Test
    public void getItemsWithNoExistingThing() {
        room.addItem(bag);

        assertTrue(room.getItems().contains(bag));
        assertFalse(room.getItems().contains(bag2));
    }


}
