package DAO;
import Model.Book;

import java.util.List;

public interface BooksDAO {

    Book getBookFromDataBase (long command);

    List<Book> getBooksFromDataBase ();

    int add (Book book);

    void delete (Book book);

    void update (Book book);



}
