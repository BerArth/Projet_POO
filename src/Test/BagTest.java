package Test;

import Characters.Hero;
import Items.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class BagTest {

    private Bag bag;
    private Hero hero;
    private Item item1;
    private Item item2;
    private KeyPart keyPart;
    private Weapon weapon;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp(){
        bag = new Bag("Hero bag", 10, "juste a bag");
        hero = new Hero("Luc", "I am Hero");
        item1 = new Food("Bread", 5, 30, "A part of bread");
        item2 = new Book("Book", 10, "Just a book");
        keyPart = new KeyPart(2);
        weapon = new Weapon("Pickaxe", 20, 20, "Just a pickaxe");

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testBagInit(){
        assertEquals("Hero bag", bag.getName());
        assertEquals(10, bag.getWeight());
        assertEquals("juste a bag", bag.getDescription());
        assertEquals(0, bag.getCapacity());
        assertNotNull(bag.getItems());
        assertEquals(0, bag.getItems().size());
    }

    @Test
    public void testGetSetHero(){
        bag.setOwner(hero);
        assertEquals(hero, bag.getOwner());
        assertEquals(bag, hero.getBag());

        Hero newHero = new Hero("Jean", "I am new Hero");
        bag.setOwner(newHero);
        assertEquals(newHero, bag.getOwner());
        assertEquals(bag, newHero.getBag());
        assertNull(hero.getBag());
    }

    @Test
    public void testAddItem(){
        bag.addItem(item1);
        assertEquals(item1, bag.getItems().getFirst());
        assertEquals(1, bag.getItems().size());
        assertEquals(5, bag.getCapacity());
        bag.addItem(item2);
        assertEquals(item2, bag.getItems().get(1));
        assertEquals(2, bag.getItems().size());
        assertEquals(15, bag.getCapacity());
        assertFalse(bag.addItem(new Weapon("Heavy Stone", 90, 5, "A very heavy stone")));
        assertEquals(15, bag.getCapacity());
    }

    @Test
    public void testRemoveItem(){
        bag.addItem(item1);
        bag.removeItem(item1);
        assertEquals(0, bag.getItems().size());
        assertEquals(0, bag.getCapacity());
        bag.removeItem(item2);
        assertTrue(outContent.toString().contains("Book is actually not in your bag."));
    }

    @Test
    public void testGetKeyPart(){
        bag.addItem(item1);
        bag.addItem(keyPart);

        List<KeyPart> keyParts = bag.getKeyParts();
        assertEquals(1, keyParts.size());
        assertTrue(keyParts.contains(keyPart));
    }
}