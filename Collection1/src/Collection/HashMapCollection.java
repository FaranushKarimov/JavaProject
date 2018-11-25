package Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapCollection {
    public static void main(String[] args) {


        Map<String, Object> map =
                new HashMap<String, Object>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);


        Set<Map.Entry<String, Object>> entrySet = map.entrySet();

        Object desiredObject = new Object();//что хотим найти
        desiredObject = 5;
        for (Map.Entry<String, Object> pair : entrySet) {
            if (desiredObject.equals(pair.getValue())) {
                System.out.println(pair.getKey());// нашли наше значение и возвращаем  ключ
            }
        }

    }
}
