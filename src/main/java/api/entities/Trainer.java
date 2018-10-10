package api.entities;

public class Trainer {


    private String nie;
    private String firstName;
    private String lastName;

    public Trainer(String nie, String firstName) {
        this.nie = nie;
        this.firstName = firstName;

    }
    public void setNie(String nie) {
        this.nie = nie;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "nie='" + nie + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
