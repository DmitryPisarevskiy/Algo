package Lesson4;

import java.util.LinkedList;

public class LinkedStackX<T> {
    private LinkedList<T> stack;

    public LinkedStackX() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.push(element);
    }

    public T poll() {
        return stack.poll();
    }

    public T peek() {
        return stack.peek();
    }

    public void print() {
        for (T t : stack) {
            System.out.println(t.toString());
        }
    }
}
