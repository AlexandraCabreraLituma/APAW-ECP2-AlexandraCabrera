package api.businessController;

import api.daos.DaoFactory;
import api.dtos.PlayerDto;
import api.dtos.TrainerDto;
import api.entities.Player;
import api.entities.Trainer;

public class PlayerBussinessController {
    public String create(PlayerDto playerDto) {

        Player player = new Player(playerDto.getNie(), playerDto.getFirstName(),null,0,playerDto.getPosition());
        DaoFactory.getFactory().PlayerDao().save(player);
        return player.getNie();
    }
}
