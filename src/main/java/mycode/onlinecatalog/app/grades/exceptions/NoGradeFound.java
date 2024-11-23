package mycode.onlinecatalog.app.grades.exceptions;

public class NoGradeFound extends RuntimeException {
    public NoGradeFound(String message) {
        super(message);
    }
}
