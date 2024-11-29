package Test;

import Characters.Hero;
import Characters.Retailer;
import Items.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RetailerTest {

    private Retailer retailer;
    private Hero hero;
    private Item flacon;
    private Item gold;
    private Item book;
    private Bag bag;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp(){
        retailer = new Retailer("Retailer", "I am the retailer.");
        hero = new Hero("Hero", "I am the hero.");
        flacon = new Flacon("Flacon", 6, "Just a Flacon");
        gold = new Gold();
        book = new Book("Book", 5, "Its a book");
        bag = new Bag("Bag", 5, "Its a bag");
    }

    @Test
    public void testAddInventory(){
        List<Item> price = new ArrayList<>(List.of(gold));
        retailer.addInventory(flacon, price);

        assertTrue(retailer.getInventory().containsKey(flacon));
        assertEquals(price, retailer.getInventory().get(flacon));
    }

    @Test
    public void testRemoveInventory(){
        List<Item> price = new ArrayList<>(List.of(gold));
        retailer.addInventory(flacon, price);
        retailer.removeInventory(flacon);

        assertFalse(retailer.getInventory().containsKey(flacon));

    }

    @Test
    public void testTradeFailure_ItemNotInInventory() {
        System.setOut(new PrintStream(outContent));

        hero.setBag(bag);

        retailer.Trade(hero, "NonExistentItem");

        assertTrue(outContent.toString().contains("Sorry, NonExistentItem doesn't exist!"));
    }

    @Test
    public void testTradeFailure_InsufficientItems() {
        List<Item> price = new ArrayList<>(List.of(gold));
        retailer.addInventory(flacon, price);

        hero.setBag(bag);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        retailer.Trade(hero, "Flacon");

        assertTrue(outContent.toString().contains("Sorry, you don't have the required items!"));
    }

    @Test
    public void testTradeSuccess() {
        List<Item> price = new ArrayList<>(List.of(gold));
        retailer.addInventory(flacon, price);

        hero.setBag(bag);
        hero.getBag().addItem(gold);

        System.setOut(new PrintStream(outContent));

        retailer.Trade(hero, "Flacon");

        assertFalse(hero.getBag().haveItem("Gold"));
        assertTrue(hero.getBag().haveItem("Flacon"));

        assertTrue(outContent.toString().contains("Trade successful! You received: Flacon\n"));

        Map<Item, List<Item>> inventory = retailer.getInventory();
        assertFalse(inventory.containsKey(flacon));
    }
}