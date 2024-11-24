package mycode.onlinecatalog.app.feedback.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import mycode.onlinecatalog.app.grades.model.Grade;
import mycode.onlinecatalog.app.users.model.User;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Table(name = "feedback")
@Entity(name = "Feedback")
public class Feedback {

    @Id
    @SequenceGenerator(
            name = "feedback_sequence",
            sequenceName = "feedback_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "feedback_sequence"
    )

    @Column(
            name = "id"
    )
    private long id;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name = "message",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String message;


    @OneToOne()
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback gradeObj = (Feedback) o;
        return id == gradeObj.id && Objects.equals(title, gradeObj.title) && Objects.equals(grade, gradeObj.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title,grade);
    }
}
