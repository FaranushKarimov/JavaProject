package MusicShop;

public class Trumpet extends MusicalInstrument {
    private String name;

    public Trumpet(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Trumpet guest = (Trumpet)obj;
            return this.name == guest.name;
        } else {
            return false;
        }
    }

    public int hashCode() {
        boolean prime = true;
        int result = 31;
       // int result = 31 * result;
        return result;
    }
}
