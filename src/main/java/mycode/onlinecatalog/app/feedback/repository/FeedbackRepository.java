package mycode.onlinecatalog.app.feedback.repository;

import mycode.onlinecatalog.app.feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
