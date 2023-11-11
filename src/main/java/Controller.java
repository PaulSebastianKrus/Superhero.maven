import java.util.ArrayList;

public class Controller {

    Database database = new Database();

    public Controller() {
    }

    public void editSuperHero(String name) {
        database.editSuperhero(name);
        database.saveListOfSuperheroesToFile("Hero.csv");
    }

    public void deleteSuperHeroes(String name) {
        database.deleteSuperhero(name);
        database.saveListOfSuperheroesToFile("Hero.csv");
    }

    public void addSuperhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        database.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);
        database.saveListOfSuperheroesToFile("Hero.csv");
    }

    public void printAndSortSuperheroes(String firstSortBy, String sortBy) {
        database.printAndSortSuperheroes(sortBy);
    }

    public ArrayList<Superhero> searchSuperHero(String name) {
        return database.searchSuperhero(name);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return database.getSuperheroes();
    }

    public void saveSuperheroesToFile(String fileName) {
        database.saveListOfSuperheroesToFile(fileName);
    }

}
