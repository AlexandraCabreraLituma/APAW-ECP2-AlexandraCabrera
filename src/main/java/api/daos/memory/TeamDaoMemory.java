package api.daos.memory;

import api.daos.TeamDao;
import api.entities.Team;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<Team> findByPlayersNotEmpty() {
        return this.findAll().stream()
                .filter(team -> !team.getPlayers().isEmpty())
                .collect(Collectors.toList());
    }
}
