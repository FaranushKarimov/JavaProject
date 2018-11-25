package Thread;

public class Test extends Thread {
    static int sum;
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            sum += i;
        }
    }
}

