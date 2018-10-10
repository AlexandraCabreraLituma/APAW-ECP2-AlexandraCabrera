package api.dtos;

public class TrainerDto {

    private String nie;

    private String firstName;
    private String lastName;

    public TrainerDto(String nie, String firstName) {
        this.nie = nie;
        this.firstName = firstName;
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

    public void setNie(String nie) {
        this.nie = nie;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "TrainerDto{" +
                "nie='" + nie + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
