package api.businessController;

import api.daos.DaoFactory;
import api.dtos.PlayerDto;
import api.entities.Player;
import api.exceptions.NotFoundException;

public class PlayerBussinessController {
    public String create(PlayerDto playerDto) {

        Player player = new Player(playerDto.getNie(), playerDto.getFirstName(),null,0,playerDto.getPosition());
        DaoFactory.getFactory().getPlayerDao().save(player);
        return player.getNie();
    }
    public void updateNie(String nie, PlayerDto playerDto) {
        Player player = DaoFactory.getFactory().getPlayerDao().read(nie).orElseThrow(() -> new NotFoundException("Player nie: " + nie));
        player.setNie(playerDto.getNie());
        player.setFirstName(playerDto.getFirstName());
        player.setPosition(playerDto.getPosition());
        DaoFactory.getFactory().getPlayerDao().save(player);
    }
}
