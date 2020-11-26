package Lesson4;

import java.util.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final int SIZE = 7;

    public static void main(String[] args) {
        //        Задание 4.1
        //        На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        //        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.println("    Задание 4.1");
        StackX<Cat> stack = new StackX<>(SIZE);
        stack.push(new Cat("Barsik", 2));
        stack.push(new Cat("Bobik", 3));
        stack.push(new Cat("Kesha", 1));
        stack.push(new Cat("Murka", 2));
        stack.push(new Cat("Shurka", 1));

        estimateNanoTime(() -> stack.push(new Cat("Tom", 5)),
                "Добавление объекта Cat в StackX");

        estimateNanoTime(stack::poll,
                "Удаление объекта Cat из StackX");

        estimateNanoTime(() -> System.out.println(stack.peek().toString()),
                "Чтение и печать объекта Cat из StackX");

        stack.print();

        //        Задание 4.2
        //        На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        //        Реализуйте вспомогательные методы.
        //        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.println("\n\n    Задание 4.2");
        QueueX<Cat> queue = new QueueX<>(SIZE);
        queue.push(new Cat("Barsik", 2));
        queue.push(new Cat("Bobik", 3));
        queue.push(new Cat("Kesha", 1));
        queue.push(new Cat("Murka", 2));
        queue.push(new Cat("Shurka", 1));

        estimateNanoTime(() -> queue.push(new Cat("Tom", 5)),
                "Добавление объекта Cat в QueueX");

        estimateNanoTime(() -> queue.poll(),
                "Удаление объекта Cat из QueueX");

        estimateNanoTime(() -> System.out.println(queue.peek()),
                "Чтение и печать объекта Cat из QueueX");

        estimateNanoTime(() -> System.out.println(queue.isFull()),
                "Вызов и печать функции isFull Cat из QueueX");

        estimateNanoTime(() -> System.out.println(queue.isEmpty()),
                "Вызов и печать функции isEmpty Cat из QueueX");

        estimateNanoTime(() -> System.out.println(queue.size()),
                "Вызов и печать функции size Cat из QueueX");

        queue.print();

        //        Задание 4.3
        //        На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        //        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.println("\n\n    Задание 4.3");
        DequeueX<Cat> dequeue = new DequeueX<>();
        dequeue.pushLast(new Cat("Barsik", 2));
        dequeue.pushLast(new Cat("Bobik", 3));
        dequeue.pushLast(new Cat("Kesha", 1));
        dequeue.pushLast(new Cat("Murka", 2));
        dequeue.pushLast(new Cat("Shurka", 1));

        estimateNanoTime(() -> dequeue.pushFirst(new Cat("Tom", 5)),
                "Добавление объекта Cat в начало DequeueX");

        estimateNanoTime(() -> dequeue.pollLast(),
                "Удаление объекта Cat из конца DequeueX");

        estimateNanoTime(() -> System.out.println(dequeue.peekLast()),
                "Чтение и печать объекта Cat из конца QueueX");

        dequeue.print();

        //        Задание 4.4
        //        Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        //        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.println("\n\n    Задание 4.4");
        PriorityQueue<Integer> prQueue = new PriorityQueue<>();
        prQueue.add(5);
        prQueue.add(4);
        prQueue.add(2);
        prQueue.add(1);

        estimateNanoTime(() -> System.out.println(prQueue.poll()),
                "Удаление числа из Priority Queue");

        estimateNanoTime(() -> prQueue.add(3),
                "Добавление числа в Priority Queue");

        estimateNanoTime(() -> System.out.println(prQueue.peek()),
                "Чтение и печать числа из Priority Queue");

        while (!prQueue.isEmpty()) {
            System.out.println(prQueue.poll());
        }

        //        Задание 4.5
        //        На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        //        Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.println("\n\n\n    Задание 4.5");
        LinkedStackX<Cat> lStack = new LinkedStackX<>();
        lStack.push(new Cat("Barsik", 2));
        lStack.push(new Cat("Bobik", 3));
        lStack.push(new Cat("Kesha", 1));
        lStack.push(new Cat("Murka", 2));
        lStack.push(new Cat("Shurka", 1));

        estimateNanoTime(() -> lStack.push(new Cat("Tom", 5)),
                "Добавление объекта Cat в LinkedStackX");

        estimateNanoTime(lStack::poll,
                "Удаление объекта Cat из LinkedStackX");

        estimateNanoTime(() -> System.out.println(lStack.peek().toString()),
                "Чтение и печать объекта Cat из LinkedStackX");

        lStack.print();
        System.out.println();

        LinkedQueueX<Cat> lQueue = new LinkedQueueX<>();
        lQueue.push(new Cat("Barsik", 2));
        lQueue.push(new Cat("Bobik", 3));
        lQueue.push(new Cat("Kesha", 1));
        lQueue.push(new Cat("Murka", 2));
        lQueue.push(new Cat("Shurka", 1));

        estimateNanoTime(() -> lQueue.push(new Cat("Tom", 5)),
                "Добавление объекта Cat в LinkedQueueX");

        estimateNanoTime(lQueue::poll,
                "Удаление объекта Cat из LinkedQueueX");

        estimateNanoTime(() -> System.out.println(lQueue.peek().toString()),
                "Чтение и печать объекта Cat из LinkedQueueX");

        lQueue.print();


    }

    public static void estimateNanoTime(Runnable runnable, String description) {
        long start = System.nanoTime();
        runnable.run();
        System.out.printf(ANSI_GREEN + "Операция \"%s\" - %d наносекунд\n" + ANSI_RESET, description, (System.nanoTime() - start));
    }
}
