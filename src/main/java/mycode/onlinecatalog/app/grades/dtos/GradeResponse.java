package mycode.onlinecatalog.app.grades.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import mycode.onlinecatalog.app.feedback.dtos.FeedbackResponse;

import java.time.LocalDateTime;

public record GradeResponse(long id, long userId, int grade, FeedbackResponse feedback,@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm") LocalDateTime createDate) {
}
