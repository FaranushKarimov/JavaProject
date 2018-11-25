package MusicShop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ShopStock {
    private Map<String, Integer> shopStock = new HashMap();

    ShopStock() {
        this.ShopStock();
    }

    public Map<String, Integer> ShopStock() {
        this.shopStock.put("guitar", Integer.valueOf(16));
        this.shopStock.put("piano", Integer.valueOf(7));
        this.shopStock.put("tube", Integer.valueOf(2));
        Set<String> strings = this.shopStock.keySet();
        System.out.println("\nStock in shop:");
        Iterator var2 = strings.iterator();

        while(var2.hasNext()) {
            String k = (String)var2.next();
            System.out.println(k + " " + this.shopStock.get(k));
        }

        return this.shopStock;
    }
}
