package optional.query;

import optional.school.School;
import optional.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Query {
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

    public List<School> findAcceptableSchools(List<School> schoolList, List<Student> studentList) {
        List<School> result = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> schoolsStudents = studentList.stream()
                    .filter(student -> student.getDesiredSchools().contains(school))
                    .collect(Collectors.toList());
            if (schoolsStudents.size() > 0)
                result.add(school);
        }

        return result;
    }


}
