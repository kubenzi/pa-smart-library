package DAO;
import Model.Book;

import java.util.List;

public interface BookDAO {

    Book getBookFromDataBaseByISBN (long command);

    List<Book> getBooksFromDataBaseByAuthor (int command);

    List<Book> getBooksFromDataBase ();

    int add (Book book);

    void delete (Book book);

    void update (Book book);

}
