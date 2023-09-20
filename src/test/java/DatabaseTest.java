import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAddSuperhero() {
        // Define test data
        String name = "TestHero";
        String realName = "TestRealName";
        String superPower = "TestPower";
        int yearCreated = 2000;
        String isHuman = "yes";
        int strength = 100;

        // Add a superhero to the database
        database.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

        // Retrieve the superhero from the database
        Superhero addedHero = database.getSuperheroes().get(2); // Assuming there are two predefined heroes

        // Check if the added superhero matches the test data
        assertNotNull(addedHero);
        assertEquals(name, addedHero.getName());
        assertEquals(realName, addedHero.getRealName());
        assertEquals(superPower, addedHero.getSuperPower());
        assertEquals(yearCreated, addedHero.getYearCreated());
        assertEquals(isHuman, addedHero.getIsHuman());
        assertEquals(strength, addedHero.getStrength());
    }






}
