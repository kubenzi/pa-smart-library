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
            System.out.printf("|%d| %s", i + 1, options[i]);
            System.out.println();
        }
    }

    public void displayMainMenu(String command) {
        if (command == "main") {
            System.out.println("\n  S M A R T  L I B R A R Y  \n");
            String[] options = {"Add new book", "Update book's data", "Delete book", "Search", "All books", "Quit"};
            displayMenuOptions(options);
        } else if (command == "search") {
            System.out.println("\n  S E A R C H  \n");
            String[] options = {"Search by ISBN", "Search by Author"};
            displayMenuOptions(options);
        }
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

    public long getLongInput() {
        long input = scanner.nextLong();
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

    public void displayConfirmationRequestMessage(String title) {
        System.out.printf("Are you sure you want to remove book entitled: '%s'? [Y/N]%n", title);
    }

    public void displayRemovalMessage(String type) {
        System.out.println(type + " has been removed from database");
    }

    public void pressEnterToContinue() {
        System.out.print("Press enter to continue");
        scanner.nextLine();
    }

    public String readInputString(String defaultValue) {
        System.out.print("current value -> " + "'" + defaultValue + "'" + "): ");
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    public long readInputLong(long defaultValue) {
        System.out.print("current value -> " + "'" + defaultValue + "'" + "): ");
        Long input = scanner.nextLong();
        return input;
    }

    public int readInputInt(int defaultValue) {
        System.out.print("current value -> " + "'" + defaultValue + "'" + "): ");
        int input = scanner.nextInt();
        return input;
    }

    public float readInputFloat(float defaultValue) {
        System.out.print("current value -> " + "'" + defaultValue + "'" + "): ");
        int input = scanner.nextInt();
        return input;
    }
}
