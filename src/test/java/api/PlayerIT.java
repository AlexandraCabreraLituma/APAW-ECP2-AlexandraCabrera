package api;

import api.apiControllers.PlayerApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.PlayerDto;
import api.entities.Position;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerIT {
    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    @Test
    void testCreatePlayer() {
        this.createPlayer();
    }

    private String createPlayer() {
        HttpRequest request = HttpRequest.builder().path(PlayerApiController.PLAYERS).body(new PlayerDto("2800","Eliza", Position.CENTER)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void createPlayerWithoutArguments() {
        HttpRequest request = HttpRequest.builder().path(PlayerApiController.PLAYERS)
                .body(new PlayerDto(null, null, null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
    @Test
    void createPlayerWithoutNie() {
        HttpRequest request = HttpRequest.builder().path(PlayerApiController.PLAYERS)
                .body(new PlayerDto(null, "Maria", Position.GUARD)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
    @Test
    void createPlayerWithoutPosition() {
        HttpRequest request = HttpRequest.builder().path(PlayerApiController.PLAYERS)
                .body(new PlayerDto("256", "Maria",null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreatePlayerWithoutPlayerDto() {
        HttpRequest request = HttpRequest.builder().path(PlayerApiController.PLAYERS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }



}
