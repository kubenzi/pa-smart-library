package DAO;
import Model.Book;

public interface BooksDAO {

    int add (Book book);

    void delete (Book book);

    void update (Book book);

}
