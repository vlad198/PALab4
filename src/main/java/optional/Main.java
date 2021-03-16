package optional;

import optional.problem.Problem;
import optional.problem.RandomInstances;
import optional.school.School;
import optional.student.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        RandomInstances randomInstances = new RandomInstances();

        List<Student> studentList = randomInstances.generateListOfStudents(7);
        List<School> schoolList = randomInstances.generateListOfSchools(3);

        System.out.println("Schools: ");
        for(School school : schoolList)
            System.out.println(school);
        System.out.println();

        for (Student student : studentList)
            randomInstances.addRandomSchoolsToStudent(student, schoolList);

        System.out.println("Students: ");
        for (Student student : studentList)
            System.out.println(student);
        System.out.println();

        Problem problem = new Problem(studentList, schoolList);
        System.out.println(problem.solveProblem());
//        System.out.println(problem);
    }
}
