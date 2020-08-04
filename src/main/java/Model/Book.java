package Model;

public class Book {
    private long ISBN;
    private int author_id;
    private String title;
    private String publisher_id;
    private int publication_year;
    private float price;


    public Book(long ISBN, int author_id, String title, String publisher_id, int publication_year, float price) {
        this.ISBN = ISBN;
        this.author_id = author_id;
        this.title = title;
        this.publisher_id = publisher_id;
        this.publication_year = publication_year;
        this.price = price;
    }

    public Book(int author_id, String title, String publisher_id, int publication_year, float price){
        this(999999999, author_id, title, publisher_id, publication_year, price);
    }



    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public long getISBN() {
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

    public String getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(String publisher_id) {
        this.publisher_id = publisher_id;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Author ID: " + author_id + ", Title: " + title
                + ", Publication Year: " + publication_year + ", Publisher ID: " + publisher_id
                + ", Price: " + price;
    }
}


