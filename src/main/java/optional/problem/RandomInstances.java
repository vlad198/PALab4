package optional.problem;

import optional.school.School;
import optional.student.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomInstances {

    /**
     * this function generates a random school
     * @return the random school
     */
    public School generateRandomSchool() {
        return new School();
    }

    /**
     * this function generates a random student
     * @return the random student
     */
    public Student generateRandomStudent() {
        return new Student();
    }

    /**
     * This function generates a random list of indexes between [0,maximumIndex].
     * @param indexMax maximum index in the list
     * @param numberOfIndexes how many indexes we have to generate
     * @return a list of random indexes.
     */
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

    /**
     * This function adds a random list of schools to the student 'desiredSchools' list
     * @param student the student we want to add te random schools
     * @param schoolList the available schools list
     */
    public void addRandomSchoolsToStudent(Student student, List<School> schoolList) {
        int numberOfSchools = (int) (Math.random() * schoolList.size()) + 1;
        List<Integer> indexesList = generateRandomListOfIndexes(schoolList.size(), numberOfSchools);

        Collections.shuffle(indexesList);

        for (int i = 0; i < numberOfSchools; i++)
            student.addSchool(schoolList.get(indexesList.get(i)));
    }

    public void addRandomStudentsToSchool(School school, List<Student> studentList) {
        int numberOfStudents = (int) (Math.random() * studentList.size()) + 1;
        List<Integer> indexesList = generateRandomListOfIndexes(studentList.size(), numberOfStudents);

        Collections.shuffle(indexesList);

        for (int i = 0; i < numberOfStudents; i++)
            school.addStudent(studentList.get(indexesList.get(i)));
    }

    /**
     * this function generates a random list of students
     * @param capacity how many students de we want to generate
     * @return a list of new students.
     */
    public List<Student> generateListOfStudents(int capacity) {
        List<Student> list = new LinkedList<>();
        for (int i = 0; i < capacity; i++)
            list.add(new Student());
        return list;
    }

    /**
     * this function generates a random list of schools
     * @param capacity how many schools de we want to generate
     * @return a list of new schools.
     */
    public List<School> generateListOfSchools(int capacity) {
        List<School> list = new LinkedList<>();
        for (int i = 0; i < capacity; i++)
            list.add(new School());
        return list;
    }
}
