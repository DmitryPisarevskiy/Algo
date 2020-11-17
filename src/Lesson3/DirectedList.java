package Lesson3;

public interface DirectedList<E> {
    void add(E node);
    void ins(int position, E node);
    void del(int position);
    E get(int position);
}
