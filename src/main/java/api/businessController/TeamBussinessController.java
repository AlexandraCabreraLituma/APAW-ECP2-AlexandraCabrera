package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TeamDto;
import api.entities.Player;
import api.entities.Team;
import api.entities.Trainer;
import api.exceptions.NotFoundException;

import java.util.List;

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

}
