package Lesson4;

import java.util.LinkedList;

public class DequeueX<T> {
    private LinkedList<T> dequeue;

    public DequeueX() {
        dequeue = new LinkedList<>();
    }

    public void pushFirst(T element) {
        dequeue.addFirst(element);
    }

    public void pushLast(T element) {
        dequeue.addLast(element);
    }

    public T pollFirst() {
        return dequeue.pollFirst();
    }

    public T pollLast() {
        return dequeue.pollLast();
    }

    public T peekFirst() {
        return dequeue.peekFirst();
    }

    public T peekLast() {
        return dequeue.peekLast();
    }

    public void print() {
        for (T t : dequeue) {
            System.out.println(t.toString());
        };
    }
}
