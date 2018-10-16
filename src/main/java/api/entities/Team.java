package api.entities;

import java.util.List;

public class Team {
    private String id;
    private String name;
    private String nick;
    private Trainer trainer;
    private List<Player> players;

    public Team(String id, String name, String nick, List<Player> players,Trainer trainer) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.trainer = trainer;
        this.players = players;
    }

    public String getId() {
        return id;
    }
    public String getName() {return name;}
    public String getNick() {return nick;}

    public List<Player> getPlayers() {
        return players;
    }
    public Trainer getTrainer() {return trainer;}

    public void setPlayers(List<Player> players) {this.players = players;}

    public void setId(String id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setNick(String nick) {this.nick = nick;}
    public void setTrainer(Trainer trainer) {this.trainer = trainer;}
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

}
