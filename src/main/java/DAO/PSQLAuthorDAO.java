package DAO;

import Model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PSQLAuthorDAO implements AuthorDAO {

    private final Connection conn;

    public PSQLAuthorDAO (Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<Author> getAuthorsFromDataBase() {
        ArrayList<Author> authorsList = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        try(PreparedStatement st = this.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()){
                int ID = rs.getInt(1);
                String first_name = rs.getString(2);
                String surname = rs.getString(3);
                authorsList.add(new Author(ID, first_name, surname));
            }

        } catch (SQLException e) {
            System.out.println("Error executing query");
        }
        return authorsList;
    }
}
