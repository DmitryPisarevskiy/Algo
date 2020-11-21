package Lesson3;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {
    private static final int LENGTH_OF_ARRAY = 4000;
    private static final int MAX_VALUE = 1500;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final Integer NUM_EXAMPLE =7;

    public static void main(String[] args) {
        //        Задание 3.1
        //        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        //        Оцените время выполнения преобразования.
        System.out.println("Простой список ArrayList");
        Integer[] arr1 = randomArray(LENGTH_OF_ARRAY, MAX_VALUE);

        estimateNanoTime(() -> {
                List<Integer> arrList = new ArrayList(Arrays.asList(arr1));
            },"Обраование ArrayList при помощи Arrays.asList");

        estimateNanoTime(() -> {
                List<Integer> arrList = new ArrayList();
                for (int value : arr1) {
                    arrList.add(value);
                }
            },"Обраование ArrayList при помощи add");

        //        Задание 3.2
        //        На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
        //        Оценить выполненные методы с помощью базового класса System.nanoTime().
        List<Integer> arrList = new ArrayList(Arrays.asList(arr1));

        estimateNanoTime(() -> arrList.add(arr1[0]),
                "Добавление элемента в ArrayList");

        estimateNanoTime(() -> arrList.remove(0),
                "Удаление из ArrayList");

        estimateNanoTime(() -> System.out.println(arrList.get(0).toString())
                ,"Получение элемента ArrayList");


        //        Задание 3.3
        //        Реализуйте простой односвязный список и его базовые методы.
        System.out.println("\n\nОдносвязный список OneDirectionList");
        OneDirectedList<Integer> oneDirectedList = new OneDirectedList<>();
        for (Integer integer : arr1) {
            oneDirectedList.add(integer);
        }

        estimateNanoTime(() -> oneDirectedList.add(arr1[0]),
                "Добавление элемента в OneDirectedList");

        estimateNanoTime(() -> oneDirectedList.ins(0, NUM_EXAMPLE),
                "Вставка элемента в OneDirectedList");

        estimateNanoTime(() -> System.out.println(oneDirectedList.get(0).toString()),
                "Получение элемента из OneDirectedList");

        estimateNanoTime(() -> oneDirectedList.del(0),
                "Удаление элемента из OneDirectedList");


        //        Задание 3.4
        //        На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        //        Реализуйте список заполненный объектами из вашего класса из задания 1.3
        System.out.println("\n\nДвусвязный список TwoDirectionList");
        TwoDirectedList<Integer> twoDirectedList = new TwoDirectedList<>();
        for (Integer integer : arr1) {
            twoDirectedList.add(integer);
        }

        estimateNanoTime(() -> twoDirectedList.add(arr1[0]),
                "Добавление элемента в TwoDirectedList");

        estimateNanoTime(() -> twoDirectedList.ins(0, NUM_EXAMPLE),
                "Вставка элемента в TwoDirectedList");

        estimateNanoTime(() -> System.out.println(twoDirectedList.get(0).toString()),
                "Получение элемента из TwoDirectedList");

        estimateNanoTime(() -> twoDirectedList.del(0),
                "Удаление элемента из TwoDirectedList");


        //        Задание 3.5
        //        Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        //        Оцените время выполнения операций с помощью базового метода System.nanoTime()
        System.out.println("\n\nИтератор для двусвязанного списка");
        Iterator<Integer> iterator = twoDirectedList.iterator;
        estimateNanoTime(() -> System.out.println(iterator.hasNext()),
                "Проверка наличия следующего элемента из TwoDirectedList");

        estimateNanoTime(() -> System.out.println(iterator.next().toString()),
                "Получение следующего элемента из TwoDirectedList");

        estimateNanoTime(iterator::remove,
                "Удаление текущего элемента из TwoDirectedList");

    }

    public static void estimateNanoTime(Runnable runnable, String description) {
        long start = System.nanoTime();
        runnable.run();
        System.out.printf(ANSI_GREEN + "Операция \"%s\" - %d наносекунд\n" + ANSI_RESET, description, (System.nanoTime() - start));
    }

    public static Integer[] randomArray(int length, int max) {
        Random rand = new Random();
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

}
