import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Database {

    private ArrayList<Superhero> superheroes = new ArrayList<>(20);
    private Scanner keyboard = new Scanner(System.in);




    public Database() {
        superheroes = FileHandler.loadSuperheroesFromFile("Hero.csv");
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void addSuperhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        superheroes = FileHandler.loadSuperheroesFromFile("Hero.csv");
        Superhero superhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        superheroes.add(superhero);
        saveListOfSuperheroesToFile("Hero.csv");
    }

    public void printAndSortSuperheroes(String sortBy) {
        superheroes = FileHandler.loadSuperheroesFromFile("Hero.csv");



        if (superheroes.isEmpty()) {
            System.out.println("Ingen superhelte blev fundet.");
            return;
        }

        switch (sortBy.toLowerCase()) {
            case "navn":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getName));
                break;
            case "rigtigt navn":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getRealName));
                break;
            case "superkraft":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getSuperPower));
                break;
            case "årstal":
                Collections.sort(superheroes, Comparator.comparingInt(Superhero::getYearCreated));
                break;
            case "er menneske":
                Collections.sort(superheroes, Comparator.comparing(Superhero::getIsHuman));
                break;
            case "styrke":
                Collections.sort(superheroes, Comparator.comparingInt(Superhero::getStrength));
                break;
            default:
                System.out.println("Ikke brugbart input");
                return;
        }
        System.out.println();
        System.out.println("Sorterede superhelte: " + superheroes);

        for (Superhero superhero : superheroes) {
            System.out.println(superhero);
            System.out.println();
        }
    }

    public ArrayList<Superhero> searchSuperhero(String name) {
        superheroes = FileHandler.loadSuperheroesFromFile("Hero.csv");
        ArrayList<Superhero> matchingSuperheroes = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingSuperheroes.add(superhero);

            }

        }
        return matchingSuperheroes;

    }

    public void editSuperhero(String name) {
        superheroes = FileHandler.loadSuperheroesFromFile("Hero.csv");

        Superhero superheroToEdit = null;
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroToEdit = superhero;
                break;
            }
        }

        if (superheroToEdit == null) {
            System.out.println("Superhelten kunne ikke findes.");
            return;
        }


        System.out.println("Originale superhelte informationer:");
        System.out.println(superheroToEdit);


        System.out.println("Redigerer superhelt: " + superheroToEdit.getName());


        System.out.print("Nyt navn (tryk Enter for at beholde det origninale): ");
        String newName = keyboard.nextLine();
        if (!newName.isEmpty()) {
            superheroToEdit.setName(newName);
        }


        System.out.print("Nyt rigigt navn (tryk Enter for at beholde det origninale): ");
        String newRealName = keyboard.nextLine();
        if (!newRealName.isEmpty()) {
            superheroToEdit.setRealName(newRealName);
        }


        System.out.print("Ny superkraft (tryk Enter for at beholde det origninale): ");
        String newSuperPower = keyboard.nextLine();
        if (!newSuperPower.isEmpty()) {
            superheroToEdit.setSuperPower(newSuperPower);
        }


        System.out.print("Nyt årstal (tryk Enter for at beholde det origninale): ");
        String newYearCreatedStr = keyboard.nextLine();
        if (!newYearCreatedStr.isEmpty()) {
            int newYearCreated = Integer.parseInt(newYearCreatedStr);
            superheroToEdit.setYearCreated(newYearCreated);
        }


        System.out.print("Ny er menneske (rigtigt/falsk, tryk Enter for at beholde det origninale): ");
        String newIsHumanStr = keyboard.nextLine();
        if (!newIsHumanStr.isEmpty()) {
            superheroToEdit.setIsHuman(newIsHumanStr);
        }


        System.out.print("Ny styrke (tryk Enter for at beholde det origninale): ");
        String newStrengthStr = keyboard.nextLine();
        if (!newStrengthStr.isEmpty()) {
            int newStrength = Integer.parseInt(newStrengthStr);
            superheroToEdit.setStrength(newStrength);
        }

        saveListOfSuperheroesToFile("Hero.csv");
        System.out.println("Superhelt redigeret succesfuldt.");

        System.out.println("Redigerede superhelte informationer:");
        System.out.println(superheroToEdit);
    }


    public void deleteSuperhero(String name) {
        superheroes = FileHandler.loadSuperheroesFromFile("Hero.csv");

        Superhero superheroToDelete = null;
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroToDelete = superhero;
                break;
            }
        }

        if (superheroToDelete == null) {
            System.out.println("Superhelt blev ikke fundet");
            return;
        }


        superheroes.remove(superheroToDelete);
        saveListOfSuperheroesToFile("Hero.csv");
        System.out.println("Superhelt er blev slettet");
    }



    public void saveListOfSuperheroesToFile(String fileName) {
        FileHandler.saveListOfSuperheroesToFile(fileName, superheroes);
    }


}
