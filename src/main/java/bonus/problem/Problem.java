package bonus.problem;

import bonus.school.School;
import bonus.solution.Solution;
import bonus.solution.SolutionPair;
import bonus.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class will describe the problem.
 * For a list of students that have a score
 * it will assign them to the "most desired" school
 * that is available.(Schools rank students based on
 * their grade)
 */
public @Data
@AllArgsConstructor
class Problem {
    private List<Student> studentList;
    private List<School> schoolList;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Problem :\nStudent List :\n");

        for (Student student : studentList) {
            result.append(student.getName()).append(" | pref schools: ");
            for (School school : student.getDesiredSchools())
                result.append(school.getName()).append(", ");
            result.append("\n");
        }

        for (School school : schoolList) {
            result.append(school.getName()).append(" | pref students: ");
            for (Student student : school.getDesiredStudents())
                result.append(student.getName()).append(", ");
            result.append("\n");
        }

        return result.toString();
    }

    private boolean prefersOver(School school, Student student1, Student student2) {
        for (Student student : school.getDesiredStudents()) {
            if (student.equals(student2))
                return true;
            if (student.equals(student1))
                return false;
        }
        return false;
    }

    private boolean isStudentAssigned(List<SchoolTaken> schoolTakenList) {
        for (SchoolTaken schoolTaken : schoolTakenList)
            if (schoolTaken.getIsTaken() == 1) {
                return true;
            }
        return false;
    }

    private Student firstStudentUnassigned(Map<Student, List<SchoolTaken>> freeStudents) {
        for (Map.Entry<Student, List<SchoolTaken>> entry : freeStudents.entrySet())
            if (!isStudentAssigned(entry.getValue()))
                return entry.getKey();
        return new Student();
    }

    private boolean areAllStudentsAssigned(Map<Student, List<SchoolTaken>> freeStudents) {
        for (Map.Entry<Student, List<SchoolTaken>> entry : freeStudents.entrySet())
            if (!isStudentAssigned(entry.getValue()))
                return false;
        return true;
    }

    private int getLastIndexAssignedStudent(List<StudentTaken> currentSchoolList) {
        for (int i = currentSchoolList.size() - 1; i >= 0; i--)
            if (currentSchoolList.get(i).getIsTaken() == 1)
                return i;
        return -1;
    }

    private void undoSchoolForStudent(Student currentStudent, School currentSchool, Map<Student, List<SchoolTaken>> freeStudents) {
        List<SchoolTaken> schoolTakenList = freeStudents.get(currentStudent);
        for (SchoolTaken school : schoolTakenList)
            if (school.getSchool().equals(currentSchool)) {
                school.setIsTaken(-1);
                return;
            }
    }

    public School getSchoolMatched(List<SchoolTaken> schoolTakenList) {
        for (SchoolTaken school : schoolTakenList)
            if (school.getIsTaken() == 1)
                return school.getSchool();
        return new School();
    }

    private void updateStudentSchool(Student student, Map<Student, List<SchoolTaken>> freeStudents, Map<School, List<StudentTaken>> freeSchools, Map<School, Integer> seatsAvailable) {
        List<SchoolTaken> studentDesiredSchoolsList = freeStudents.get(student);
        for (SchoolTaken schoolTaken : studentDesiredSchoolsList) {
            if (schoolTaken.getIsTaken() == 0) {
                School currentSchool = schoolTaken.getSchool();
                List<StudentTaken> currentSchoolList = freeSchools.get(currentSchool);

                if (currentSchoolList != null) {
                    for (int i = 0; i < currentSchoolList.size(); i++) {
                        StudentTaken studentInSchoolList = currentSchoolList.get(i);
                        if (studentInSchoolList.getStudent().equals(student)) {
                            int seats = seatsAvailable.get(currentSchool);
                            if (seats > 0) {
                                // atunci mai am loc
                                // marchez in lista studentului
                                schoolTaken.setIsTaken(1);
                                // marchez in lista scolii
                                studentInSchoolList.setIsTaken(1);
                                // updatez locurile ramase
                                seatsAvailable.put(currentSchool, seats - 1);
                            } else {
                                // nu mai am loc
                                // vad daca studentul curent e inaintea unuia care e deja pus
                                // indexul ultimului stundet asignat scolii
                                int lastIndexStudent = getLastIndexAssignedStudent(currentSchoolList);
                                if (lastIndexStudent < i) // daca e dupa ultimul student bagat
                                {
                                    schoolTaken.setIsTaken(-1);
                                    return;
                                }
                                // altfel
                                // tai studentul precedent
                                undoSchoolForStudent(currentSchoolList.get(lastIndexStudent).getStudent(), currentSchool, freeStudents);
                                // pun asta nou
                                schoolTaken.setIsTaken(1); // in lista studentului
                                studentInSchoolList.setIsTaken(1); // in lista scolii
                            }
                            return;
                        }
                    }
                }

            }
        }
    }

    /**
     * this function will solve the instantiated problem.
     *
     * @return it will return a list of pairs (x,y)
     * meaning student x is assigned to school y.
     */
    public Solution solveProblem() {
        List<SolutionPair> solutionPairs = new LinkedList<>();

        // map to contorize the remaining seats available
        Map<School, Integer> seatsAvailable = new HashMap<>();
        for (School school : schoolList)
            seatsAvailable.put(school, school.getCapacity());

        // creating a list of booleans for taken schools for every student
        Map<Student, List<SchoolTaken>> freeStudents = new HashMap<>();
        for (Student student : studentList) {
            List<SchoolTaken> studentPref = new LinkedList<>();
            for (School school : student.getDesiredSchools())
                studentPref.add(new SchoolTaken(school, 0));
            freeStudents.put(student, studentPref);
        }

        // creating a list of booleans for taken students for every school
        Map<School, List<StudentTaken>> freeSchools = new HashMap<>();
        for (School school : schoolList) {
            List<StudentTaken> schoolPref = new LinkedList<>();
            for (Student student : school.getDesiredStudents())
                schoolPref.add(new StudentTaken(student, 0));
            freeSchools.put(school, schoolPref);
        }

        while (!areAllStudentsAssigned(freeStudents)) {
            Student currentFreeStudent = firstStudentUnassigned(freeStudents);
            updateStudentSchool(currentFreeStudent, freeStudents, freeSchools, seatsAvailable);
        }

        for (Student student : freeStudents.keySet()) {
            List<SchoolTaken> takenList = freeStudents.get(student);
            solutionPairs.add(new SolutionPair(student.getName(), getSchoolMatched(takenList).getName()));
        }


        return new Solution(solutionPairs);
    }

}
