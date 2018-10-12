package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TrainerDto;
import api.dtos.TrainerNieFirstNameDto;
import api.entities.Trainer;
import java.util.List;
import java.util.stream.Collectors;

public class TrainerBusinessController {

    public String create(TrainerDto trainerDto) {
        Trainer trainer = new Trainer(trainerDto.getNie(),trainerDto.getFirstName(),null);
        DaoFactory.getFactory().getTrainerDao().save(trainer);
        return trainer.getNie();
    }

    public List<TrainerNieFirstNameDto> readAll() {
        return DaoFactory.getFactory().getTrainerDao().findAll().stream().map(
                trainer -> new TrainerNieFirstNameDto(trainer)
        ).collect(Collectors.toList());
    }

}
