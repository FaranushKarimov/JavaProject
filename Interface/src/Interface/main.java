package Interface;
import java.util.*;
public class main {
    public static void main(String[] args)
    {
        Object vitrina[][]=new Object[2][2];
        vitrina[0][0]=new guitar("Classic Guitar",5000,"la-la-la",6,"Red","Russian Tree","strunniy chipkoviy zvyk");
        vitrina[0][1]=new piano("Classic piano",10000,"do-re-mi","middle","black","Italian material","akusticheskiy zvuk",3);
        vitrina [1][0]=new sitar("Traditional sitar",5000,"myagkoe razvilistoe zvuchanie","neylon","yellow","Tree","strunniy chipkoviy zvuk",16);
        vitrina [1][1]=new truba("Concertnaya truba",11000,"tu-u-u-u","nizkiy","zoloto","med","duxovoy zvuk","Big");

        System.out.println("Ассортимент");
        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++)
                ((Instrument) vitrina[i][j]).draw();

        System.out.println("Покупатель выбирает музыкальный инструментв магазине");
        for (int i=0;i<2;i++)
            for (int j=0;j<2;j++)
            {
                System.out.println("Музыкальный инструмент лежит на витрине с номером места "+ i+"ряд "+j+"место");
                System.out.println(((Instrument) vitrina[i][j]).name() + " cost " + ((Instrument) vitrina[i][j]).cena() + " and music:" + ((Instrument) vitrina[i][j]).music());
            }

        System.out.println("Do you want to know about instrument's chracters? Pass number of seat on vitrina");
        Scanner in=new Scanner(System.in);
        Scanner in1=new Scanner(System.in);
        int a=in.nextInt();
        int b=in1.nextInt();
        ((Instrument) vitrina[a][b]).draw();

    }
}

