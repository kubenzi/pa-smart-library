package DAO;
import Model.Book;

public interface BooksDAO {

    Book getBookFromDataBase (String command);

    int add (Book book);

    void delete (Book book);

    void update (Book book);



}
