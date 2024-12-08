package unifacef.edu.api_financeiro.exceptions.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import unifacef.edu.api_financeiro.exceptions.EntityAlreadyExistsException;
import unifacef.edu.api_financeiro.exceptions.InvalidJwtTokenException;
import unifacef.edu.api_financeiro.exceptions.WrongCredentialsException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiException {

    @ExceptionHandler({EntityAlreadyExistsException.class})
    public ResponseEntity<Map<String, String>> entityAlreadyExistsException(EntityAlreadyExistsException e) {
        return new ResponseEntity<>(responseBuilder(e), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Map<String, String>> entityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(responseBuilder(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WrongCredentialsException.class})
    public ResponseEntity<Map<String, String>> wrongCredentialsException(WrongCredentialsException e) {
        return new ResponseEntity<>(responseBuilder(e), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({InvalidJwtTokenException.class})
    public ResponseEntity<Map<String, String>> invalidJwtTokenException(InvalidJwtTokenException e) {
        return new ResponseEntity<>(responseBuilder(e), HttpStatus.UNAUTHORIZED);
    }

    private Map<String, String> responseBuilder(RuntimeException e) {
        Map<String, String> response = new HashMap<>();
        response.put("message", e.getMessage());

        return response;
    }
}
