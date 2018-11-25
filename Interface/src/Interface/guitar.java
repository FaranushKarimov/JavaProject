package Interface;

public class guitar implements Instrument{
    String name;
    int cena;
    String music;
    int kolvo_strun;
    String cvet;
    String material;
    String kachestvo_zvuka;
     guitar(String name,int cena,String music, int kolvo_strun,String cvet,String material,String kachestvo_zvuka) {
    this.name=name;
    this.cena=cena;
    this.music=music;
    this.kolvo_strun=kolvo_strun;
    this.cvet=cvet;
    this.material=material;
    this.kachestvo_zvuka=kachestvo_zvuka;
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
                " ,kolvo_strun:" +kolvo_strun+
                " ,cvet:" +cvet+
                " ,material:" +material+
                " ,kachestvo_zvuka:" +kachestvo_zvuka
        );
    }
}
