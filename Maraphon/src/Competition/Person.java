package Competition;
import java.lang.*;
public class Person  {
    protected String firstName;
    protected String lastName;
    private float time;
    public Person(String firstName, String lastName,float time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        //return String.format("%s %s", getFirstName(), getLastName());
        return getFirstName() + " " +getLastName();
    }
}
