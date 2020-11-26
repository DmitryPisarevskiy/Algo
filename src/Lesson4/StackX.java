package Lesson4;

public class StackX<T> {
    private T[] stack;
    private int top;

    public StackX (int size) {
        stack = (T[]) new Object[size];
        top = -1;
    }

    public void push(T element){
        stack[++top]=element;
    }

    public T pop(){
        return (top==-1)?null:stack[top--];
    }

    public T peek(){
        return (top==-1)?null:stack[top];
    }

    public void print(){
        if (top!=-1) {
            for (int i = 0; i <top+1; i++) {
                System.out.println(stack[i].toString());
            }
        }
    }

    public boolean isFull() {
        return (top==stack.length-1);
    }
}
