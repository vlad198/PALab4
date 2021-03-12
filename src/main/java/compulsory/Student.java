package compulsory;

import lombok.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public @Data
@EqualsAndHashCode
class Student implements Comparator<Student> {
    @NonNull
    private String name;

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
