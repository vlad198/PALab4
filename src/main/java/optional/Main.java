package optional;

import optional.problem.Problem;
import optional.problem.RandomInstances;
import optional.query.Query;
import optional.school.School;
import optional.solution.Solution;
import optional.student.Student;
import optional.utilities.Print;

import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        RandomInstances randomInstances = new RandomInstances();
        Query query = new Query();

        List<Student> studentList = randomInstances.generateListOfStudents(7);
        List<School> schoolList = randomInstances.generateListOfSchools(1);

        for (Student student : studentList)
            randomInstances.addRandomSchoolsToStudent(student, schoolList);

        for (School school : schoolList)
            randomInstances.addRandomStudentsToSchool(school, studentList);

        Print.printSchoolList(schoolList, "Schools: ");
        Print.printStudentList(studentList, "Students: ");


        Problem problem = new Problem(studentList,schoolList);
        Solution solution = problem.solveProblem();
        System.out.println(solution);
    }
}


