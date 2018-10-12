package api.daos.memory;

import api.daos.PlayerDao;
import api.entities.Player;
import java.util.HashMap;

public class PlayerDaoMemory extends GenericDaoMemory<Player> implements PlayerDao {

    public PlayerDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Player player) {
        return player.getNie();
    }

    @Override
    public void setId(Player player, String nie) {
        player.setNie(nie);

    }
}

