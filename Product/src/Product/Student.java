package Product;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    private String name;
    private String lastname;
    private float time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}

class SortedByName implements Comparator<Student> {

    public int compare(Student obj1, Student obj2) {

        String str1 = obj1.getName();
        String str2 = obj2.getName();

        return str1.compareTo(str2);
    }
}

class SortedByPrice implements Comparator<Student> {

    public int compare(Student obj1, Student obj2) {

        float price1 = obj1.getTime();
        float price2 = obj2.getTime();

        if (price1 > price2) {
            return 1;
        } else if (price1 < price2) {
            return -1;
        } else {
            return 0;
        }
    }
}
// ну и собственно работа с нашими данными
