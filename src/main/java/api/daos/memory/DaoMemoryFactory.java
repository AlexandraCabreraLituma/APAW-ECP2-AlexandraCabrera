package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.TrainerDao;
import api.daos.PlayerDao;

public class DaoMemoryFactory extends DaoFactory {

    private TrainerDao trainerDao;
    private PlayerDao playerDao;

    @Override
    public TrainerDao getTrainerDao() {
        if (trainerDao == null) {
            trainerDao = new TrainerDaoMemory();
        }
        return trainerDao;
    }
    @Override
    public PlayerDao PlayerDao() {
        if (playerDao == null) {
            playerDao = new PlayerDaoMemory();
        }
        return playerDao;
    }
}
