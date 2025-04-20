package xyz.ronissolutions.financesapi.exception;

import org.springframework.http.HttpStatus;

public interface ApiException {
    HttpStatus getStatus();
    String getMessage();
}
