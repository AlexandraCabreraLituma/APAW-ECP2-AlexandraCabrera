package api;

import api.apiControllers.TrainerApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.TrainerDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TrainerIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    @Test
    void testCreateUser() {
        this.createTrainer();
    }

    private String createTrainer() {
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS).body(new TrainerDto("1400","Alexandra",null)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testTrainerInvalidRequest(){
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS+"/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateTrainerWithoutTrainerDto() {
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateTrainerWithoutTrainerDtoNie() {
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS).body(new TrainerDto(null,null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }


}
