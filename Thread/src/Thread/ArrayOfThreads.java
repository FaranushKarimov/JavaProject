package Thread;
import java.util.Random;
public class ArrayOfThreads
{
    public static void main(String args[])
    {
        Test test[] = new Test[5];
        for(int i = 0; i < test.length; i++)
        {
            test[i] = new Test();
            test[i].start();
        }
        System.out.println("Sum = " + Test.sum);
    }
}