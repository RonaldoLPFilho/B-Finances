package xyz.ronissolutions.financesapi.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import xyz.ronissolutions.financesapi.dto.APIResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponseDTO<Void>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(APIResponseDTO.error(ex.getStatus(), ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIResponseDTO<Void>> handleRuntime(RuntimeException ex) {
        if (ex instanceof ApiException apiEx) {
            return ResponseEntity
                    .status(apiEx.getStatus())
                    .body(APIResponseDTO.error(apiEx.getStatus(), apiEx.getMessage()));
        }

        // fallback genérico
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(APIResponseDTO.error(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor"));
    }

}
