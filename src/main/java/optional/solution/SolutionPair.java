package optional.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * This class describes the solution pair type
 * for the solution class
 */
public @Getter
@AllArgsConstructor
@ToString
class SolutionPair {
    private final String studentName;
    private final String schoolName;
}
