package optional.utilities;

import optional.school.School;
import optional.student.Student;

import java.util.List;

public class Print{
    public static void printStudentList(List<Student> studentList,String msg){
        System.out.println(msg);
        for (Student student : studentList)
            System.out.println(student);
        System.out.println();
    }

    public static void printSchoolList(List<School> schoolList, String msg){
        System.out.println(msg);
        for (School school : schoolList)
            System.out.println(school);
        System.out.println();
    }

}
