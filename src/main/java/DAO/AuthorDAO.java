package DAO;
import Model.Author;

import java.util.List;

public interface AuthorDAO {

    List<Author> getAuthorsFromDataBase();

}
