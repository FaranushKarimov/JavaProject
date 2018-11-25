package Animals;

public class Animal implements Comparable <Animal>{
    private int speed;
    public Animal (int s)
    {speed=s;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "speed=" + speed +
                '}';
    }
    public int getSpeed()
    {return speed;
    }


    public int compareTo(Animal any)
    {return any.getSpeed()>speed? -1 :
            any.getSpeed()<speed? 1 : 0;
    }
}

