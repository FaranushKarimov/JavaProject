package MusicShop;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public Runner() {
    }

    public static void main(String[] args) {
        Servises servises = new Servises();
        MusicShop1 musicShop1 = new MusicShop1();
        Guitar guitar1 = new Guitar("guitar1");
        Guitar guitar2 = new Guitar("guitar2");
        Guitar guitar3 = new Guitar("guitar3");
        Piano piano1 = new Piano("piano1");
        Piano piano2 = new Piano("piano2");
        Piano piano3 = new Piano("piano3");
        Trumpet trumpet1 = new Trumpet("trumpet1");
        Trumpet trumpet2 = new Trumpet("trumpet2");
        Trumpet trumpet3 = new Trumpet("trumpet3");
        musicShop1.getGuitars().add(guitar1);
        musicShop1.getGuitars().add(guitar2);
        musicShop1.getGuitars().add(guitar3);
        musicShop1.getPianos().add(piano1);
        musicShop1.getPianos().add(piano2);
        musicShop1.getPianos().add(piano3);
        musicShop1.getTrumpets().add(trumpet1);
        musicShop1.getTrumpets().add(trumpet2);
        musicShop1.getTrumpets().add(trumpet3);
        Map<String, Integer> order = new HashMap();
        order.put("guitar", Integer.valueOf(2));
        order.put("trumpet", Integer.valueOf(2));
        order.put("piano", Integer.valueOf(2));
        int n = servises.prepareInstruments(order, musicShop1).size();
        System.out.println(n);
    }
}
