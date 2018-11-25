package MusicShop;

import java.util.*;

public class Servises {
    List<MusicalInstrument> list = new ArrayList();

    public Servises() {
    }

    public List<MusicalInstrument> prepareInstruments(Map<String, Integer> order, MusicShop1 musicShop1) {
        Set<String> strings = order.keySet();
        Iterator var4 = strings.iterator();

        while(true) {
            while(var4.hasNext()) {
                String k = (String)var4.next();
                int i;
                if (k.equals("guitar") && ((Integer)order.get(k)).intValue() <= musicShop1.getGuitars().size()) {
                    for(i = 0; i < ((Integer)order.get(k)).intValue(); ++i) {
                        this.list.add(musicShop1.getGuitars().get(i));
                    }
                } else if (k.equals("trumpet") && ((Integer)order.get(k)).intValue() <= musicShop1.getTrumpets().size()) {
                    for(i = 0; i < ((Integer)order.get(k)).intValue(); ++i) {
                        this.list.add(musicShop1.getTrumpets().get(i));
                    }
                } else if (k.equals("piano") && ((Integer)order.get(k)).intValue() <= musicShop1.getPianos().size()) {
                    for(i = 0; i < ((Integer)order.get(k)).intValue(); ++i) {
                        this.list.add(musicShop1.getPianos().get(i));
                    }
                }
            }

            return this.list;
        }
    }
}
