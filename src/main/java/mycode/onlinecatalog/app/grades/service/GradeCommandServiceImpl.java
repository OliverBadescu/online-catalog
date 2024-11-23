package mycode.onlinecatalog.app.grades.service;


import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.feedback.mapper.FeedbackMapper;
import mycode.onlinecatalog.app.feedback.model.Feedback;
import mycode.onlinecatalog.app.feedback.repository.FeedbackRepository;
import mycode.onlinecatalog.app.grades.dtos.CreateGradeRequest;
import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.dtos.UpdateGradeRequest;
import mycode.onlinecatalog.app.grades.exceptions.InvalidGrade;
import mycode.onlinecatalog.app.grades.mapper.GradeMapper;
import mycode.onlinecatalog.app.grades.model.Grade;
import mycode.onlinecatalog.app.grades.repository.GradeRepository;
import mycode.onlinecatalog.app.users.dtos.UserResponse;
import mycode.onlinecatalog.app.users.exceptions.NoUserFound;
import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class GradeCommandServiceImpl implements GradeCommandService{

    private GradeRepository gradeRepository;
    private UserRepository userRepository;
    private FeedbackRepository feedbackRepository;

    @Override
    public GradeResponse addGrade(CreateGradeRequest createGradeRequest, long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoUserFound("No user with this id found"));

        Feedback feedback = FeedbackMapper.feedbackCreateDtoToEntity(createGradeRequest.feedback());

        feedbackRepository.saveAndFlush(feedback);

        if(createGradeRequest.grade() < 1 || createGradeRequest.grade() > 10 ){
            throw new InvalidGrade("Grade must be between 1 and 10");
        }

        Grade grade = Grade.builder()
                .grade(createGradeRequest.grade())
                .createDate(LocalDateTime.now())
                .feedback(feedback)
                .user(user)
                .build();



        gradeRepository.saveAndFlush(grade);

        feedback.setGrade(grade);
        feedbackRepository.saveAndFlush(feedback);

        return GradeMapper.gradeToResponseDto(grade);
    }

    @Override
    public GradeResponse deleteGrade(long gradeId) {
        return null;
    }

    @Override
    public GradeResponse updateGrade(long gradeId, UpdateGradeRequest updateGradeRequest) {
        return null;
    }
}
