package compulsory;

import lombok.*;

import java.util.LinkedList;

public @Data
@EqualsAndHashCode
class Student {
    @NonNull
    private String name;
    private LinkedList<School> preferences;
}
