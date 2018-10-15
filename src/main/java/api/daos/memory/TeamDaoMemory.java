package api.daos.memory;

import api.daos.TeamDao;
import api.entities.Team;
import java.util.HashMap;

public class TeamDaoMemory extends GenericDaoMemory<Team> implements TeamDao {

    public TeamDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Team team) {
        return team.getId();
    }

    @Override
    public void setId(Team team, String id) {
        team.setId(id);

    }
}
