package mycode.onlinecatalog.app.global_exceptions;

import mycode.onlinecatalog.app.grades.exceptions.InvalidGrade;
import mycode.onlinecatalog.app.grades.exceptions.NoGradeFound;
import mycode.onlinecatalog.app.users.exceptions.NoUserFound;
import mycode.onlinecatalog.app.users.exceptions.UserAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoUserFound.class})
    public ResponseEntity<Object> handleUserNotFoundException(NoUserFound exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }


    @ExceptionHandler({UserAlreadyExists.class})
    public ResponseEntity<Object> handleUserExistsException(UserAlreadyExists exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler({NoGradeFound.class})
    public ResponseEntity<Object> handleNoGradeFoundException(NoGradeFound exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({InvalidGrade.class})
    public ResponseEntity<Object> handleInvalidGradeException(InvalidGrade exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }


}
