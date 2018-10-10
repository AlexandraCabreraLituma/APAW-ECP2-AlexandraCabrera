package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.TrainerDao;

public class DaoMemoryFactory extends DaoFactory {

    private TrainerDao trainerDao;

    @Override
    public TrainerDao getTrainerDao() {
        if (trainerDao == null) {
            trainerDao = new TrainerDaoMemory();
        }
        return trainerDao;
    }
}
