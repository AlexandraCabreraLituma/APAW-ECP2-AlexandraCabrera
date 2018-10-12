package api.apiControllers;
import api.businessController.TeamBussinessController;
import api.dtos.TeamDto;
import api.exceptions.ArgumentNotValidException;

public class TeamApiController {

    public static final String TEAMS = "/teams";
    private TeamBussinessController teamBusinessController = new TeamBussinessController();

    public String create(TeamDto teamDto) {
        this.validate(teamDto, "teamDto");
        this.validate(teamDto.getId(), "teamDto Id");
        this.validate(teamDto.getName(), "teamDto Name");
        return this.teamBusinessController.create(teamDto);
    }
    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
