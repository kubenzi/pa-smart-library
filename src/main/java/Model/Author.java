package Model;

public class Author {
    private int ID;
    private String first_name;
    private String surname;

    public Author(int ID, String first_name, String surname) {
        this.ID = ID;
        this.first_name = first_name;
        this.surname = surname;
    }

    public Author(String first_name, String surname){
        this(1, first_name, surname);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", First name: " + first_name + ", Surname: " + surname;
    }
}
