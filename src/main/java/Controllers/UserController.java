package Controllers;

import DAO.BooksDAO;
import DAO.PSQLBooksDAO;
import Model.Book;
import View.View;

import java.sql.Connection;


public class UserController {

    private static View view;
    private final Connection conn;
    private final BooksDAO booksDAO;

    public UserController(Connection conn, BooksDAO booksDAO) {
        view = new View();
        this.booksDAO = booksDAO;
        this.conn = conn;
    }


    public void run(){
        view = new View();
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.displayMainMenu();

            int input = view.getIntegerInput();

            switch(input) {
                case 1:
                    break;
                case 2:
                    //Update book's data
                    break;
                case 3:
                    delete();
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
                    System.out.println("There is no such choice");
            }
        }

    }

    protected void delete() {
        view.clearScreen();
        System.out.println("Enter title of book to be removed: ");
        Book book = booksDAO.getBookFromDataBase(view.getStringInput());
        if (book != null) {
            view.clearScreen();
            view.displayConfirmationRequestMessage(book.getTitle());
            if (view.getStringInput().equalsIgnoreCase("y")) {
                booksDAO.delete(book);
                view.displayRemovalMessage("Book");
                view.pressEnterToContinue();
            }
        } else {
            System.out.println("This book doesn't exist");
            view.pressEnterToContinue();
        }
    }

}
