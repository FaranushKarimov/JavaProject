package Set;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Iterator;
import java.util.Set;
/*Ответ мы уже должны знать, потому что способ которым определяется уникальность ключа в методе put() имеет ту же логику, которую применяет метод get().*/
public class Statistics {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
      //  Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; i++) {
            Integer r = hm.get(new Integer(rand.nextInt(50)));
            hm.put((new Integer(rand.nextInt(50))), (r == null) ? 1 : r + 1);
           /* if(hm.containsKey(r))
                ((Counter)hm.get(r)).i++;
            else
                hm.put(r,new Counter());*/
        }
        // printMap(hm);
        //System.out.println(hm);
        /*for(Map.Entry<Integer,Integer> c : entrySet) {
            int value = counts.get(c) == null ? 0 : counts.get(c);
            counts.put(c.getKey(),c.getValue());
        }*/
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Integer,Integer>> entrySet = hm.entrySet();
        int overAllCount = 0;
        for(Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() > 1) {
                overAllCount += 1;

                sb.append("\n");
                sb.append(e.getKey());
                sb.append(": ");
                sb.append(e.getValue());
                sb.append(" times");
            }
        }
        if (overAllCount > 0) {
            sb.insert(0, " repeated numbers:");
            sb.insert(0, overAllCount);
            sb.insert(0, "There are ");
        }
        printMap(hm);
        System.out.print(sb.toString());
    }

    public static void printMap(Map<Integer, Integer> map) {

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

    }
}


