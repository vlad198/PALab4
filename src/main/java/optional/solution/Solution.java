package optional.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public @Getter
@AllArgsConstructor
class Solution {
    private final List<SolutionPair> solutionPairs;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Solution: \n");
        for (SolutionPair solutionPair : solutionPairs)
            result.append(solutionPair).append("\n");
        return result.toString();
    }
}
