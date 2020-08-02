package Model;

public class Book {
    private int ISBN;
    private int author_id;
    private String title;
    private int publication_year;
    private float price;
    private int publisher_id;

    public Book(int ISBN, int author_id, String title, int publication_year,  int publisher_id, float price) {
        this.ISBN = ISBN;
        this.author_id = author_id;
        this.title = title;
        this.publication_year = publication_year;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public Book(int isbn, int author_id, String title, String publisher_id, int publication_year, float price) {
    }


    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Author ID: " + author_id + ", Title: " + title
                + ", Publication Year: " + publication_year + ", Publisher ID: " + publisher_id
                + ", Price: " + price;
    }
}


