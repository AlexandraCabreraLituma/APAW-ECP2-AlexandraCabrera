package api;

import api.apiControllers.PlayerApiController;
import api.apiControllers.TeamApiController;
import api.apiControllers.TrainerApiController;
import api.dtos.PlayerDto;
import api.dtos.TeamDto;
import api.dtos.TrainerDto;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    private static final String METHOD_ERROR = "method error:";

    private TrainerApiController trainerApiController = new TrainerApiController();
    private PlayerApiController playerApiController = new PlayerApiController();
    private TeamApiController teamApiController = new TeamApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String errorMessage = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    throw new RequestInvalidException(METHOD_ERROR +" " +request.getMethod() + ' ' + request.getPath());
                case PUT:
                    throw new RequestInvalidException(METHOD_ERROR +" " + request.getMethod() + ' ' + request.getPath());
                case PATCH:
                    throw new RequestInvalidException(METHOD_ERROR +" "  + request.getMethod() + ' ' + request.getPath());
                case DELETE:
                    throw new RequestInvalidException(METHOD_ERROR +" "  + request.getMethod() + ' ' + request.getPath());
                default:
                    throw new RequestInvalidException(METHOD_ERROR +" "  + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(errorMessage, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(errorMessage, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            exception.printStackTrace();
            response.setBody(String.format(errorMessage, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(TrainerApiController.TRAINERS)) {
            response.setBody(this.trainerApiController.create((TrainerDto) request.getBody()));
        }
        else if (request.isEqualsPath(PlayerApiController.PLAYERS)) {
            response.setBody(this.playerApiController.create((PlayerDto) request.getBody()));
        }
        else if (request.isEqualsPath(TeamApiController.TEAMS)) {
            response.setBody(this.teamApiController.create((TeamDto) request.getBody()));
        }else {
            throw new RequestInvalidException(METHOD_ERROR +" " + request.getMethod());
        }
    }

}
