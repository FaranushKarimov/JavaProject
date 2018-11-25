package Students;

public class StudentDatabase {
    private Student[] students;

    public StudentDatabase() {
        init();
    }

    private void init() {
        Student[] students = { new Student("Ivan", "Ivanov", 3),
                new Student("Petr", "Petrov", 4.9f),
                new Student("Sergei", "Sidorov", 5) };
        setStudents(students);
    }

    public Student[] getAll() {
        return getStudents();
    }

    private Student[] getStudents() {
        return students;
    }

    private void setStudents(Student[] students) {
        this.students = students;
    }

}

