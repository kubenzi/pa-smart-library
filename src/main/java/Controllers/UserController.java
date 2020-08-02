package Controllers;

import DAO.BooksDAO;
import DAO.PSQLBooksDAO;
import Model.Book;
import View.View;

import java.sql.Connection;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;


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


    private Book enterBookData() {
        String[] answers = new String[] {"", "", "", "", "", ""};
        String[] fields = {"ISBN", "author_id", "title", "publisher_id", "publication_year", "price"};

        for (int i = 0; i < fields.length ; i++) {
            displayBookAddScreen(fields[i], answers);
            answers[i] = view.getStringInput();
        }
        return new Book(answers[0], answers[1], answers[2], answers[3], answers[4], Integer.parseInt(answers[5]), Integer.parseInt(answers[6]));
    }

    private void displayBookAddScreen(String field, String[] answers) {
        view.clearScreen();
        System.out.println("Please enter book " + field + "\n");
        for (int i = 0; i < answers.length; i++) {
            System.out.println(new String[]{
                    "ISBN int",
                    "author_id int",
                    "title String",
                    "publisher_id int",
                    "publication_year int",
                    "price float"}[i] + ": " + answers[i]);
        }
    }
}

