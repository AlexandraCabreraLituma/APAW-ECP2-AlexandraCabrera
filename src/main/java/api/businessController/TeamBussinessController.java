package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TeamDto;
import api.dtos.TeamIdNameDto;
import api.entities.Player;
import api.entities.Team;
import api.entities.Trainer;
import api.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class TeamBussinessController {
    public String create(TeamDto teamDto) {
        Trainer trainer = DaoFactory.getFactory().getTrainerDao().read(teamDto.getTrainer()).orElseThrow(
                () -> new NotFoundException("Team (" + teamDto.getTrainer() + ")"));
        Team team = new Team(teamDto.getId(),teamDto.getName(),null, null,trainer);
        DaoFactory.getFactory().getTeamDao().save(team);
        return team.getId();
    }
    public void updatePlayer(String teamId, List<Player> player) {
        Team team = DaoFactory.getFactory().getTeamDao().read(teamId)
                .orElseThrow(() -> new NotFoundException("Team (" + teamId + ")"));
        team.setPlayers(player);
        DaoFactory.getFactory().getTeamDao().save(team);
    }
    public void delete(String id) {
        DaoFactory.getFactory().getTeamDao().deleteById(id);
    }

    public List<TeamIdNameDto> findByAverageGreaterThanEqual(Integer value) {
        return DaoFactory.getFactory().getTeamDao().findByPlayersNotEmpty().stream()
                .filter(theme -> this.counter(theme) >= value)
                .map(TeamIdNameDto::new)
                .collect(Collectors.toList());
    }

    private Integer counter(Team team) {
        return team.getPlayers().toArray().length;

    }
}
