package mycode.onlinecatalog.app.grades.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import mycode.onlinecatalog.app.feedback.model.Feedback;
import mycode.onlinecatalog.app.users.model.User;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(
            name = "create-date",
            nullable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime createDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "grade", cascade = CascadeType.ALL, orphanRemoval = true)
    private Feedback feedback;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade gradeObj = (Grade) o;
        return id == gradeObj.id && Objects.equals(createDate, gradeObj.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate);
    }


}
