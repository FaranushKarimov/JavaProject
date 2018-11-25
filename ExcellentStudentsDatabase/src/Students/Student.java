package Students;

import java.util.Comparator;

public class Student extends Person {
    /**
     * Grade point average (GPA)
     */
    private float gpa;

    public Student(String firstName, String lastName, float gpa) {
        super(firstName, lastName);
        this.gpa = gpa;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    class SortedByName implements Comparator<Student> {

        public int compare(Student obj1, Student obj2) {

            String str1 = obj1.getFirstName();
            String str2 = obj2.getFirstName();

            return str1.compareTo(str2);
        }
    }
    class SortedByPrice implements Comparator<Student> {

        public int compare(Student obj1, Student obj2) {

            float price1 = obj1.getGpa();
            float price2 = obj2.getGpa();

            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
      }
    }