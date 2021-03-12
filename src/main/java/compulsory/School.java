package compulsory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.Comparator;
import java.util.Objects;

public @Data
@EqualsAndHashCode
class School implements Comparable<School> {
    @NonNull
    private String name;
    private int capacity;

    @Override
    public int compareTo(School o) {
        if (this.name == null)
            return 0;
        return this.name.compareTo(o.getName());
    }
}
