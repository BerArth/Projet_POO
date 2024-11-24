package Test;

import Characters.Hero;
import Items.*;
import Locations.Room;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class HeroTest {

    private Hero hero;
    private Room room;
    private Room roomWithBag;
    private Item bag;
    private Item bagV2;
    private Item item;
    private Item firefly;
    private Item net;
    private Item flacon;

    @Before
    public void setUp() {
        hero = new Hero("TestHero", "Hello");
        room = new Room("TestVoidRoom", "A room", null, null);

        bag = new Bag("Bag", 10, "a bag");
        bagV2 = new Bag("Bag", 10, "an another bag");
        /*List<Item> itemsTestRoomWithBag = new ArrayList<>();
        itemsTestRoomWithBag.add(bag);
        roomWithBag = new Room("TestRoomWithBag", "A room with a bag", null, itemsTestRoomWithBag);*/

        firefly = new Firefly("Firefly", 1, "a firefly");
        net = new Net("Net", 5, "a net");
        flacon = new Flacon("Flacon", 2, "a flacon");
    }

    @Test
    public void testTakeItemFromRoom_BagWithoutBag() {
        room.addItem(bag);
        hero.takeItemFromRoom(room, "Bag");
        assertNotNull(hero.getBag());   // le hero doit bien avoir un sac (notNull)
        assertEquals(bag, hero.getBag());   // le sac ajouté est bien le même que celui qui été dans la pièce
        assertFalse(roomWithBag.getItems().contains(bag)); // la pièce ne doit plus avoir de sac
    }

    @Test
    public void testTakeItemFromRoom_BagWithBag() {
        room.addItem(bag);
        hero.setBag((Bag) bagV2);
        hero.takeItemFromRoom(room, "Bag");
        assertNotNull(hero.getBag());  // le hero a bien un sac
        assertTrue(room.getItems().contains(bag)); // le sac est toujours dans la pièce
        assertNotEquals(bag, hero.getBag()); // le sac lié au héro n'est pas le même que celui de la pièce
    }

    @Test
    public void testTakeItemFromRoom_ItemWithoutBag() {
        room.addItem(net);
        hero.takeItemFromRoom(room, "Net");
        assertNull(hero.getBag());  // le hero n'a pas de sac | getBag == NULL
        assertTrue(room.getItems().contains(net)); // l'item est toujours dans la pièce
    }

    public void testTakeItemFromRoom_ItemWithBag() {
        room.addItem(net);
        hero.setBag((Bag) bag);
        hero.takeItemFromRoom(room, "Net");
        assertNotNull(hero.getBag().getItem("Net"));  // le hero a bien l'item
        assertFalse(room.getItems().contains(net)); // l'item n'est plus dans la pièce
    }

    public void testTakeItemFromRoom_FireflyWithoutNetWithBag() {
        room.addItem(firefly);
        hero.setBag((Bag) bag);
        hero.takeItemFromRoom(room, "Firefly");
        assertNull(hero.getBag().getItem("Firefly"));
    }

    public void testTakeItemFromRoom_FireflyWithNetWithBag() {
        room.addItem(firefly);
        hero.setBag((Bag) bag);
        hero.takeItemFromRoom(room, "Firefly");
        assertNotNull(hero.getBag().getItem("Firefly"));
    }


    @Test
    public void testTakeItemFromRoom_ItemNotInRoom() {
        hero.setBag((Bag) bag);
        hero.takeItemFromRoom(room, "NonExistentItem");
        assertNull(hero.getBag().getItem("NonExistentItem")); // l'item ne doit pas apparaitre dans l'inventaire
    }
}
