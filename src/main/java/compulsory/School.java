package compulsory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.Comparator;
import java.util.Objects;

public @Data
@EqualsAndHashCode
class School {
    @NonNull
    private String name;
    private int capacity;

}
