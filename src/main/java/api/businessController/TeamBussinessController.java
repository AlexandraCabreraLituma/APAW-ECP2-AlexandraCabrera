package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TeamDto;
import api.dtos.TrainerDto;
import api.entities.Team;
import api.entities.Trainer;

import api.exceptions.NotFoundException;

public class TeamBussinessController {
    public String create(TeamDto teamDto) {
        Trainer trainer = DaoFactory.getFactory().getTrainerDao().read(teamDto.getTrainer()).orElseThrow(
                () -> new NotFoundException("Team (" + teamDto.getTrainer() + ")"));
        Team team = new Team(teamDto.getId(),teamDto.getName(),null, null,trainer);
        DaoFactory.getFactory().getTeamDao().save(team);
        return team.getId();
    }
}
