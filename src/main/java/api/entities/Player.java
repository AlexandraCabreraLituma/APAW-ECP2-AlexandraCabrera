package api.entities;

public class Player {

    private String nie;
    private String firstName;
    private String lastName;
    private int number;
    private Position position;

    public Player(String nie, String firstName, String lastName, int number, Position position) {
        this.nie = nie;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.position = position;
    }

    public String getNie() {
        return nie;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    public Position getPosition() {
        return position;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public void setNie(String nie) {
        this.nie = nie;
    }

    public void setPosition(Position position) {

        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nie='" + nie + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                ", position=" + position +
                '}';
    }


}
