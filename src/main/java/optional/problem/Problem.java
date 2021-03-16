package optional.problem;

import lombok.AllArgsConstructor;
import lombok.Data;
import optional.school.School;
import optional.solution.Solution;
import optional.solution.SolutionPair;
import optional.student.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public @Data
@AllArgsConstructor
class Problem {
    private List<Student> studentList;
    private List<School> schoolList;

    //
    public Solution solveProblem() {
        List<SolutionPair> solutionPairs = new LinkedList<>();

        List<Student> sortedStudentList = studentList;
        studentList.sort(new SortByGrade());

        Map<School, Integer> schoolCapacityMap = new HashMap<>();
        for (School school : schoolList)
            schoolCapacityMap.put(school, school.getCapacity());

        for (Student student : sortedStudentList) {
            List<School> schoolPreferences = student.getDesiredSchools();

            for (School school : schoolPreferences) {
                Integer currentSchoolCapacity = schoolCapacityMap.get(school);
                if (currentSchoolCapacity > 0) {
                    solutionPairs.add(new SolutionPair(student.getName(), school.getName()));
                    schoolCapacityMap.put(school, currentSchoolCapacity - 1);
                    break;
                }
            }
        }
        return new Solution(solutionPairs);
    }

}
