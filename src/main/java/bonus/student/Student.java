package bonus.student;

import bonus.school.School;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class describes the student for the problem.
 */
public @Data
@EqualsAndHashCode(exclude = "desiredSchools")
@AllArgsConstructor
class Student implements Comparator<Student> {
    private String name;
    private List<School> desiredSchools;

    public Student(String name){
        this.name = name;
        this.desiredSchools = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Student{" +
                "name='" + name + '\'' +
                ", desiredSchools=[");

        for (School school : desiredSchools)
            result.append(school.getName()).append(", ");
        result.append("]}");
        return result.toString();
    }

    /**
     * copy constructor
     *
     * @param student copyStudent
     */
    public Student(Student student) {
        name = student.getName();
        desiredSchools = new LinkedList<>(student.getDesiredSchools());
    }

    /**
     * random constructor
     */
    public Student() {
        Faker faker = new Faker();
        name = faker.name().fullName();
        desiredSchools = new LinkedList<>();
    }

    /**
     * This method adds a specific school to the instantiated student desiredSchools list.
     *
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
