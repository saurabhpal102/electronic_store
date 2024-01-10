package electronicStore.exceptions;

import electronicStore.helper.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        ApiResponseMessage responseMessage = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
    }
}
