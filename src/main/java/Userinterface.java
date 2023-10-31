import java.util.ArrayList;
import java.util.Scanner;

public class Userinterface {

    private Controller controller;

    private Scanner keyboard = new Scanner(System.in);
    //private Database database = new Database();

    public Userinterface(Controller controller) {
        this.controller = controller;

    }



    public void startProgram() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            if (choice == -1) {
                System.out.println("Ugyldigt input. Prøv igen.");
                continue;
            }

            switch (choice) {
                case 1:
                    createSuperhero();
                    break;
                case 2:
                    deleteSuperhero();
                    break;
                case 5:
                    searchSuperhero();
                    break;
                case 6:
                    editSuperhero();
                    break;
                case 7:
                    printSuperheroes();
                    break;
                case 9:
                    exitProgram();
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }


    }


    public void closeScanner() {
        keyboard.close();
    }

    private void displayMenu() {
        System.out.println("Velkommen til SUPERHERO UNIVERSET.");
        System.out.println("1. Opret superhelt");
        System.out.println("2. slet superhelt");
        System.out.println("5. Søg på en superhelt");
        System.out.println("6. Rediger en superhelt");
        System.out.println("7. Udskriv liste af superhelte i databasen");
        System.out.println("9. Afslut");
        System.out.print("Indtast dit valg: ");
    }

    private int getUserChoice() {
        try {
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            return choice;
        } catch (java.util.InputMismatchException e) {

            keyboard.nextLine();
            return -1;
        }
    }

    private void createSuperhero() {
        System.out.print("Navn: ");
        String name = keyboard.nextLine();

        System.out.print("Real name: ");
        String realName = keyboard.nextLine();

        System.out.print("Super power: ");
        String superPower = keyboard.nextLine();

        int yearCreated = getValidIntegerInput("Year created: ");

        System.out.print("Is human: ");
        String isHuman = keyboard.next();


        int strength = getValidIntegerInput("Strength: ");

        controller.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);
    }
    private int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = keyboard.nextInt();
                keyboard.nextLine();
                return input;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ugyldig input. Indtast venligst et heltal.");
                keyboard.nextLine();
            }
        }
    }


    private void searchSuperhero() {
        System.out.print("Indtast søgning: ");
        String searchName = keyboard.next();
        ArrayList<Superhero> matchingSuperheroes = controller.searchSuperHero(searchName);

        if (matchingSuperheroes.isEmpty()) {
            System.out.println("Ingen matchende superhelte fundet.");
        } else {
            System.out.println("Matchende superhelte:");
            int count = 1;
            for (Superhero superhero : matchingSuperheroes) {
                System.out.println(count + ". " + superhero.getName());
                count++;
            }


            System.out.print("Vælg en superhelt (1-" + (count - 1) + "): ");
            int superheroChoice = keyboard.nextInt();
            if (superheroChoice >= 1 && superheroChoice < count) {
                Superhero selectedSuperhero = matchingSuperheroes.get(superheroChoice - 1);
                System.out.println("Du valgte: " + selectedSuperhero.getName());

                Superhero.displaySuperheroDetails(selectedSuperhero);

            } else {
                System.out.println("Ugyldigt valg.");
            }
        }
    }

    private void printSuperheroes() {
        System.out.println("Liste af superhelte");
        controller.printSuperhero();
    }

    private void exitProgram() {
        System.out.println("Afslutter programmet.");
        System.exit(0);
    }

    private void editSuperhero() {
        System.out.print("Indtast navnet på superhelten, du vil redigere: ");
        String name = keyboard.next();
        controller.editSuperHero(name);

    }

    private void deleteSuperhero() {
        System.out.print("Indtast navnet på superhelten, du vil slette: ");
        String name = keyboard.nextLine();
        controller.deleteSuperHeroes(name);


    }


}
