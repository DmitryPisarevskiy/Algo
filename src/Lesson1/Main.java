package Lesson1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        String str = "Just a string";
        int num = 7;
        Cat barsik = new Cat("Barsik", 4);
        System.out.println(ANSI_GREEN + "Переменная str ссылочного типа String: " + ANSI_RESET + str);
        System.out.println(ANSI_GREEN + "Переменная num примитивного типа int: " + ANSI_RESET + num);
        System.out.println(ANSI_GREEN + "Переменная barsik абстрактного типа Cat:" + ANSI_RESET);
        barsik.info();

        System.out.println("\nПоиск переменной num в массиве nums");
        long time = System.nanoTime();
        int[] nums = {32, 5, 6, 8, 9, 5, 3, 6, 7};
        int i=0;
        while (i<nums.length) {
            if (nums[i]==num) {
                System.out.printf("Элемент найден, затраченное время - %d наносекунд",(System.nanoTime() - time));
            }
            i++;
        }
    }

}
