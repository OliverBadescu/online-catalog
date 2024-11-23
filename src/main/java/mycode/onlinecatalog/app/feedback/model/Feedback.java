package mycode.onlinecatalog.app.feedback.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import mycode.onlinecatalog.app.grades.model.Grade;
import mycode.onlinecatalog.app.users.model.User;

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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

}
