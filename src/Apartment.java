import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private char faculty;
    private int number;
    private List<Student> students;

    public Apartment(char faculty, int number) {
        this.faculty = faculty;
        this.number = number;
        this.students = new ArrayList<>();
    }

    public char getFaculty() {
        return faculty;
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        students.add(student);
        return false;
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return faculty + "-" + number;
    }
}
