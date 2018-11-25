package Students;

public class MessageBoard {
    public void display(Person persons[]) {
        for (Person person : persons) {
            if (person != null) {
                System.out.println(person);
            }
        }
    }
}
