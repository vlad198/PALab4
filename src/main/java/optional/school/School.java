package optional.school;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Comparator;

public @Data
@EqualsAndHashCode
@ToString
class School implements Comparator<School> {
    private String name;
    private int capacity;

    public School() {
        Faker faker = new Faker();
        name = faker.hobbit().character() + " Highschool";
        capacity = faker.number().numberBetween(1, 4);
    }

    public School(School school){
        name = school.getName();
        capacity = school.getCapacity();
    }

    @Override
    public int compare(School o1, School o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
