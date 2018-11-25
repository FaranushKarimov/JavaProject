package Interface;

public class piano implements Instrument{
    String name;
    int cena;
    String music;
    String size;
    String  cvet;
    String material;
    String kachestvo_zvuka;
    int kolvo_pedaley;

    piano(String name,int cena,String music,String size,String  cvet,String material,String kachestvo_zvuka,int kolvo_pedaley)
    {
        this.name=name;
        this.cena=cena;
        this.music=music;
        this.size=size;
        this.cvet=cvet;
        this.material=material;
        this.kachestvo_zvuka=kachestvo_zvuka;
        this.kolvo_pedaley=kolvo_pedaley;
    }

    public int cena()
    {
        return cena;
    }

    public String name()
    {
        return name;
    }

    public String music()
    {
        return music;
    }
    public void draw()
    {
        System.out.println(name+
                " cena:" +cena+
                " ,music:" +music+
                " ,size:" +size+
                " ,cvet:" +cvet+
                " ,material:" +material+
                " ,kachestvo_zvuka:" +kachestvo_zvuka+
                " ,kolvo_pedaley:" +kolvo_pedaley
        );
    }
}
