package University;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collections;
public class University implements Comparable <University> {
    private String id;
    private String name;
    private int age;
    private String lastname;
    private String patronymic;
    private String post;

    public University(String id, String name, int age, String lastname, String patronymic, String post) { // constructor
        this.id = id;
        this.name = name;
        this.age = age;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPost() {
        return post;
    }

    /*  public int compareTo(University u) {
          if (this.age > u.age)
              return 1;
          else if (this.age < u.age)
              return -1;
          else
              return 0;
      }*/
    public int compareTo(University obj) {
        University e = (University) obj;

        if (this.name.equals(e.getName())) {
            return this.lastname.compareTo(e.getLastname())
            & this.patronymic.compareTo(e.getPatronymic());
        } else {
            return this.name.compareTo(e.getName());
        }
    }

    @Override
    public String toString() {
        return "" + this.id + " " + this.name + " " + this.lastname + " " + this.patronymic + " " + this.age + " " + this.post+"\n";
    }
}
