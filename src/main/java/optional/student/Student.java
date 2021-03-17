package optional.student;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import optional.school.School;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class describes the student for the problem.
 */
public @Data
@EqualsAndHashCode(exclude = "desiredSchools") @ToString
class Student implements Comparator<Student> {
    private String name;
    private double grade;
    private List<School> desiredSchools;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", desiredSchools=[");

        for (School school : desiredSchools)
            result.append(school.getName()).append(", ");
        result.append("]}");
        return result.toString();
    }

    /**
     * copy constructor
     * @param student copyStudent
     */
    public Student(Student student) {
        name = student.getName();
        grade = student.getGrade();
        desiredSchools = new LinkedList<>(student.getDesiredSchools());
    }

    /**
     * random constructor
     */
    public Student() {
        Faker faker = new Faker();
        name = faker.name().fullName();
        grade = faker.number().randomDouble(2, 5, 10);
        desiredSchools = new LinkedList<>();
    }

    /**
     * This method adds a specific school to the instantiated student desiredSchools list.
     * @param school
     */
    public void addSchool(School school) {
        desiredSchools.add(school);
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
