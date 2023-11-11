import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream("SuperHero Database.txt");
        Controller controller = new Controller();
        Userinterface ui = new Userinterface(controller);
        ui.startProgram();
        ui.closeScanner();

    }
}