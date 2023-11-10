import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public static ArrayList<Superhero> loadSuperheroesFromFile(String fileName) {
        ArrayList<Superhero> loadedSuperheroes = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNext()) {
                String name = fileScanner.nextLine();
                String realName = fileScanner.nextLine();
                String superPower = fileScanner.nextLine();
                int yearCreated = Integer.parseInt(fileScanner.nextLine());
                String isHuman = fileScanner.nextLine();
                int strength = Integer.parseInt(fileScanner.nextLine());

                Superhero superhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
                loadedSuperheroes.add(superhero);

                if (fileScanner.hasNext()) {
                    fileScanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fejl: " + e.getMessage());
        }
        return loadedSuperheroes;
    }

    public static void saveListOfSuperheroesToFile(String fileName, ArrayList<Superhero> superheroes) {
        try (PrintStream output = new PrintStream(fileName)) {
            for (Superhero superhero : superheroes) {
                output.println(superhero.getName());
                output.println(superhero.getRealName());
                output.println(superhero.getSuperPower());
                output.println(superhero.getYearCreated());
                output.println(superhero.getIsHuman());
                output.println(superhero.getStrength());
                output.println();
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Fejl: " + e.getMessage());
        }

    }
}
