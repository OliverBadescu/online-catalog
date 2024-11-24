package mycode.onlinecatalog.app.grades.web;


import lombok.AllArgsConstructor;
import mycode.onlinecatalog.app.grades.dtos.CreateGradeRequest;
import mycode.onlinecatalog.app.grades.dtos.GradeResponse;
import mycode.onlinecatalog.app.grades.dtos.GradeResponseList;
import mycode.onlinecatalog.app.grades.dtos.UpdateGradeRequest;
import mycode.onlinecatalog.app.grades.service.GradeCommandService;
import mycode.onlinecatalog.app.grades.service.GradeQueryService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/grade")
public class GradeController {

    private GradeCommandService gradeCommandService;
    private GradeQueryService gradeQueryService;

    @GetMapping("/getAllUserGrades/{userId}")
    public ResponseEntity<GradeResponseList> getAllUserGrades(@PathVariable int userId){
        return new ResponseEntity<>(gradeQueryService.getAllUserGrades(userId), HttpStatus.OK);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<GradeResponse> addGrade(@RequestBody CreateGradeRequest createGradeRequest, @PathVariable long userId){
        return new ResponseEntity<>(gradeCommandService.addGrade(createGradeRequest, userId),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{gradeId}")
    public ResponseEntity<GradeResponse> deleteGrade(@PathVariable long gradeId){
        return new ResponseEntity<>(gradeCommandService.deleteGrade(gradeId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{gradeId}")
    public ResponseEntity<GradeResponse> updateGrade(@PathVariable long gradeId, @RequestBody UpdateGradeRequest updateGradeRequest){
        return new ResponseEntity<>(gradeCommandService.updateGrade(gradeId, updateGradeRequest), HttpStatus.ACCEPTED);
    }

}
