package bonus;

import bonus.problem.Problem;
import bonus.problem.RandomInstances;
import bonus.query.Query;
import bonus.school.School;
import bonus.solution.Solution;
import bonus.student.Student;
import bonus.utilities.Print;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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


