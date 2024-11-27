package Test;

import Characters.Boss;
import Characters.Character;
import Characters.Helper;
import Characters.Hero;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CharacterTest {

    private Character character;
    private Character target;
    private Character hero;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp(){

        character = new Helper("Helper", "speach");
        target = new Boss("Boss", "boss");
        hero = new Hero("Hero", "hero");

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testConstructor(){
        assertEquals("Hero", hero.getNAME());
        assertEquals(100, hero.getHp());
        assertEquals(5, hero.getStrength());
    }

    @Test
    public void testSpeak(){
        hero.speak();
        assertTrue(outContent.toString().contains("hero"));
    }

    @Test
    public void testReducePv(){
        hero.reducePv(20);
        assertEquals(80, hero.getHp());

        hero.reducePv(100);
        assertEquals(0, hero.getHp());
    }

    @Test
    public void testIsDead(){
        assertFalse(hero.isDead());
        hero.reducePv(120);
        assertTrue(hero.isDead());
    }

    @Test
    public void testRestorePV(){
        hero.reducePv(50);
        hero.restorePv(30);
        assertEquals(80, hero.getHp());
        hero.restorePv(100);
        assertEquals(100, hero.getHp());

        hero.reducePv(100);
        hero.restorePv(100);
        assertEquals(0, hero.getHp());

    }

    @Test
    public void testAttack(){
        assertEquals(200, target.getHp());
        hero.attack(target);
        assertEquals(195, target.getHp());
    }

}