package mycode.onlinecatalog.app.feedback.dtos;

public record CreateFeedbackRequest(String title, String message, long gradeId) {
}
