package View;

import java.util.Scanner;


public class View {

    private final Scanner scanner = new Scanner(System.in);


    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayMenuOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("  |%d| %s", i + 1, options[i]);
            System.out.println();
        }
    }

    public void displayMainMenu() {
        System.out.println("\n  S M A R T  L I B R A R Y  \n");
        String[] options = {"Add new book", "Update book's data", "Delete book", "Search", "All books", "Quit"};
        displayMenuOptions(options);
    }

    public int getIntegerInput() {
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Enter integer: ");
            System.out.print("\033[2C");
        }
        int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public String getStringInput() {
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            input = scanner.nextLine();
            System.out.println("Enter text: ");
        }
        return input;
    }
}
