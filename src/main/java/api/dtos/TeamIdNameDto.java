package api.dtos;

import api.entities.Team;

public class TeamIdNameDto {
    private String id;
    private String name;

    public TeamIdNameDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TeamIdPlayersDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
