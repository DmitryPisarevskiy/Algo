package Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int LENGTH_OF_ARRAY = 400;
    private static final int MAX_VALUE = 1500;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        int[] arr1 = randomArray(LENGTH_OF_ARRAY, MAX_VALUE);
        int[] arr2 = randomArray(LENGTH_OF_ARRAY, MAX_VALUE);

//        Задание 2.1 Реализуйте массив на основе существующих примитивных или ссылочных типов данных.
//        Выполните обращение к массиву и базовые операции класса Arrays.
//        Оценить выполненные методы с помощью базового класса System.nanoTime().
        estimateNanoTime(() -> {int[] arr3 = Arrays.copyOf(arr1, LENGTH_OF_ARRAY);},
                "Копирование массива при помощи Arrays");

        estimateNanoTime(() -> Arrays.sort(arr1),
                "Сортировка массива при помощи Arrays");

        estimateNanoTime(() -> {boolean b = Arrays.equals(arr1, arr2);},
                "Сраавнивание массивов arr1 и arr2 при помощи Arrays");

        estimateNanoTime(() -> System.out.println(Arrays.toString(arr1)),
                "Вывод массива при помощи Arrays");


//        Задание 2.2
//        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
//        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
        int aim = arr1[arr1.length * 3 / 4];
        estimateNanoTime(() -> linearSearch(arr1, aim),
                "Линейный поиск элемента в массиве");

        estimateNanoTime(() -> binarySearch(arr1, aim),
                "Бинарный поиск элемента в массиве");


//        Задание 2.3
//        Создайте массив размером 400 элементов.
//        Выполните сортировку с помощью метода sort().
//        Оцените сортировку с помощью базового класса System.nanoTime().
        int[] arr3 = randomArray(LENGTH_OF_ARRAY, MAX_VALUE);
        int[] arrForSort = Arrays.copyOf(arr3, LENGTH_OF_ARRAY);
        estimateNanoTime(() -> Arrays.sort(arrForSort),
                "Быстрая сортировка при помощи Arrays.sort");


//        Задание 2.4
//        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
        int[] arrForBubbleSort = Arrays.copyOf(arr3, LENGTH_OF_ARRAY);
        estimateNanoTime(() -> bubbleSort(arrForBubbleSort),
                "Сортировка пузырьком");

//        Задание 2.5
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
        int[] arrForChoiceSort = Arrays.copyOf(arr3, LENGTH_OF_ARRAY);
        estimateNanoTime(() -> choiceSort(arrForChoiceSort),
                "Сортировка выбором");

//        Задание 2.6
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
        int[] arrForInsertSort = Arrays.copyOf(arr3,LENGTH_OF_ARRAY);
        estimateNanoTime(()->insertSort(arrForInsertSort),
                "Сортировка методом вставки");
    }


    private static void insertSort(int[] array) {
        int in;
        int buf;
        for (int i = 1; i <array.length; i++) {
            buf = array[i];
            in = i;
            while (in>0 && array[in-1]>buf) {
                array[in] = array[in-1];
                in--;
            }
            array[in]=buf;
        }
    }

    private static void choiceSort(int[] array) {
        int buf;
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min!=i) {
                buf = array[i];
                array[i] = array[min];
                array[min]=buf;
            }
        }
    }

    private static void bubbleSort(int[] array) {
        int buf;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    buf = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = buf;
                }
            }
        }
    }

    private static void binarySearch(int[] array, int aim) {
        int start = 0;
        int end = array.length;
        int middle;
        while (start != end) {
            middle = (start + end) / 2;
            if (aim == array[middle]) {
                System.out.println("Элемент найден в массиве под номером " + middle);
                return;
            } else if (aim > array[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (aim == array[start]) {
            System.out.println("Элемент найден в массиве под номером " + start);
        }
    }

    private static void linearSearch(int[] array, int aim) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == aim) {
                System.out.println("Элемент найден в массиве под номером " + i);
            }
        }
    }


    public static void estimateNanoTime(Runnable runnable, String description) {
        long start = System.nanoTime();
        runnable.run();
        System.out.printf(ANSI_GREEN + "Операция \"%s\" - %d наносекунд\n" + ANSI_RESET, description, (System.nanoTime() - start));
    }

    public static int[] randomArray(int length, int max) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(max);
        }
        return arr;
    }

}
