package Interface;
public class truba implements Instrument{
    String name;
    int cena;
    String music;
    String ton_zvuka;
    String  cvet;
    String material;
    String kachestvo_zvuka;
    String size;

    truba(String name,int cena,String music,String ton_zvuka,String  cvet,String material,String kachestvo_zvuka,String size)
    {
        this.name=name;
        this.cena=cena;
        this.music=music;
        this.ton_zvuka=ton_zvuka;
        this.cvet=cvet;
        this.material=material;
        this.kachestvo_zvuka=kachestvo_zvuka;
        this.size=size;
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
                " ,ton_zvuka:" +ton_zvuka+
                " ,cvet:" +cvet+
                " ,material:" +material+
                " ,kachestvo_zvuka:" +kachestvo_zvuka+
                " ,size:" +size
        );
    }
}

