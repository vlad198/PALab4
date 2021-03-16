package optional.student;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;
import optional.school.School;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public @Data
@EqualsAndHashCode
class Student implements Comparator<Student> {
    private String name;
    private double grade;
    private List<School> desiredSchools;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", desiredSchools=");

        for (School school : desiredSchools)
            result.append(school.getName()).append(", ");
        result.append("}");
        return result.toString();
    }

    public Student(Student student) {
        name = student.getName();
        grade = student.getGrade();
        desiredSchools = new LinkedList<>(student.getDesiredSchools());
    }

    public Student() {
        Faker faker = new Faker();
        name = faker.name().fullName();
        grade = faker.number().randomDouble(2, 5, 10);
        desiredSchools = new LinkedList<>();
    }

    public void addSchool(School school) {
        desiredSchools.add(school);
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
