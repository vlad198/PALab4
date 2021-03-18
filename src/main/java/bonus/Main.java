package bonus;

import bonus.problem.Problem;
import bonus.problem.RandomInstances;
import bonus.query.Query;
import bonus.school.School;
import bonus.solution.Solution;
import bonus.student.Student;
import bonus.utilities.Print;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Student(String.valueOf((char)('A' + i))))
                .toArray(Student[]::new);

        var schools = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new School(String.valueOf((char)('L' + i))))
                .toArray(School[]::new);

        // set capacity
        schools[0].setCapacity(1);
        schools[1].setCapacity(1);
        schools[2].setCapacity(1);
        schools[3].setCapacity(1);
        schools[4].setCapacity(1);

        // set school list
        students[0].addSchool(schools[3]);
        students[0].addSchool(schools[1]);
        students[0].addSchool(schools[2]);
        students[0].addSchool(schools[0]);
        students[0].addSchool(schools[4]);

        students[1].addSchool(schools[4]);
        students[1].addSchool(schools[2]);
        students[1].addSchool(schools[1]);
        students[1].addSchool(schools[0]);
        students[1].addSchool(schools[3]);

        students[2].addSchool(schools[1]);
        students[2].addSchool(schools[4]);
        students[2].addSchool(schools[0]);
        students[2].addSchool(schools[3]);
        students[2].addSchool(schools[2]);

        students[3].addSchool(schools[4]);
        students[3].addSchool(schools[1]);
        students[3].addSchool(schools[3]);
        students[3].addSchool(schools[2]);
        students[3].addSchool(schools[0]);

        students[4].addSchool(schools[3]);
        students[4].addSchool(schools[0]);
        students[4].addSchool(schools[1]);
        students[4].addSchool(schools[2]);
        students[4].addSchool(schools[4]);

        // set student list
        schools[0].addStudent(students[3]);
        schools[0].addStudent(students[1]);
        schools[0].addStudent(students[4]);
        schools[0].addStudent(students[2]);
        schools[0].addStudent(students[0]);

        schools[1].addStudent(students[1]);
        schools[1].addStudent(students[0]);
        schools[1].addStudent(students[3]);
        schools[1].addStudent(students[2]);
        schools[1].addStudent(students[4]);

        schools[2].addStudent(students[0]);
        schools[2].addStudent(students[2]);
        schools[2].addStudent(students[4]);
        schools[2].addStudent(students[3]);
        schools[2].addStudent(students[1]);

        schools[3].addStudent(students[3]);
        schools[3].addStudent(students[0]);
        schools[3].addStudent(students[2]);
        schools[3].addStudent(students[1]);
        schools[3].addStudent(students[4]);

        schools[4].addStudent(students[1]);
        schools[4].addStudent(students[4]);
        schools[4].addStudent(students[0]);
        schools[4].addStudent(students[2]);
        schools[4].addStudent(students[3]);

        Problem problem = new Problem(new LinkedList<>(Arrays.asList(students)), Arrays.asList(schools));
        Solution solution = problem.solveProblem();
        System.out.println(solution);
    }
}


