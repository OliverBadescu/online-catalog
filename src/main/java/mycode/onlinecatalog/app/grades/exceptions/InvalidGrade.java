package mycode.onlinecatalog.app.grades.exceptions;

public class InvalidGrade extends RuntimeException {
    public InvalidGrade(String message) {
        super(message);
    }
}
