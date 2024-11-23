package mycode.onlinecatalog.app.grades.service;

import mycode.onlinecatalog.app.grades.dtos.CreateGradeRequest;
import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.dtos.UpdateGradeRequest;

public interface GradeCommandService {

    GradeResponse addGrade(CreateGradeRequest createGradeRequest, long userId);

    GradeResponse deleteGrade(long gradeId);

    GradeResponse updateGrade(long gradeId, UpdateGradeRequest updateGradeRequest);

}
