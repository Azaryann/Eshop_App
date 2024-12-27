package am.azaryan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String errorCode;
    private String errorStatus;
    private String errorMessage;
    private List<String> errorList;
    private LocalDateTime localDateTime;

    public ErrorResponse(String errorCode, String errorStatus, String errorMessage, List<String> errorList) {
        this.errorCode = errorCode;
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
        this.errorList = errorList;
        this.localDateTime = LocalDateTime.now();
    }

}
