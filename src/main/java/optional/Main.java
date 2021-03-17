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

        for (School school : schoolList)
            randomInstances.addRandomStudentsToSchool(school, studentList);

        Print.printSchoolList(schoolList, "Schools: ");
        Print.printStudentList(studentList, "Students: ");

        // find students that prefers some schools
        List<School> querySchoolList = new LinkedList<>(Arrays.asList(schoolList.get(0)));
        List<Student> filterStudentList = query.findAcceptableStudents(studentList, querySchoolList);
        Print.printStudentList(filterStudentList, "Students that prefer " + schoolList.get(0).getName());

        // schools that have a student as their top preference
        List<School> filterSchooList = query.studentAsTopPreference(schoolList, studentList.get(0));
        Print.printSchoolList(filterSchooList, "Schools that have " + studentList.get(0).getName() + " as their top preference");

        Problem problem = new Problem(studentList, schoolList);
        System.out.println(problem.solveProblem());
        System.out.println(problem);
    }
}
