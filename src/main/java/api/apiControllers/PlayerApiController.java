package api.apiControllers;

import api.businessController.PlayerBussinessController;
import api.dtos.PlayerDto;
import api.exceptions.ArgumentNotValidException;

public class PlayerApiController {

    public static final String PLAYERS = "/players";
    private PlayerBussinessController playerBusinessController = new PlayerBussinessController();

    public String create(PlayerDto playerDto) {
        this.validate(playerDto, "playerDto");
        this.validate(playerDto.getNie(), "playerDto Nie");
        this.validate(playerDto.getFirstName(), "playerDto FirstName");
        this.validate(playerDto.getPosition(), "playerDto Position");
        return this.playerBusinessController.create(playerDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }

}
