package xyz.ronissolutions.financesapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class APIResponseDTO<T> {

    private APIResponseStatus status;
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private T data;

    private APIResponseDTO(APIResponseStatus status, String message, HttpStatus httpStatus, T data) {
        this.status = status;
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public static <T> APIResponseDTO<T> success(HttpStatus httpStatus,  String message,  T data) {
        return new APIResponseDTO<>(APIResponseStatus.SUCCESS, message, httpStatus, data);
    }

    public static <T> APIResponseDTO<T> error(HttpStatus httpStatus,  String message) {
        return new APIResponseDTO<>(APIResponseStatus.ERROR, message, httpStatus, null);
    }

}
