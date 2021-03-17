package bonus.utilities;

import bonus.school.School;
import bonus.student.Student;

import java.util.List;

/**
 * Class for printing the student/class lists
 */
public class Print{
    public static void printStudentList(List<Student> studentList, String msg){
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
