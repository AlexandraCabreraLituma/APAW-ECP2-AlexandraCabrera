package api.apiControllers;

import api.businessController.TrainerBusinessController;
import api.dtos.TrainerDto;
import api.dtos.TrainerNieFirstNameDto;
import api.exceptions.ArgumentNotValidException;
import java.util.List;

public class TrainerApiController {

    public static final String TRAINERS = "/trainers";
    private TrainerBusinessController trainerBusinessController = new TrainerBusinessController();

    public String create(TrainerDto trainerDto) {
        this.validate(trainerDto, "trainerDto");
        this.validate(trainerDto.getNie(), "trainerDto Nie");
        this.validate(trainerDto.getFirstName(), "trainerDto FirstName");
        return this.trainerBusinessController.create(trainerDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
    public List<TrainerNieFirstNameDto> readAll() {
        return trainerBusinessController.readAll();
    }
}
