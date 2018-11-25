package Animal;
import java.util.*;
public class MainCompar {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MyComparator MC = new MyComparator();
        Animal[] anyBySpeed = {
                new Animal(30),
                new Animal(20),
                new Animal(45),
                new Animal(12)};
        Arrays.sort(anyBySpeed, MC);
        for (int i = 0; i < anyBySpeed.length; i++) {
            System.out.println(anyBySpeed[i].toString());
        }

    }
}




