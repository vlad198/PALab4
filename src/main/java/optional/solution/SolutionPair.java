package optional.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public @Getter
@AllArgsConstructor
@ToString
class SolutionPair {
    private final String studentName;
    private final String schoolName;
}
