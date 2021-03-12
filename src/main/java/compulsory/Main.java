package compulsory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("vlad");

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        LinkedList<Student> studentsArray = new LinkedList<Student>(Arrays.asList(students[0], students[1], students[2], students[3]));
        studentsArray.sort(new SortByNumberOfApplications());

        TreeSet<School> schoolSet = new TreeSet<School>(new SchoolSetComparator());
        schoolSet.add(schools[0]);
        schoolSet.add(schools[1]);
        schoolSet.add(schools[2]);

        for(School school : schoolSet)
            System.out.println(school);


        for (Student student : studentsArray)
            System.out.println(student);
    }
}
