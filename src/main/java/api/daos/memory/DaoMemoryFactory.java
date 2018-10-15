package api.daos.memory;
import api.daos.DaoFactory;
import api.daos.TeamDao;
import api.daos.TrainerDao;
import api.daos.PlayerDao;

public class DaoMemoryFactory extends DaoFactory {

    private TrainerDao trainerDao;
    private PlayerDao playerDao;
    private TeamDao teamDao;

    @Override
    public TrainerDao getTrainerDao() {
        if (trainerDao == null) {
            trainerDao = new TrainerDaoMemory();
        }
        return trainerDao;
    }
    @Override
    public PlayerDao getPlayerDao() {
        if (playerDao == null) {
            playerDao = new PlayerDaoMemory();
        }
        return playerDao;
    }
    @Override
    public TeamDao getTeamDao() {
        if (teamDao == null) {
            teamDao = new TeamDaoMemory();
        }
        return teamDao;
    }
}
