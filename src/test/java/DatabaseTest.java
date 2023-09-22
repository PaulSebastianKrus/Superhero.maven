import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();

    }

    @Test
    public void testAddSuperhero() {
        
        String name = "TestHero";
        String realName = "TestRealName";
        String superPower = "TestPower";
        int yearCreated = 2000;
        String isHuman = "yes";
        int strength = 100;

        
        database.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

        
        Superhero addedHero = database.getSuperheroes().get(2); 

        // Check if the added superhero matches the test data
        assertNotNull(addedHero);
        assertEquals(name, addedHero.getName());
        assertEquals(realName, addedHero.getRealName());
        assertEquals(superPower, addedHero.getSuperPower());
        assertEquals(yearCreated, addedHero.getYearCreated());
        assertEquals(isHuman, addedHero.getIsHuman());
        assertEquals(strength, addedHero.getStrength());
    }

    @BeforeEach
    public void setUpdelete() {
        database = new Database();
//tilføjer
        database.addSuperhero("Batman", "Bruce Wayne", "Utility belt", 1939, "yes", 100);
        database.addSuperhero("Superman", "Clark Kent", "Flight", 1938, "yes", 100);
    }

    @Test
    public void testDeleteSuperhero() {
        // Ensure that the superhero "Batman" exists in the database before deletion
        assertNotNull(database.searchSuperhero("Batman"));

        // Delete the superhero "Batman"
        database.deleteSuperhero("Batman");

        // Check that "Batman" is no longer in the database
        assertTrue(database.searchSuperhero("Batman").isEmpty());
    }

    @Test
    public void testDeleteNonexistentSuperhero() {
        // Try to delete a superhero that doesn't exist in the database
        database.deleteSuperhero("Wonder Woman");

        // Ensure that the superhero "Wonder Woman" is not in the database
        assertTrue(database.searchSuperhero("Wonder Woman").isEmpty());
    }
}

