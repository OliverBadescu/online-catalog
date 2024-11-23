package mycode.onlinecatalog.app.grades.repository;

import mycode.onlinecatalog.app.grades.model.Grade;
import mycode.onlinecatalog.app.users.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Optional<Grade> findById(long id);

    Optional<List<Grade>> findByUserId(long id);
}
