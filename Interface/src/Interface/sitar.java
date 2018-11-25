package Interface;

public class sitar implements Instrument{
    String name;
    int cena;
    String music;
    String material_strun;
    String  cvet;
    String material;
    String kachestvo_zvuka;
    int kolvo_ladov;

    sitar(String name,int cena,String music,String material_strun,String  cvet,String material,String kachestvo_zvuka,int kolvo_ladov)
    {
        this.name=name;
        this.cena=cena;
        this.music=music;
        this.material_strun=material_strun;
        this.cvet=cvet;
        this.material=material;
        this.kachestvo_zvuka=kachestvo_zvuka;
        this.kolvo_ladov=kolvo_ladov;
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
                " ,material_strun:" +material_strun+
                " ,cvet:" +cvet+
                " ,material:" +material+
                " ,kachestvo_zvuka:" +kachestvo_zvuka+
                " ,kolvo_ladov:" +kolvo_ladov
        );
    }
}
