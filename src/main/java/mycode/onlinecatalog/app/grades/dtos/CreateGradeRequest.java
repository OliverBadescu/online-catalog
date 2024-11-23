package mycode.onlinecatalog.app.grades.dtos;

import mycode.onlinecatalog.app.feedback.dtos.CreateFeedbackRequest;

import java.time.LocalDateTime;

public record CreateGradeRequest(int grade, CreateFeedbackRequest feedback) {
}
