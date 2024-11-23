package mycode.onlinecatalog.app.grades.service;

import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.dtos.GradeResponseList;

import java.util.List;

public interface GradeQueryService {


    GradeResponse getGradeById(long gradeId);

    GradeResponseList getAllUserGrades(long userId);
}
