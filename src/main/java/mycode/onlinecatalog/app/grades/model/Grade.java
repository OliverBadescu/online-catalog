package mycode.onlinecatalog.app.grades.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import mycode.onlinecatalog.app.feedback.model.Feedback;
import mycode.onlinecatalog.app.users.model.User;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Table(name = "grade")
@Entity(name = "Grade")
public class Grade {

    @Id
    @SequenceGenerator(
            name = "grade_sequence",
            sequenceName = "grade_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "grade_sequence"
    )

    @Column(
            name = "id"
    )
    private long id;

    @Column(
            name = "grade",
            nullable = false,
            columnDefinition = "INT"
    )
    private int grade;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "grade")
    private Feedback feedback;


}
