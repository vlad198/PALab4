package optional.query;

import optional.school.School;
import optional.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class for 'querying' our instances(Student,School)
 */
public class Query {
    /**
     * This method returns a list of students that have a desired school in a list of schools.
     * @param studentList the students list that we want to interrogate.
     * @param schoolList the list of schools that with which we will interrogate the students.
     * @return a new list of students that have a desired school in a list of schools.
     */
    public List<Student> findAcceptableStudents(List<Student> studentList, List<School> schoolList) {
        List<Student> result = new ArrayList<>();

        for (Student student : studentList) {
            List<School> studentSchools = student.getDesiredSchools().stream()
                    .filter(schoolList::contains)
                    .collect(Collectors.toList());
            if (studentSchools.size() > 0)
                result.add(student);
        }
        return result;
    }

    /**
     * Find schools that have a specific student as their top preference
     * @param schoolList the school list we want to interrogate
     * @param student the specific student with which we interrogate te school list
     * @return a new list of schools that have a specific student as their top preference
     */
    public List<School> studentAsTopPreference(List<School> schoolList,Student student){
        List<School> result = new ArrayList<>();

        for(School school : schoolList){
            if(school.getDesiredStudents().get(0).equals(student))
                result.add(school);
        }

        return result;
    }


}
