import java.util.ArrayList;

public class Controller {


    Database database = new Database();

    public Controller() {
    }

    public void editSuperHero(String name) {
        database.editSuperhero(name);
    }
    public void deleteSuperHeroes(String name){
        database.deleteSuperhero(name);
    }

    public void addSuperhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength){
    database.addSuperhero(name,realName,superPower,yearCreated,isHuman,strength);
    }

    public void printSuperhero(){
        database.printSuperheroes();
    }

    public ArrayList<Superhero> searchSuperHero(String name) {
       return database.searchSuperhero(name);
    }


    public ArrayList<Superhero>getsuperheroes(){
        return database.getSuperheroes();
    }

}
