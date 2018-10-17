package api.daos;

import api.entities.Team;

import java.util.List;

public interface TeamDao extends GenericDao<Team, String> {
    List<Team> findByPlayersNotEmpty();
}
