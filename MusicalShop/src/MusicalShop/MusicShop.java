package MusicalShop;

import java.util.*;
public class MusicShop1{
    String shopName;
    public List<MusicalInstrument> musicalInstruments = new ArrayList();

    MusicShop1(String name) {
        this.shopName=name;
        Guitar guitar = new Guitar("guitar");
        Trumpet trumpet = new Trumpet("trumpet");
        Piano piano = new Piano("piano");
        musicalInstruments.add(guitar);
        musicalInstruments.add(trumpet);
        musicalInstruments.add(piano);

       System.out.println("Создан музыкальный магазин  " +shopName+ " с ассортиментом товаров:");

       Iterator<MusicalInstrument> iterator = musicalInstruments.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getName());

       }
       System.out.println(musicalInstruments.get(1).getName());
        System.out.println(Arrays.toString(musicalInstruments.toArray()));
    }

    public List<MusicalInstrument> getMusicalInstruments() {
        return musicalInstruments;
    }

//
//
//
    public List<MusicalInstrument> prepareInstruments(Map<String, Integer> order){
        new Order();
        new ShopStock();

       Set<String> strings1 = shopStock.keySet();
        Set<String> strings = order.keySet();
        for (String k: strings) {


        }

    return musicalInstruments;
    }
}
//
//
//
////    Добавить в магазин инструментов метод, который готовит к отгрузке партию музыкальных инструментов согласно заказу.
////
////        Сигнатура метода:
////          public List<Instrument> prepareInstruments(Map<String, Integer> order){...}
////
////        В заказе (Map<String, Integer> order) хранится название инструмента и количество необходимых инструментов.
////
////        Ключем в заказе является одна из строк "piano", "guitar", "trumpet"
////
////        Создать свое исключение, которое будет брошено в случае, когда ключ в заказе другой.
////
////        Каким-то образом (самостоятельно выбрать решение) обработать ситуацию,
////        когда количество элементов в заказе отрицательное, нулевое.
////
////        После выполнения метода из магазина должны пропасть те инструменты, которые были отгружены.
////        В случае, когда количество запрашиваемых инструментов определенного типа больше, чем количество
////        доступных инструментов в магазине, должно быть брошено исключение. Выбрать наиболее подходящее из
////        доступных в стандартной библиотеке исключений
////
////          Пример:
////
////        в магазине было 2 фортепиано, 16 гитар и 7 труб.
////        пришел заказ на 7 гитар и 2 трубы.
////        после выполнения заказа в магазине осталось 2 фортепиано, 9 гитар и 5 труб
////        пришел заказ на 1 фортепиано
////        после выполнения заказа в магазине осталось 1 фортепиано, 9 гитар и 5 труб
////        пришел заказ на 1 фортепиано, 8 гитар и 6 труб
////        товар не был отгружен (было брошено исключение)
////        в магазине осталось 1 фортепиано, 9 гитар и 5 труб

