package optional.school;

import com.github.javafaker.Faker;
import lombok.*;
import optional.student.Student;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class describes the schools in the problem
 */
public @Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(exclude = "desiredStudents")
class School implements Comparator<School>, Comparable<School> {
    private String name;
    private int capacity;
    private List<Student> desiredStudents;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", desiredStudents=["
        );

        for (Student student : desiredStudents)
            result.append(student.getName()).append(" ,");
        result.append("]}");

        return result.toString();
    }

    /**
     * this constructor generates a random school.
     */
    public School() {
        Faker faker = new Faker();
        name = faker.hobbit().character() + " Highschool";
        capacity = faker.number().numberBetween(1, 4);
        desiredStudents = new LinkedList<>();
    }

    public School(School school) {
        name = school.getName();
        capacity = school.getCapacity();
        desiredStudents = new LinkedList<>(school.getDesiredStudents());
    }

    public void addStudent(Student student) {
        desiredStudents.add(student);
    }

    @Override
    public int compare(School o1, School o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public int compareTo(School o) {
        return name.compareTo(o.getName());
    }
}
