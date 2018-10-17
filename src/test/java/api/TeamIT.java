package api;

import api.apiControllers.PlayerApiController;
import api.apiControllers.TeamApiController;
import api.apiControllers.TrainerApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.PlayerDto;
import api.dtos.TeamDto;
import api.dtos.TeamIdNameDto;
import api.dtos.TrainerDto;
import api.entities.Position;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TeamIT {
    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    @Test
    void testCreateTeam() {
        this.createTeam();
    }
    private String createTeam() {
        String trainerNie=this.createTrainer();
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).body(new TeamDto("01","Golden State",null,null,trainerNie)).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createTrainer() {
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS).body(new TrainerDto("1400","Alexandra",null)).post();
        return (String) new Client().submit(request).getBody();
    }
    @Test
    void createTeamTrainerNieNotFound() {
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS)
                .body(new TeamDto("02", "Lakers", "51")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
    @Test
    void createTeamWithoutArguments() {
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS)
                .body(new TeamDto(null, null, null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
    @Test
    void createPlayerWithoutiD() {
        String trainerNie=this.createTrainer();
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS)
                .body(new TeamDto(null, "Caveliers", trainerNie )).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
    @Test
    void testUpdatePlayers() {
        String id = this.createTeam();
        List<String> players = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            players.add(this.createPlayer("playerNie"+i,"playerFirstName"+1,Position.FOWARD));
        }

        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).path(PlayerApiController.ID_ID)
                .expandPath(id).path(TeamApiController.PLAYERS).body(players).patch();
        new Client().submit(request);
    }

    private String createPlayer(String nie, String firtsName, Position position) {
        HttpRequest request = HttpRequest.builder().path(PlayerApiController.PLAYERS).body(new PlayerDto(nie,firtsName, position)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testDelete() {
        String id = this.createTeam();
         HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).path(TeamApiController.ID_ID)
                .expandPath(id).delete();
        new Client().submit(request);
    }


    @Test
    void testSearchAverage() {
        this.createTeamwithPlayer();
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).path(TeamApiController.SEARCH)
                .param("q", "average:>=5").get();
        List<TeamIdNameDto> team = (List<TeamIdNameDto>) new Client().submit(request).getBody();
        assertFalse(team.isEmpty());
    }

    @Test
    void testSearchAverageWithoutParamQ() {
        this.createTeamwithPlayer();
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).path(TeamApiController.SEARCH)
                .param("error", "average:>=5").get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
    @Test
    void testSearchAverageParamError() {
        this.createTeamwithPlayer();
        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).path(TeamApiController.SEARCH)
                .param("error", "error:>=5").get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    private String createTeamwithPlayer() {

        String id = this.createTeam();
        List<String> players = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            players.add(this.createPlayer("playerNie" + i, "playerFirstName" + 1, Position.FOWARD));
        }

        HttpRequest request = HttpRequest.builder().path(TeamApiController.TEAMS).path(PlayerApiController.ID_ID)
                .expandPath(id).path(TeamApiController.PLAYERS).body(players).patch();

        return (String) new Client().submit(request).getBody();
    }
}
