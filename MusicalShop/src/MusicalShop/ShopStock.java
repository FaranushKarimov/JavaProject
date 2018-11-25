package MusicalShop;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShopStock {
    ShopStock(){
        ShopStock();
    }

    //Наполняем магазин инструментами и их количеством
    private Map<String, Integer> shopStock = new HashMap<>();

    public Map<String, Integer> ShopStock(){

        shopStock.put("guitar",  16);
        shopStock.put("piano",   7);
        shopStock.put("tube",    2);

        Set<String> strings = shopStock.keySet();
        System.out.println("\nStock in shop:");
        for (String k: strings) {
            System.out.println(k+" "+shopStock.get(k));
        }
        return shopStock;
    }
}
