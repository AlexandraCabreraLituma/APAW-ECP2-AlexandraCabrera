package api;

import api.apiControllers.TeamApiController;
import api.apiControllers.TrainerApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.TeamDto;
import api.dtos.TrainerDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamIT {
    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private String createTrainer() {
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS).body(new TrainerDto("1400","Alexandra",null)).post();
        return (String) new Client().submit(request).getBody();
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

}
