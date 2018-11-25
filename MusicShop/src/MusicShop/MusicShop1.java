package MusicShop;

import java.util.ArrayList;
import java.util.List;

public class MusicShop1 {
    public List<Guitar> guitars = new ArrayList();
    public List<Piano> pianos = new ArrayList();
    public List<Trumpet> trumpets = new ArrayList();

    public MusicShop1() {
    }

    public List<Guitar> getGuitars() {
        return this.guitars;
    }

    public List<Trumpet> getTrumpets() {
        return this.trumpets;
    }

    public List<Piano> getPianos() {
        return this.pianos;
    }
}
