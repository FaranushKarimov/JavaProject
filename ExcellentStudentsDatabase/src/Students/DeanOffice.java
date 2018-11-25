package Students;

import java.util.Arrays;
import java.util.Comparator;

public class DeanOffice {
    private MessageBoard messageBoard = new MessageBoard();
    private StudentDatabase studentDatabase = new StudentDatabase();
    private static final float EXCELLENT_LIMIT = 4.8f;

    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    public StudentDatabase getStudentDatabase() {
        return studentDatabase;
    }

    public void setStudentDatabase(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    private Student[] selectExcellent(Student students[]) {
        int size = students.length;
        Student[] excellentStudents = new Student[size];
        for (int i = 0; i < size; i++) {
            if (students[i].getGpa() <= EXCELLENT_LIMIT) {
                excellentStudents[i] = students[i];
            }
        }
        return excellentStudents;
    }
   // public static Comparator<Student>
    //student_comparator = new Comparator<Student>()
   /* class SortedByTime implements Comparator<Student>
        {
            @Override
            public int compare(Student o1,Student o2) {
            return Float.compare(o1.getGpa(),o2.getGpa());
        }
        } */
    private Student[] AverageValue(Student students[]) {  //среднее время участников
        int size = students.length;
        Student [] AverageValue = new Student[size];
        double average = 0;
        if(size > 0) {
            double summary = 0;
            for(int j = 0;j < size;j++) {
                summary+=students[j].getGpa();
            }
            average = summary/size;
        }
        return AverageValue;
    }

    public void viewExcellentStudents() {
        Student[] allStudents = getStudentDatabase().getAll();
        Student[] excellentStudents = selectExcellent(allStudents);
        messageBoard.display(excellentStudents);
    }

    public static void main(String args[]) {
        DeanOffice deanOffice = new DeanOffice();
        deanOffice.viewExcellentStudents();

    }
}
