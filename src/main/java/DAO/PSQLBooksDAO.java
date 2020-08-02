package DAO;

import Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PSQLBooksDAO implements BooksDAO{
    private final Connection conn;

    public PSQLBooksDAO (Connection conn) {
        this.conn = conn;
    }

    @Override
    public Book getBookFromDataBase(String title) {
        String sql = "SELECT * FROM books WHERE title = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, title);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int ISBN = rs.getInt(1);
                int author_id = rs.getInt(2);
                String publisher_id = rs.getString(4);
                int publication_year = rs.getInt(5);
                float price = rs.getFloat(6);

                return new Book(ISBN, author_id, title, publisher_id, publication_year, price);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int add(Book book) {
        String sql = "INSERT INTO books (ISBN, author_id, title, publisher_id, publication_year, price) VALUES (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, book.getISBN());
            st.setInt(2, book.getAuthor_id());
            st.setString(3, book.getTitle());
            st.setInt(4, book.getPublisher_id());
            st.setInt(5, book.getPublication_year());
            st.setFloat(6, book.getPrice());

            return st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(Book book) {
        String sql = "DELETE FROM books WHERE title = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, book.getTitle());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }

    }

    @Override
    public void update(Book book) {
        String sql = "UPDATE books SET ISBN = ?, author_id = ?, title = ?, publisher_id = ?, publication_year = ?, price = ? WHERE title = ?";
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, book.getISBN());
            st.setInt(2, book.getAuthor_id());
            st.setString(3, book.getTitle());
            st.setInt(4, book.getPublisher_id());
            st.setInt(5, book.getPublication_year());
            st.setFloat(6, book.getPrice());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }

    }

}
