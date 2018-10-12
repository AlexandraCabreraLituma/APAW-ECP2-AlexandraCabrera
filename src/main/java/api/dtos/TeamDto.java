package api.dtos;

import api.entities.Player;
import api.entities.Trainer;

import java.util.List;

public class TeamDto {
    private String id;
    private String name;
    private String nick;
    private String trainer;
    private List<String> players;

    public TeamDto(String id, String name, String trainer) {
        this.id = id;
        this.name = name;
        this.trainer = trainer;
    }
    public TeamDto(String id, String name, List<String> players, String trainer) {
        this.id = id;
        this.name = name;
        this.players=players;
        this.trainer = trainer;
    }

    public TeamDto(String id, String name, String nick, List<String> players,String trainer) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.trainer = trainer;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public String getTrainer() {
        return trainer;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", trainer=" + trainer +
                ", players=" + players +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
}
