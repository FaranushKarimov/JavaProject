package Animal;

import java.util.Comparator;

public class MyComparator implements Comparator {
    public int compare (Object o1,Object o2)
    {Animal any1 = (Animal)o1;
        Animal any2 = (Animal)o2;
        if ( any1.getSpeed()>any2.getSpeed())
            return 1;
        else if (any1.getSpeed()<any2.getSpeed())
            return -1; else return 0;
    }
}
