package Lesson4;

import java.util.LinkedList;

public class LinkedQueueX<T> {
    private LinkedList<T> queue;

    public LinkedQueueX(){
        queue = new LinkedList<>();
    }

    public void push(T element) {
        queue.addLast(element);
    }

    public T poll() {
        return queue.poll();
    }

    public T peek() {
        return queue.peek();
    }

    public void print() {
        for (T t : queue) {
            System.out.println(t.toString());
        }
    }
}
