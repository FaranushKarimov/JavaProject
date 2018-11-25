package Pets;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Collections {
    public  Collections() {};
    public static void main(String[] args) {
        Collections collections = new Collections();
        LinkedList<Animal> animals = new LinkedList<Animal>();
        animals.add(new Animal("Cat"));
        animals.add(new Animal("Horse"));
        animals.add(new Animal("Cow"));
        animals.add(new Animal("Rabbit"));
        animals.add(new Animal("Donkey"));
        animals.add(new Animal("Turkey"));
        animals.add(new Animal("Sheep"));
        animals.add(new Animal("Pig"));
       // collections.print(animals);
        Iterator iterator = animals.descendingIterator();
        for(Animal a:animals) {
            System.out.println(a);
        }
      /*  System.out.println("\n");
        animals.getFirst();
        collections.print(animals);
        animals.getLast();
        collections.print(animals);
        animals.removeFirst();
        collections.print(animals);
        animals.removeLast();
        collections.print(animals);
        animals.poll();
        collections.print(animals);
        animals.offerLast(new Animal("duck"));
        collections.print(animals);
        animals.offerLast(new Animal("cock"));
        animals.offerFirst(new Animal("goat"));*/
        System.out.println("Pets elements are: ");
        for(Animal string : animals) {
            System.out.println(string);
        }
        Animal firstElement = animals.getFirst();
        System.out.println("First Element: " + firstElement);
        Animal lastElement = animals.getLast();
        System.out.println("Last Element: " + lastElement);
        Animal firstElement1 = animals.removeFirst();
        System.out.println("\n Element removed: " + firstElement1);
        Animal lastElement1 = animals.removeLast();
        System.out.println("Element removed: " + lastElement1);
        System.out.println("\nList Elements after Remove:");
        for(Animal string2 : animals) {
            System.out.println(string2);
        }
        Animal poll = animals.poll();
        System.out.println("Head element of the list is : " + poll);
        for(Animal string3 : animals) {
        System.out.println("Linked List after removal using poll() : " + string3);}
        animals.offerFirst(new Animal("goat"));
        for(Animal string : animals) {
            System.out.println("LinkedList After Addition:" + string);
        }
        animals.offerLast(new Animal("duck"));
        for(Animal string : animals) {
            System.out.println("LinkedList After Addition:" + string);
        }
        for(Animal string : animals) {
            System.out.println("Final linked list:" + string);
        }
        animals.offerLast(new Animal("cock"));
        for(Animal string : animals) {
            System.out.println("Final linked list:" + string);
        }
    }
   /* public void print (List list){
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println((it.next()));
        }
        System.out.println("\n");
      /*  List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list1.add(i);
        }
        for (int i = 0; i <10 ; ++i) {
            list1.remove(i);//ooops

        }*/
    }





