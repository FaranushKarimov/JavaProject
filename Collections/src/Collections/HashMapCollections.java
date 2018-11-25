package Collections;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class HashMapCollections {
    public static void main(String[] args) {


        Map<String, Object> map =
                new HashMap<String, Object>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        Collection<String> collection = map.keySet();

        Object desiredObject = new Object();//что хотим найти
        desiredObject = 2;
        for (String key : collection) {
            Object obj = map.get(key);
            if (key != null) {
                if (desiredObject.equals(obj)) {
                    System.out.println(key);// нашли наше значение и возвращаем  ключ
                }
            }
        }

    }
}
