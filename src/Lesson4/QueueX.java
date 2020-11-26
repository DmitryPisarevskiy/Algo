package Lesson4;

public class QueueX<T> {
    private T[] queue;
    private int rear;
    private int front;
    private int count;

    public QueueX(int size) {
        queue = (T[]) new Object[size];
        rear = -1;
        front = -1;
        count = 0;
    }

    public void push(T element) {
        if (count == 0) {
            count++;
            queue[++rear] = element;
            front++;
        } else if (count != queue.length) {
            rear = (rear == queue.length - 1) ? 0 : rear + 1;
            count++;
            queue[rear] = element;
        }
    }

    public T poll() {
        if (front == -1) {
            return null;
        } else {
            if (count == 1) {
                T temp = queue[front];
                front = -1;
                rear = -1;
                count--;
                return temp;
            } else {
                count--;
                return queue[front++];
            }
        }
    }

    public T peek() {
        return (front == -1) ? null : queue[front];
    }

    public void print() {
        if (rear >= front) {
            for (int i = front; i < rear + 1; i++) {
                System.out.println(queue[i].toString());
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i].toString());
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println(queue[i].toString());
            }
        }
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public boolean isEmpty() {
        return (front==-1);
    }

    public int size() {
        return count;
    }
}
