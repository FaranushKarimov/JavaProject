package ThreadArrays;
public class Send extends Thread {
    private  Main m;

    public Send(Main m) {
        this.m = m;
    }

    public void run() {
        for (int i = 0; i < 50; i++)
            m.send();
    }
}
