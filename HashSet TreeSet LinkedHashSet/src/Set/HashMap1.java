package Set;
import java.util.HashMap;
import java.util.Map;
public class HashMap1 {
    public static void main(String[] args) {
        String message = "я лентяй, мне лень потратить 10 минут на решение простейшей задачи. Я лучше пойду поем.";
       /* String [] words = message.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");

        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : words) {
            if(!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if(count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }

        for(String word : counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
         } */
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < message.length(); ++i) {char c = message.charAt(i);//проверяемявляетсялисимволбуквой
             if(Character.isLetter(c)) {if(map.containsKey(c)) {map.put(c, map.get(c) + 1);}
             else{map.put(c, 1);}
             }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet() ) {
            System.out.println("буква: " + entry.getKey() + " кол-во: " + entry.getValue() + "\n");
        }
    }
}
