package api.dtos;

import api.entities.Trainer;

public class TrainerNieFirstNameDto {
    private String nie;
    private String firstName;

    public TrainerNieFirstNameDto(Trainer trainer) {
        this.nie = trainer.getNie();
        this.firstName = trainer.getFirstName();
    }
    public String getNie() {
        return nie;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "TrainerNieFirstNameDto{" +
                "nie='" + nie + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
