package Set;
import java.util.*;
import java.util.List;

public class Sets {
    public static void main(String[] args) {
        int leftBoundary, rightBoundary;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите левую границу: ");
        leftBoundary = sc.nextInt();
        System.out.println("Введите правую границу: ");
        rightBoundary = sc.nextInt();
        Random random = new Random(System.currentTimeMillis());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();
        Set<Integer> set3 = new LinkedHashSet<>();
        for (int i = 0; i < 50; i++) {
            set1.add(random.nextInt(rightBoundary - leftBoundary + 1) + leftBoundary);
            set2.add(random.nextInt(rightBoundary - leftBoundary + 1) + leftBoundary);
            set3.add(random.nextInt(rightBoundary - leftBoundary + 1) + leftBoundary);
        }
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);
        System.out.println();

        List<Integer> listArr = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listArr.add(random.nextInt(rightBoundary - leftBoundary) + leftBoundary);
        }
        Set<Integer> set4 = new HashSet<>(listArr);
        System.out.println("Set4: " + set4);
        System.out.println(set2.containsAll(set4));
        System.out.println();

        set2.removeAll(set4);
        System.out.println("Set2: " + set2);
    }
}
