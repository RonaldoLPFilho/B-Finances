package xyz.ronissolutions.financesapi.exception;

import org.springframework.http.HttpStatus;


public class ResourceNotFoundException extends RuntimeException implements ApiException {
    private final String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
