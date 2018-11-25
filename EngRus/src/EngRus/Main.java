package EngRus;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception
    {

        FileReader fr2=new FileReader("C:\\Users\\User\\IdeaProjects\\EngRus\\src\\EngRus\\trans.txt");
        Scanner sc2= new Scanner(fr2);
        Map<String,String> arr=new HashMap<>();
        while(sc2.hasNext())
        {
            String t = sc2.nextLine();
            int index = t.indexOf("=");
            arr.put(t.substring(0,index), t.substring(index+1));
        }
        for(Map.Entry<String,String> p: arr.entrySet())
        {
            System.out.printf("%s - %s \n", p.getKey(), p.getValue());
        }
        FileReader fr1=new FileReader("C:\\Users\\User\\IdeaProjects\\EngRus\\src\\EngRus\\eng.txt");
        Scanner sc1=new Scanner(fr1);
        System.out.println("Text: ");
        while (sc1.hasNext()) {
            String b[] = sc1.nextLine().toLowerCase().split(" ");
            for (int i=0; i<b.length; i++)
            {
                String temp=arr.get(b[i]);
                System.out.print(temp+ " ");
            }
        }
        fr1.close();



    }
}
