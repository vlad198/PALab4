package optional;

import optional.problem.Problem;
import optional.problem.RandomInstances;
import optional.query.Query;
import optional.school.School;
import optional.student.Student;
import optional.utilities.Print;

import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        RandomInstances randomInstances = new RandomInstances();
        Query query = new Query();

        List<Student> studentList = randomInstances.generateListOfStudents(7);
        List<School> schoolList = randomInstances.generateListOfSchools(3);

        for (Student student : studentList)
            randomInstances.addRandomSchoolsToStudent(student, schoolList);

        Print.printSchoolList(schoolList, "Schools: ");
        Print.printStudentList(studentList, "Students: ");

        // find students that prefers some schools
        List<School> querySchoolList = new LinkedList<>(Arrays.asList(schoolList.get(0)));
        List<Student> filterStudentList = query.findAcceptableStudents(studentList, querySchoolList);
        Print.printStudentList(filterStudentList, "Filtered students list: ");

        // find schools that prefers some students
        List<Student> queryStudentList = new LinkedList<>(Arrays.asList(studentList.get(0)));
        List<School> filterSchoolList = query.findAcceptableSchools(schoolList, queryStudentList);
        Print.printSchoolList(filterSchoolList, "Filter school list: ");

//        Problem problem = new Problem(studentList, schoolList);
//        System.out.println(problem.solveProblem());
//        System.out.println(problem);
    }
}
