package api.daos.memory;

import api.daos.TrainerDao;
import api.entities.Trainer;
import java.util.HashMap;

public class TrainerDaoMemory extends GenericDaoMemory<Trainer> implements TrainerDao {

    public TrainerDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Trainer trainer) {
        return trainer.getNie();
    }

    @Override
    public void setId(Trainer trainer, String nie) {
        trainer.setNie(nie);

    }
}
