package bonus.problem;

import bonus.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public @Data
@EqualsAndHashCode
@AllArgsConstructor
class StudentTaken {
    private Student student;
    private int isTaken;
}
