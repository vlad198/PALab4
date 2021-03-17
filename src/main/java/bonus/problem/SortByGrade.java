package bonus.problem;

import bonus.student.Student;

import java.util.Comparator;

/**
 * This class is used to compare to students by their grade
 * for the sort method in problem class.
 */
public class SortByGrade implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getGrade(),o1.getGrade());
    }
}
