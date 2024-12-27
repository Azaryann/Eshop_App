package am.azaryan.exception;

import java.util.*;

import am.azaryan.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response<ErrorResponse, ?>> handleAllExceptions(Exception ex) {
        List<String> errorList = new LinkedList<>();
        errorList.add(ex.getLocalizedMessage());
        errorList.add(ex.getCause().getMessage());
        ErrorResponse error = new ErrorResponse("500", "ServerException", "Something wrong with server", errorList);
        Response<ErrorResponse, ?> response = new Response<>(error, null, ex.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Response<ErrorResponse, ?>> handleIdNotFoundException(ResourceNotFoundException ex) {
        List<String> errorList = new LinkedList<>();
        errorList.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("404", "NOT_FOUND", "Id not found", errorList);
        Response<ErrorResponse, ?> response = new Response<>(error, null, ex.getClass().getSimpleName());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
