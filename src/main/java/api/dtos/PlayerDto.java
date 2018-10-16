package api.dtos;

import api.entities.Position;

public class PlayerDto {
    private String nie;
    private String firstName;
    private String lastName;
    private int number;
    private Position position;

    public PlayerDto(String nie, String firstName, Position position) {
        this.nie = nie;
        this.firstName = firstName;
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

    public void setNie(String nie) {
        this.nie = nie;
    }

    public void setNumber(int number) {

        this.number = number;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public String toString() {
        return "PlayerDto{" +
                "nie='" + nie + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                ", position=" + position +
                '}';
    }
}
