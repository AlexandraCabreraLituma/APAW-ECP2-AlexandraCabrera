package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TrainerDto;
import api.entities.Trainer;

public class TrainerBusinessController {

    public String create(TrainerDto trainerDto) {
        Trainer trainer = new Trainer(trainerDto.getNie(),trainerDto.getFirstName(),null);
        DaoFactory.getFactory().getTrainerDao().save(trainer);
      //  System.out.print("TrainerBusinessController");
        return trainer.getNie();
    }

}
