package mycode.onlinecatalog.app.grades.service;


import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.dtos.GradeResponseList;
import mycode.onlinecatalog.app.grades.exceptions.NoGradeFound;
import mycode.onlinecatalog.app.grades.mapper.GradeMapper;
import mycode.onlinecatalog.app.grades.model.Grade;
import mycode.onlinecatalog.app.grades.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class GradeQueryServiceImpl implements GradeQueryService{

    private GradeRepository gradeRepository;
    @Override
    public GradeResponse getGradeById(long gradeId) {
        return null;
    }

    @Override
    public GradeResponseList getAllUserGrades(long userId) {
        List<Grade> list = gradeRepository.findByUserId(userId)
                .orElseThrow(() -> new NoGradeFound("This user has no registered grades"));


        List<GradeResponse> rez= new ArrayList<>();

        list.forEach(grade -> {
            rez.add(GradeMapper.gradeToResponseDto(grade));
        });

        if(rez.isEmpty()){
            throw new NoGradeFound("This user has no registered grades");
        }


        return new GradeResponseList(rez);
    }
}
