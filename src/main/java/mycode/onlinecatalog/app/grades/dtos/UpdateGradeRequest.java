package mycode.onlinecatalog.app.grades.dtos;

import mycode.onlinecatalog.app.feedback.dtos.CreateFeedbackRequest;

public record UpdateGradeRequest(int grade, CreateFeedbackRequest feedback) {
}
