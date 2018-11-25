package Set;
import java.util.*;
public class LinkedHashSet1 {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 10000; i++) {
            int a = r.nextInt(50);
            set.add(a);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println("LinkedHashSet: " + it.next() + ":");
        }
    }
}
