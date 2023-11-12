import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {
    private Database database;
    ArrayList<Superhero> testSuperheroes = new ArrayList<>();
    private String testFileName = "testSuperheroes.csv";



    @Before
    public void setUp() {
        database = new Database();

        Superhero testHero1 = new Superhero("TestHero", "TestRealName", "TestPower", 2000, "yes", 100);

        testSuperheroes.add(testHero1);


    }

    @Test
    public void testAddSuperhero() {
        String name = "TestHero2";
        String realName = "TestRealName2";
        String superPower = "TestPower2";
        int yearCreated = 2000;
        String isHuman = "yes";
        int strength = 100;

        database.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

        ArrayList<Superhero> superheroes = database.getSuperheroes();

        assertNotNull(superheroes);
        assertTrue(superheroes.size() > 0);

        Superhero addedHero = superheroes.get(superheroes.size() - 1);

        assertNotNull(addedHero);
        assertEquals(name, addedHero.getName());
        assertEquals(realName, addedHero.getRealName());
        assertEquals(superPower, addedHero.getSuperPower());
        assertEquals(yearCreated, addedHero.getYearCreated());
        assertEquals(isHuman, addedHero.getIsHuman());
        assertEquals(strength, addedHero.getStrength());
    }


    @Test
    public void testDeleteSuperhero() {
        assertNotNull(database.searchSuperhero("TestHero1"));

        database.deleteSuperhero("TestHero1");

        assertTrue(database.searchSuperhero("TestHero1").isEmpty());
    }

    @Test
    public void testDeleteNonexistentSuperhero() {
        database.deleteSuperhero("Wonder Woman");

        assertTrue(database.searchSuperhero("Wonder Woman").isEmpty());
    }


}

