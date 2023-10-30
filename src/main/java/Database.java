import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    //private Superhero[]superheroes = new Superhero[20];
    private ArrayList<Superhero> superheroes = new ArrayList<>(20);
    private Scanner keyboard = new Scanner(System.in);


    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Database() {
        Superhero superhero1 = new Superhero("Batman", "kanikkehuske", "flagermus", 1980, "ja", 3000);
        Superhero superhero2 = new Superhero("superman", "kanikkehuske", "super", 1980, "ja", 4000);

        superheroes.add(superhero1);
        superheroes.add(superhero2);
    }


    public void addSuperhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        Superhero superhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        superheroes.add(superhero);
    }

    public void printSuperheroes() {
        for (Superhero superhero : superheroes) {
            System.out.println(superhero);
            System.out.println();
        }
    }

    public ArrayList<Superhero> searchSuperhero(String name) {
        ArrayList<Superhero> matchingSuperheroes = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingSuperheroes.add(superhero);

            }


        }
        return matchingSuperheroes;

    }

    public void editSuperhero(String name) {

        Superhero superheroToEdit = null;
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroToEdit = superhero;
                break;
            }
        }

        if (superheroToEdit == null) {
            System.out.println("Superhero not found.");
            return;
        }


        System.out.println("Original superhero details:");
        System.out.println(superheroToEdit);


        System.out.println("Editing superhero: " + superheroToEdit.getName());


        System.out.print("New name (press Enter to keep original): ");
        String newName = keyboard.nextLine();
        if (!newName.isEmpty()) {
            superheroToEdit.setName(newName);
        }


        System.out.print("New real name (press Enter to keep original): ");
        String newRealName = keyboard.nextLine();
        if (!newRealName.isEmpty()) {
            superheroToEdit.setRealName(newRealName);
        }


        System.out.print("New super power (press Enter to keep original): ");
        String newSuperPower = keyboard.nextLine();
        if (!newSuperPower.isEmpty()) {
            superheroToEdit.setSuperPower(newSuperPower);
        }


        System.out.print("New year created (press Enter to keep original): ");
        String newYearCreatedStr = keyboard.nextLine();
        if (!newYearCreatedStr.isEmpty()) {
            int newYearCreated = Integer.parseInt(newYearCreatedStr);
            superheroToEdit.setYearCreated(newYearCreated);
        }


        System.out.print("New is human (true/false, press Enter to keep original): ");
        String newIsHumanStr = keyboard.nextLine();
        if (!newIsHumanStr.isEmpty()) {
            superheroToEdit.setIsHuman(newIsHumanStr);
        }


        System.out.print("New strength (press Enter to keep original): ");
        String newStrengthStr = keyboard.nextLine();
        if (!newStrengthStr.isEmpty()) {
            int newStrength = Integer.parseInt(newStrengthStr);
            superheroToEdit.setStrength(newStrength);
        }

        System.out.println("Superhero edited successfully.");


        System.out.println("Edited superhero details:");
        System.out.println(superheroToEdit);
    }


    public void deleteSuperhero(String name) {

        Superhero superheroToDelete = null;
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroToDelete = superhero;
                break;
            }
        }

        if (superheroToDelete == null) {
            System.out.println("Superhero not found.");
            return;
        }


        superheroes.remove(superheroToDelete);
        System.out.println("Superhero deleted successfully.");
    }


}









