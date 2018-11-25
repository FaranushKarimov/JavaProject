package University;

import java.text.Collator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;
class CompareAge implements Comparator<University> {
    @Override
    public int compare(University u1,University u2) {
        if(u1.getAge() < u2.getAge()) {
            return -1;
        } else if(u1.getAge() == u2.getAge()) {
            return 0;
        } else {
            return 1;
        }

    }
}
class PersonComparator implements  Comparator<University> {
    public int compare(University u1, University u2) {

            int nameComp = u1.getLastname().compareTo(u2.getLastname());
            return ((nameComp == 0) ? u1.getName().compareTo(u2.getName()) : nameComp);
        }
    }


public class Main {
    public static void main(String[] args) {
        LinkedList<University> sv = new LinkedList<University>();
        //    LinkedList<University> sv1 = new LinkedList<University>();
        sv.add(new University("1", "Иван", 18, "Иванов", "Иванович", "студент группы 09-512"));
        sv.add(new University("2", "Валентина", 45, "Андрианова", "Валерьевна", "преподаватель кафедры прикладной математики"));
        sv.add(new University("3", "Анастасия", 20, "Евдокимова", "Александровна", "студентка группы 09-543"));
        sv.add(new University("4", "Сергей", 57, "Пономарёв", "Алекссевич", "преподаватель кафедры прикладной математики"));
        sv.add(new University("5", "Антонина", 63, "Васильева", "Дмитриевна", "преподаватель кафедры прикладной математики"));
        sv.add(new University("6", "Семён", 21, "Миронов", "Сергеевич", "студент группы 09-703"));
        sv.add(new University("7", "Елена", 23, "Павлов", "Андреевна", "студентка группы 09 - 615"));
        sv.add(new University("8", "Григорий", 21, "Карапетян", "Каренович", "студет группы 09-512"));
      /*  int[] age = new int []{18,45,20,57,63,21,23,21};
        String name [] = {"Иван","Валентина","Анастасия","Сергей","Антонина","Семён","Елена","Григорий"};
        int sum = 0;
        int avg;
        int min=age[0];
        int max=age[0];
        int i;
        int counter=0;
        for(i=0;i<age.length;i++){
            if(age[i]<min ) {
                min=age[i];

            }
        }
        for(i=0;i<age.length;i++) {
            if(age[i]>max){
                max=age[i];
            }
        }
        for(i=0;i<age.length;i++){
            sum+=age[i];
        }

        avg= sum/age.length;
        System.out.println("the avarage of all Students are :"+avg);
        System.out.println("the minimum age of all Students : "+min);
        System.out.println("the maximum age of all Students :" +max);
        for(i=0;i<age.length;i++){
            if (age[i] == min ) {
                System.out.println("the minimum age of all Students  : "+name[i]);
            }
        for(i=0;i<age.length;i++) {
                if(age[i]==max) {
                    System.out.println("the maximum age of all Students :"+name[i] );
                }
          }
        }*/


        /* Iterator<University> it =  sv.iterator();
        while (it.hasNext())
        {
            University e = it.next();
            if (e.getPost().equals("преподаватель кафедры прикладной математики"))
            {sv1.add(e);
                it.remove();
            }
        }
        it = sv.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\n");

        Iterator<University>    it1 = sv1.iterator();
        while (it1.hasNext())
            System.out.println(it1.next());*/

        /*System.out.println("\nSorting starts now \n");

        Collections.sort(sv, new Comparator<University>() {
            @Override
            public int compare(University o1, University o2) {
                return o1.getPatronymic().compareTo(o2.getPatronymic());
            }
        });*/
      /*  System.out.println("-----------------");
        for(University university : sv){
            System.out.println(" "+university.getName() +" "+university.getLastname()+ " " + university.getPatronymic() +" "+university.getPost());
        }
        Collections.sort(sv,new CompareAge());
        System.out.println("Sorted list entries: ");
            System.out.println(sv);
            sv.sort(Comparator.comparing (University :: getLastname));*/
        // System.out.println("Sorted by LastName: "+ sv.toString())
        Iterator iter1 = sv.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        System.out.println("------------");
        Collections.sort(sv, new PersonComparator());
        Iterator iter2 = sv.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        System.out.println("-----------");
        System.out.println(Collections.min(sv, new CompareAge()));
        System.out.println(Collections.max(sv, new CompareAge()));


    }
}


