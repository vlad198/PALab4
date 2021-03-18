package bonus.problem;

import bonus.school.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

public @Data
@AllArgsConstructor
@EqualsAndHashCode
class SchoolTaken {
    private School school;
    private int isTaken;
}
