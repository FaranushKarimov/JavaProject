package Pets;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class Animal {
    public String name;

    public Animal(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public String setName() {
        return this.name = name;
    }

    public String toString() {
        return " " + this.name;
    }
}

    /*public class Collections {
        public Collections(){};
        public static void main(String[] args) {
            Collections d = new Collections();
            LinkedList ll = new LinkedList();

            ll.add("Dog");
            ll.addFirst("Cat");
            ll.addFirst("Horse");
            ll.addFirst("Cow");
            ll.addFirst("Rabbit");
            ll.addFirst("Donkey");
            ll.addFirst("turkey");
            ll.addFirst("sheep");
            ll.addFirst("pig");
            d.print(ll);
            System.out.println("First Element:" + ll.getFirst());//Вывод первого элемента
            System.out.println("Last Element:" + ll.getLast());//Вывод последнего элемента

            Iterator itr = ll.descendingIterator();
            while (itr.hasNext()){
                System.out.println((String)itr.next());
            }
            System.out.println("\n");

            String element1 = (String)ll.getFirst();//удаление первого элемета
            ll.remove(element1);
            d.print(ll);

            String element = (String)ll.getLast();//удаление последнего элемета
            ll.remove(element);
            d.print(ll);

            ll.offerFirst("goat");//добавление нового элемента на начало списка
            d.print(ll);

            ll.offerLast("duck");//добавление нового элемента в конец списка
            d.print(ll);

            ll.offerLast("cock");//добавление нового элемента в конец списка
            d.print(ll);
            ll.subList(1,4).clear();
            d.print(ll);

            ll.poll();//Удаление головного элемента
            d.print(ll);


        }

        public void print (List list){
            Iterator it = list.iterator();
            while (it.hasNext()){
                System.out.println((String)it.next());
            }
            System.out.println("\n");
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < 10; ++i) {
                list1.add(i);
            }
            for (int i = 0; i <10 ; ++i) {
                list1.remove(i);//ooops

            }
        }
    }
    */
