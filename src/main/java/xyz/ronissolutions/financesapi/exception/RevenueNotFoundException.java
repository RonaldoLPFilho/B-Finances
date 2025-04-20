package xyz.ronissolutions.financesapi.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class RevenueNotFoundException extends RuntimeException implements ApiException{

    private final String message;

    public RevenueNotFoundException(Long id) {
        this.message = String.format("Revenue with id %s not found", id);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
