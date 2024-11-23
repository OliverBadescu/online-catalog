package mycode.onlinecatalog.app.grades.dtos;

import mycode.onlinecatalog.app.feedback.dtos.FeedbackResponse;

import java.time.LocalDateTime;

public record GradeResponse(long id, long userId, int grade, FeedbackResponse feedback, LocalDateTime createDate) {
}
