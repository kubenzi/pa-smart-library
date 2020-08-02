package Controllers;

import View.View;

public class UserController {

    private static View view;

    public UserController() {
        view = new View();
    }


    public static void run(){
        view = new View();
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.displayMainMenu();

            int input = view.getIntegerInput();

            switch(input) {
                case 1:
                    //Add new book
                    break;
                case 2:
                    //Update book's data
                    break;
                case 3:
                    //Delete book
                    break;
                case 4:
                    //Search
                    break;
                case 5:
                    //All books
                    break;
                case 6:
                    //Quit
                    isRunning = false;
                    System.out.println("Bye!");
                default:
            }
        }

    }
}
