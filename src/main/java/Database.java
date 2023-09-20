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
        // Find the superhero to edit based on their name
        Superhero superheroToEdit = null;
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroToEdit = superhero;
                break; // Found the superhero, exit the loop
            }
        }

        if (superheroToEdit == null) {
            System.out.println("Superhero not found.");
            return;
        }

        // Print out the original information before editing
        System.out.println("Original superhero details:");
        System.out.println(superheroToEdit);

        // Prompt the user for new values
        System.out.println("Editing superhero: " + superheroToEdit.getName());

        // Prompt for new name
        System.out.print("New name (press Enter to keep original): ");
        String newName = keyboard.nextLine();
        if (!newName.isEmpty()) {
            superheroToEdit.setName(newName);
        }

        // Prompt for new real name
        System.out.print("New real name (press Enter to keep original): ");
        String newRealName = keyboard.nextLine();
        if (!newRealName.isEmpty()) {
            superheroToEdit.setRealName(newRealName);
        }

        // Prompt for new super power
        System.out.print("New super power (press Enter to keep original): ");
        String newSuperPower = keyboard.nextLine();
        if (!newSuperPower.isEmpty()) {
            superheroToEdit.setSuperPower(newSuperPower);
        }

        // Prompt for new year created
        System.out.print("New year created (press Enter to keep original): ");
        String newYearCreatedStr = keyboard.nextLine();
        if (!newYearCreatedStr.isEmpty()) {
            int newYearCreated = Integer.parseInt(newYearCreatedStr);
            superheroToEdit.setYearCreated(newYearCreated);
        }

        // Prompt for new isHuman
        System.out.print("New is human (true/false, press Enter to keep original): ");
        String newIsHumanStr = keyboard.nextLine();
        if (!newIsHumanStr.isEmpty()) {
            superheroToEdit.setIsHuman(newIsHumanStr);
        }


        // Prompt for new strength
        System.out.print("New strength (press Enter to keep original): ");
        String newStrengthStr = keyboard.nextLine();
        if (!newStrengthStr.isEmpty()) {
            int newStrength = Integer.parseInt(newStrengthStr);
            superheroToEdit.setStrength(newStrength);
        }

        System.out.println("Superhero edited successfully.");

        // Print out the edited superhero
        System.out.println("Edited superhero details:");
        System.out.println(superheroToEdit);
    }


    public void deleteSuperhero(String name) {
        // Find the superhero to delete based on their name
        Superhero superheroToDelete = null;
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superheroToDelete = superhero;
                break; // Found the superhero, exit the loop
            }
        }

        if (superheroToDelete == null) {
            System.out.println("Superhero not found.");
            return;
        }

        // Remove the superhero from the list
        superheroes.remove(superheroToDelete);
        System.out.println("Superhero deleted successfully.");
    }



}









