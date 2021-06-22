package ray.sumit.sbms.breweries.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ray.sumit.sbms.breweries.web.enumeration.ReturnCodeEnum;
import ray.sumit.sbms.breweries.web.exception.model.BreweriesError;
import ray.sumit.sbms.breweries.web.exception.model.ErrorResponse;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        log.error("Validation failed: " + exception);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<String> validationResults = new ArrayList<>(exception.getConstraintViolations().size());
        exception.getConstraintViolations().forEach(violation -> {
            validationResults.add(violation.getPropertyPath() + " : " + violation.getMessage());
        });

        final ErrorResponse response = new ErrorResponse();
        response.getErrorList().add(new BreweriesError(ReturnCodeEnum.INVALID_REQUEST_PARAMS.toString(), exception.getLocalizedMessage(), validationResults));

        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("Method Argument Validation failed: " + exception);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        //return processFieldErrors(fieldErrors);

        List<String> validationResults = new ArrayList<>(fieldErrors.size());
        fieldErrors.forEach(fieldError -> {
            validationResults.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
        });

        final ErrorResponse response = new ErrorResponse();
        response.getErrorList().add(new BreweriesError(ReturnCodeEnum.INVALID_REQUEST_PARAMS.toString(), exception.getLocalizedMessage(), validationResults));

        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleDefault(Exception exception) {
        log.error("Default Exception : ", exception);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final ErrorResponse response = new ErrorResponse();
        response.getErrorList().add(new BreweriesError(ReturnCodeEnum.INVALID_REQUEST_PARAMS.toString(), exception.getMessage()));
        return new ResponseEntity<ErrorResponse>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
