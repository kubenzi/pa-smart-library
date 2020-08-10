package Controllers;

import DAO.AuthorDAO;
import DAO.BookDAO;
import Model.Book;
import Model.Author;
import View.View;


import java.sql.Connection;
import java.util.ArrayList;



public class UserController {

    private static View view;
    public final Connection conn;
    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;

    public UserController(Connection conn, BookDAO bookDAO, AuthorDAO authorDAO) {
        view = new View();
        this.bookDAO = bookDAO;
        this.conn = conn;
        this.authorDAO = authorDAO;
    }


    public void run(){
        view = new View();
        view.clearScreen();
        boolean isRunning = true;

        while (isRunning) {

            view.clearScreen();
            view.displayMainMenu("main");

            int input = view.getIntegerInput();

            switch(input) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    view.clearScreen();
                    view.displayMainMenu("search");
                    int input4 = view.getIntegerInput();
                    switch(input4) {
                        case 1:
                            showBookByISBN();
                            break;
                        case 2:
                            showBooksByAuthor();

                            break;
                    }
                    break;
                case 5:
                    showAllBooks();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Bye!");
                default:
                    System.out.println("There is no such choice");
            }
        }

    }

    protected void update(){
        view.clearScreen();
        System.out.println("Enter ISBN of book to be updated: ");
        Book book = bookDAO.getBookFromDataBaseByISBN(view.getLongInput());
        if (book == null) {
            System.out.println("Book not found in the database");
            view.pressEnterToContinue();
        }
        long ISBN = view.readInputLong(book.getISBN());
        int author_id = view.readInputInt(book.getAuthor_id());
        String title = view.readInputString(book.getTitle());
        String publisher_id = view.readInputString(book.getPublisher_id());
        int publication_year = view.readInputInt(book.getPublication_year());
        float price = view.readInputFloat(book.getPrice());
        book.setISBN(ISBN);
        book.setAuthor_id(author_id);
        book.setTitle(title);
        book.setPublisher_id(publisher_id);
        book.setPublication_year(publication_year);
        book.setPrice(price);
        bookDAO.update(book);
        Book updatedBook = bookDAO.getBookFromDataBaseByISBN(ISBN);
        System.out.println(updatedBook);
        System.out.println("Book details has been updated");
        view.pressEnterToContinue();
    }

    protected void delete() {
        view.clearScreen();
        System.out.println("Enter ISBN of book to be removed: ");
        Book book = bookDAO.getBookFromDataBaseByISBN(view.getLongInput());
        //System.out.println(book);
        if (book != null) {
            view.clearScreen();
            view.displayConfirmationRequestMessage(book.getTitle());
            if (view.getStringInput().equalsIgnoreCase("y")) {
                bookDAO.delete(book);
                view.displayRemovalMessage("Book");
                view.pressEnterToContinue();
            }
        } else {
            System.out.println("This book doesn't exist");
            view.pressEnterToContinue();
        }
    }

    protected  void add() {
        view.clearScreen();
        Book book = enterBookData();
        bookDAO.add(book);
        System.out.println("Book" + book.getTitle() + "has been added");
        bookDAO.getBookFromDataBaseByISBN(book.getISBN());
        view.pressEnterToContinue();
    }

    private void showBookByISBN() {
        view.clearScreen();
        System.out.println("Enter ISBN: ");
        Book book = bookDAO.getBookFromDataBaseByISBN(view.getLongInput());
        System.out.println(book);
    }

    private void showBooksByAuthor(){
        view.clearScreen();
        ArrayList<Author> authors = (ArrayList<Author>) authorDAO.getAuthorsFromDataBase();
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i+1 + ". " + authors.get(i));
        }
        System.out.println(" ");
        System.out.println("Enter author_id: ");
        ArrayList<Book> books = (ArrayList<Book>) bookDAO.getBooksFromDataBaseByAuthor(view.getIntegerInput());
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i+1 + ". " + books.get(i));
        }
        view.pressEnterToContinue();
    }

    private void showAllBooks(){
        view.clearScreen();
        System.out.println("Your Library: \n");
        ArrayList<Book> books = (ArrayList<Book>) bookDAO.getBooksFromDataBase();

        for (int i = 0; i < books.size(); i++) {
            System.out.println(i+1 + ". " + books.get(i));
        }
        view.pressEnterToContinue();
    }

    private Book enterBookData() {
        String[] answers = new String[] {"", "", "", "", "", ""};
        String[] fields = {"ISBN", "author_id", "title", "publisher_id", "publication_year", "price"};

        for (int i = 0; i < fields.length ; i++) {
            displayBookAddScreen(fields[i], answers);
            answers[i] = view.getStringInput();
        }
        return new Book(Long.parseLong(answers[0]), Integer.parseInt(answers[1]), answers[2], answers[3], Integer.parseInt(answers[4]), Integer.parseInt(answers[5]));
    }

    private void displayBookAddScreen(String field, String[] answers) {
        view.clearScreen();
        System.out.println("Please enter book " + field + "\n");
        for (int i = 0; i < answers.length; i++) {
            System.out.println(new String[]{
                    "ISBN long",
                    "author_id int",
                    "title String",
                    "publisher_id String",
                    "publication_year int",
                    "price float"}[i] + ": " + answers[i]);
        }
    }
}

