import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dormitory {
    private List<Apartment> apartments;

    public Dormitory() {
        this.apartments = new ArrayList<>();
        for (char faculty = 'A'; faculty <= 'D'; faculty++) {
            for (int number = 1; number <= 3; number++) {
                apartments.add(new Apartment(faculty, number));
            }
        }
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Apartment apartment : apartments) {
            students.addAll(apartment.getStudents());
        }
        Collections.sort(students);
        return students;
    }

    public List<Student> getStudentsInFaculty(char faculty) {
        List<Student> students = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getFaculty() == faculty) {
                students.addAll(apartment.getStudents());
            }
        }
        Collections.sort(students);
        return students;
    }

    public List<Apartment> getApartmentsInFaculty(char faculty) {
        List<Apartment> facultyApartments = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (apartment.getFaculty() == faculty) {
                facultyApartments.add(apartment);
            }
        }
        Collections.sort(facultyApartments, (a1, a2) -> a1.getNumber() - a2.getNumber());
        return facultyApartments;
    }

    public Apartment getApartmentByNumber(int number) {
        for (Apartment apartment : apartments) {
            if (apartment.getNumber() == number) {
                return apartment;
            }
        }
        return null;
    }


        // ...

        public boolean addStudentToApartment(Student student, char faculty, int number) {
            Apartment apartment = getApartmentByFacultyAndNumber(faculty, number);
            if (apartment == null) {
                return false;
            }
            return apartment.addStudent(student);
        }

        private Apartment getApartmentByFacultyAndNumber(char faculty, int number) {
            for (Apartment apartment : apartments) {
                if (apartment.getFaculty() == faculty && apartment.getNumber() == number) {
                    return apartment;
                }
            }
            return null;
        }

        // ...


    public boolean removeStudentFromApartment(Student student) {
        for (Apartment apartment : apartments) {
            if (apartment.getStudents().contains(student)) {
                apartment.removeStudent(student);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Apartment apartment : apartments) {
            sb.append(apartment).append(": ");
            sb.append(apartment.getStudents().toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean removeStudentFromApartment(int removeID, char removeFaculty, int removeNumber) {
        for (Apartment apartment : apartments) {
            if (apartment.getStudents().contains(Main.student)) {
                apartment.removeStudent(Main.student);
                return true;
            }
        }
        return false;
    }
    }

