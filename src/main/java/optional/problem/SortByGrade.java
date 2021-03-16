package optional.problem;

import optional.student.Student;

import java.util.Comparator;

public class SortByGrade implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getGrade(),o1.getGrade());
    }
}
