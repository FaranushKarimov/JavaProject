package Collection;
import java.awt.*;
import java.util.*;
import java.util.List;
public class Collection {
    public Collection(){};
    public static void main(String[] args) {
        Collection d = new Collection();
        LinkedList ll = new LinkedList();

        ll.add("element1");
        ll.addFirst("element2");
        ll.addFirst("element3");
        ll.addFirst("element4");
        ll.addFirst("element5");
        ll.addFirst("element6");
        ll.addFirst("element7");
        ll.addFirst("element8");
        ll.addFirst("element9");
        d.print(ll);

        Iterator itr = ll.descendingIterator();
        while (itr.hasNext()){
            System.out.println((String)itr.next());
        }
        System.out.println("\n");

        ll.remove(2);
        d.print(ll);

        String element = (String)ll.getLast();
        ll.remove(element);
        d.print(ll);

        ll.subList(1,4).clear();
        d.print(ll);
    }

    public void print (List list){
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }
        System.out.println("\n");
      /*  List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list1.add(i);
        }
        for (int i = 0; i <10 ; ++i) {
            list1.remove(i);//ooops

        }*/
    }
}
