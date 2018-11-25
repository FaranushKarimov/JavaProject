package ThreadArrays;
import java.util.Random;
public class Receive extends Thread{
    private  Main m;
  //  Random r = new Random();
    public Receive (Main m) {
        this.m = m;
    }
    public void run (){
        for(int i = 0; i < 50; i++) {
           // System.out.print (" " + i + " ");
           // m.receive(r.nextInt(50));
            m.receive(i);
        }

    }
}