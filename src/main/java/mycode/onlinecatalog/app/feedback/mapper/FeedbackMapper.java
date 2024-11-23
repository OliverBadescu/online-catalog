package mycode.onlinecatalog.app.feedback.mapper;

import mycode.onlinecatalog.app.feedback.dtos.CreateFeedbackRequest;
import mycode.onlinecatalog.app.feedback.dtos.FeedbackResponse;
import mycode.onlinecatalog.app.feedback.model.Feedback;
import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.model.Grade;

public class FeedbackMapper {


    public static FeedbackResponse feedbackToResponseDto(Feedback feedback){

        return new FeedbackResponse(
                feedback.getId(),
                feedback.getTitle(),
                feedback.getMessage(),
                feedback.getGrade().getId()
                );
    }

    public static Feedback feedbackCreateDtoToEntity(CreateFeedbackRequest createFeedbackRequest){
        return Feedback.builder()
                .message(createFeedbackRequest.message())
                .title(createFeedbackRequest.title()).build();

    }
}
