package Competition;
import java.util.Arrays;
import java.util.Comparator;

public class Results {
     private Person[] persons;
     private MessageBoard messageBoard = new MessageBoard();
//     private Results results = new Results();
     private static final float EXCELLENT_LIMIT = 6.3f;
     public Results() {
            init();
    }
     private void init() {
            Person[] persons = {new Person("Ivan","Ivanov",7.5f),
                    new Person("Artur","Karimov",3),
                    new Person("Vasya","Evdokimov",4),
                    new Person("Anastasiya","Nesterova",4.5f)};
            setPerson(persons);
    }
    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    public static final Comparator<Person>//сортировка по значению времени
    person_comparator = new Comparator<Person>()
    {
        @Override
        public int compare(Person o1,Person o2) {
          return Float.compare(o1.getTime(),o2.getTime());
        }
    };



  /* public int compare(Person o1,Person o2) {
        if (o1.getTime() == o2.getTime()) return 0;
        else if (o1.getTime() > o2.getTime()) return 1;
        else return -1;
    }*/
    private Person[] AverageValue(Person persons[]) {  //среднее время участников
         int size = persons.length;
         Person [] AverageValue = new Person[size];
         double average = 0;
         if(size > 0) {
             double summary = 0;
             for(int j = 0;j < size;j++) {
                 summary+=persons[j].getTime();
             }
             average = summary/size;
         }
         return AverageValue;
    }
    public Person[] getAll() {
         return getPerson();
    }
    public Results getResults() {
        return results;
    }
    private Person[] selectExcellent(Person persons[]) { //выявление победителя
        int size = persons.length;
        Person[] excellentPerson = new Person[size];
        for (int i = 0; i < size; i++) {
            if (persons[i].getTime() <= EXCELLENT_LIMIT) {
                excellentPerson[i] = persons[i];
            }
        }
        return excellentPerson;
    }
    private Person[] sortingAverage(Person persons[]) {
        int size = persons.length;
        Person[] sortingAverage = new Person[size];
        for(int i = 0;i < size; i++) {
            Arrays.sort(persons,person_comparator);
        }
    return sortingAverage;
    }
    public void viewExcellentStudents() {
        Person[] allStudents = getResults().getAll();
        Person[] excellentStudents = selectExcellent(allStudents);
        messageBoard.display(excellentStudents);
    }

    /*private Person[] selectThreePrizer(Person person[]) {
        int size = person.length;
        Person[] selectThreePrizer = new Person[size];
        for(int i = 0;i < size;i++) {
            if(person[i].getTime() <= EXCELLENT_LIMIT){

            }
        }
    return selectThreePrizer;
    }*/
   /* Arrays.sort(Person person[], new Comparator<person> () {
        public int compare (Person a, Person b) {
            int dif = a.getTime() - b.getTime();
            return ( dif < 0.0 ) ? -1 : ( dif > 0.0 ) ? 1 : 0;
        }
    }*/
    private Person[] getPerson() {
            return  persons;
    }
    private void setPerson(Person[] persons) {
        this.persons = persons;
    }
    public static void main(String args[]) {
        Results results = new Results();
        Results [] r = new Results[3];
        results.viewExcellentStudents();
    }
}
