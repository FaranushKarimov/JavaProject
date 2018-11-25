package ThreadArrays;

import java.util.Random;

public class Main {
    int num;
    public Main() {};

    synchronized public void receive (int ch) {
       // for(int num = 0;num <= 50;num++) {
            while(num > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num = ch;
            System.out.println("отправил: " + num);
            notify();
        //}
    }
    synchronized public void send () {
       // for (int num = 0; num <= 50; num++) {
        while(num < 0) {
            try {
                //СЃРѕСЃС‚РѕСЏРЅРёРµ -РѕР¶РёРґР°РЅРёСЏ РїРѕРєР° РЅРµ РІС‹Р·РѕРІРµРј notify()
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("получил: " + num);
            num = -1;
            notify();
        //}
    }
    public static void main(String[] args) throws Exception {

        Main m = new Main();
        Thread receive = new Receive(m);
        Thread send = new Send(m);
        receive.start();
        send.start();
        receive.join();
        send.join();

    }
}

