package api;

import api.apiControllers.TrainerApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.TrainerDto;
import api.dtos.TrainerNieFirstNameDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TrainerIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    @Test
    void testCreateTreaner() {
        this.createTrainer("1400","Alexandra");
    }

    private void createTrainer(String trainerNie,String trainerFirstName) {
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS)
                .body(new TrainerDto(trainerNie,trainerFirstName,null)).post();
        new Client().submit(request);
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

    @Test
    void testReadAll() {

        for (int i = 0; i < 5; i++) {
            this.createTrainer("trainerNie"+i,"trainerFirstName"+1);
        }
        HttpRequest request = HttpRequest.builder().path(TrainerApiController.TRAINERS).get();
        List<TrainerNieFirstNameDto> themes = (List<TrainerNieFirstNameDto>) new Client().submit(request).getBody();
        assertTrue(themes.size()>=5);
    }

}
