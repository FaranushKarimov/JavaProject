package Product;

import java.util.Arrays;
import java.util.Collection;
public class Example {
    public static void main(String[] args) {
        final float EXCELLENT_LIMIT = 5.3f;
        Student[] p = new Student[3];

        // заполним объект Student содержимым
        p[0] = new Student();
        p[0].setName("Faronush");
        p[0].setLastName("Karimov");
        p[0].setTime(5.3f);

        p[1] = new Student();
        p[1].setName("Sergey");
        p[1].setLastName("Evdokimov");
        p[1].setTime(3.4f);

        p[2] = new Student();
        p[2].setName("Vasya");
        p[2].setLastName("Petushok");
        p[2].setTime(1.2f);
        //Среднее значение по времени
        System.out.println("====== Average Value ======");
        double total = 0;
        for(Student i : p) {
            total += i.getTime();
        }
        double average = 0;
        if(p.length > 0) {
           average = total/p.length;
        }
        System.out.println("Average of Time:" + average);
        // выведем данные без сортировки
        System.out.println("============ no sorted ==============");

        for(Student i : p) {
            System.out.println("Name: " + i.getName() +
                    " Last Name: " + i.getLastName() +
                    " time: " + i.getTime());
        }
        //выявление призёров
        System.out.println("==== the Prizers ====");

        for(Student i : p) {
            if(i.getTime() < EXCELLENT_LIMIT) {
                System.out.println("Name: " + i.getName() +
                        " Last Name: " + i.getLastName() +
                        " time: " + i.getTime());
            }
        }
        // выявление победителя по времени
        System.out.println("==== The Winner ====");
        double  minValue = p[0].getTime();
        String Winner = p[0].getName()+ " " + p[0].getLastName();
        for(Student i : p) {
            if(i.getTime() < p[0].getTime())  {
                minValue = i.getTime();
                Winner = i.getName()+ " " + i.getLastName();
            }

        }
        System.out.println(minValue + " " + Winner + " ");

        // отсортируем и выведем данные по времени
        System.out.println("========== sorted by price===========");
        Arrays.sort(p, new SortedByPrice());

        for(Student i : p) {
            System.out.println("Name: " + i.getName() +
                    " Last Name: " + i.getLastName() +
                    " time: " + i.getTime());
        }

        // отсортируем и выведем данные по названию
        System.out.println("========== sorted by name ===========");

        Arrays.sort(p, new SortedByName());
        for(Student i : p) {
            System.out.println("Name: " + i.getName() +
                    " Last Name: " + i.getLastName() +
                    " time: " + i.getTime());
        }
        System.out.println("==== Numbers of participate ====");
        // количество участников
        System.out.println(p.length);
    }


}
