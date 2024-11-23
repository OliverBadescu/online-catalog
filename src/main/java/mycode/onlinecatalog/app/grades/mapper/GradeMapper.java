package mycode.onlinecatalog.app.grades.mapper;

import mycode.onlinecatalog.app.feedback.mapper.FeedbackMapper;
import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.model.Grade;

public class GradeMapper {

    public static GradeResponse gradeToResponseDto(Grade grade){

        return new GradeResponse(
                grade.getId(),
                grade.getUser().getId(),
                grade.getGrade(),
                FeedbackMapper.feedbackToResponseDto(grade.getFeedback()),
                grade.getCreateDate()
        );
    }

}
