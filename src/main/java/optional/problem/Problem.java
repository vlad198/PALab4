package optional.problem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import optional.school.School;
import optional.solution.Solution;
import optional.solution.SolutionPair;
import optional.student.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class will describe the problem.
 * For a list of students that have a score
 * it will assign them to the "most desired" school
 * that is available.(Schools rank students based on
 * their grade)
 */
public @Data
@AllArgsConstructor
class Problem {
    private List<Student> studentList;
    private List<School> schoolList;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Problem :\nStudent List :\n");

        for (Student student : studentList) {
            result.append(student.getName()).append(" | pref schools: ");
            for (School school : student.getDesiredSchools())
                result.append(school.getName()).append(", ");
            result.append("\n");
        }

        for (School school : schoolList) {
            result.append(school.getName()).append(" | pref students: ");
            for (Student student : school.getDesiredStudents())
                result.append(student.getName()).append(", ");
            result.append("\n");
        }

        return result.toString();
    }

    /**
     * this function will solve the instantiated problem.
     * It will sort the students based on their grade and after that
     * it will try to find them the best school in their favorite list
     * which is not fully filled.
     *
     * @return it will return a list of pairs (x,y)
     * meaning student x is assigned to school y.
     */
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
