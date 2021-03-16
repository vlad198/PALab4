package optional.problem;

import optional.school.School;
import optional.student.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomInstances {

    public School generateRandomSchool() {
        return new School();
    }

    public Student generateRandomStudent() {
        return new Student();
    }

    public List<Integer> generateRandomListOfIndexes(int indexMax, int numberOfIndexes) {
        List<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < indexMax; i++)
            indexList.add(i);
        Collections.shuffle(indexList);

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < numberOfIndexes; i++)
            result.add(indexList.get(i));
        return result;
    }

    public void addRandomSchoolsToStudent(Student student, List<School> schoolList) {
        int numberOfSchools = (int) (Math.random() * schoolList.size()) + 1;
        List<Integer> indexesList = generateRandomListOfIndexes(schoolList.size(), numberOfSchools);

        for (int i = 0; i < numberOfSchools; i++)
            student.addSchool(schoolList.get(indexesList.get(i)));
    }

    public List<Student> generateListOfStudents(int capacity) {
        List<Student> list = new LinkedList<>();
        for (int i = 0; i < capacity; i++)
            list.add(new Student());
        return list;
    }

    public List<School> generateListOfSchools(int capacity) {
        List<School> list = new LinkedList<>();
        for (int i = 0; i < capacity; i++)
            list.add(new School());
        return list;
    }
}
