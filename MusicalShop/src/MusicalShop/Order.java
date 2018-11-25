package MusicalShop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {

   Order(){
   makeOrder();
    }

  public Map<String, Integer> makeOrder() {
       Map<String, Integer> order = new HashMap<>();
       order.put("guitar", 7);
       order.put("trumpet", 2);
       order.put("piano",1);

        Set<String> strings = order.keySet();

       System.out.println("\nNew order is getting:");
        for (String k: strings) {
            System.out.println(k+" "+order.get(k));
        }
       return order;
   }
}

