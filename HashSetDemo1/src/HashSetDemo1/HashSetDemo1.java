package HashSetDemo1;
import  java.util.*;
import  java.util.List;
public class HashSetDemo1 {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            int a = r.nextInt(50);
            set.add(a);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(" " + it.next() + ":");
        }
        System.out.println();
       Set <Integer> set1 = new TreeSet<>(); //2
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        set1.add(7);
        set1.add(8);
        set1.add(9);
        set1.add(10);
        set1.add(11);
        set1.add(12);
        set1.add(13);
        set1.add(14);
        set1.add(15);
        set1.add(16);
        set1.add(17);
        set1.add(18);
        set1.add(19);
        set1.add(20);
        set1.add(21);
        set1.add(22);
        set1.add(23);
        set1.add(24);
        set1.add(25);
        set1.add(26);
        set1.add(27);
        set1.add(28);
        set1.add(29);
        set1.add(30);
        set1.add(31);
        set1.add(32);
        Iterator it1 = set1.iterator();
        while (it1.hasNext()) {
            System.out.print(" " + it1.next() + ":");

        }
        System.out.println();
        Set <Integer> set2 = new LinkedHashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(4);
        set2.add(6);
        set2.add(8);
        set2.add(3);
        set2.add(5);
        set2.add(7);
        Iterator it2 = set.iterator();
        it2 = set2.iterator();
        while (it2.hasNext()) {
            System.out.print(" " + it2.next() + ":");

        }

      /*  List<String> list = new ArrayList<>(); //3
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(" " + it.next() + ":");

        }
        System.out.println();

        Set <String> set3 = new LinkedHashSet<>(list);
        it = set3.iterator();
        while (it.hasNext()) {
            System.out.print(" " + it.next() + ":");

        }
        System.out.println();

        List<String> listWithoutDups = new ArrayList<>(set3);
        it = listWithoutDups.iterator();
        while (it.hasNext()) {
            System.out.print(" " + it.next() + ":");

        }
        System.out.println();*/

    /*  Map <String,String> dictionary = new HashMap<>(); //4
         dictionary.put("one","two");
         dictionary.put("two","three");
         System.out.println(dictionary);

         dictionary.remove("two");
         System.out.println(dictionary);*/
       /* SortedMap <String,String> dictionary = new TreeMap<>(); //5
        dictionary.put("one","two");
        dictionary.put("two","three");
        dictionary.put("foor","three");
        System.out.println(dictionary);

        dictionary.subMap("foor","two").clear();
        System.out.println(dictionary);*/


    }
}

