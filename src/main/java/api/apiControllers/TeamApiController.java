package api.apiControllers;
import api.businessController.TeamBussinessController;
import api.dtos.TeamDto;
import api.dtos.TeamIdNameDto;
import api.exceptions.ArgumentNotValidException;
import api.entities.Player;

import java.util.List;

public class TeamApiController {

    public static final String TEAMS = "/teams";
    public static final String ID_ID = "/{id}";
    public static final String PLAYERS = "/players";
    public static final String SEARCH = "/search";


    private TeamBussinessController teamBusinessController = new TeamBussinessController();

    public String create(TeamDto teamDto) {
        this.validate(teamDto, "teamDto");
        this.validate(teamDto.getId(), "teamDto Id");
        this.validate(teamDto.getName(), "teamDto Name");
        return this.teamBusinessController.create(teamDto);
    }

    public void updatePlayer(String themeId, List<Player> player) {
        this.validate(player, "player");
        this.teamBusinessController.updatePlayer(themeId, player);
    }

    public void delete(String id) {
        this.teamBusinessController.delete(id);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
    public List<TeamIdNameDto> find(String query) {
        this.validate(query, "query param q");
        if (!"average".equals(query.split(":>=")[0])) {
            throw new ArgumentNotValidException("query param q is incorrect, missing 'average:>='");
        }
        return this.teamBusinessController.findByAverageGreaterThanEqual(Integer.valueOf(query.split(":>=")[1]));
    }


}
