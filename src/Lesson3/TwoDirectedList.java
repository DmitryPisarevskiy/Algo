package Lesson3;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoDirectedList<E> implements DirectedList<E> {
    private NodeTDL<E> firstElement;
    private NodeTDL<E> lastElement;
    private int size;
    public IteratorTDL iterator;

    public TwoDirectedList() {
        size = 0;
    }

    @Override
    public void add(E e) {
        if (size == 0) {
            firstElement = new NodeTDL<E>(e, null, null);
            lastElement = firstElement;
            iterator = new IteratorTDL(firstElement);
        } else {
            lastElement.nextNodeTDL = new NodeTDL<E>(e, null, lastElement);
            lastElement = lastElement.nextNodeTDL;
        }
        size++;
    }

    @Override
    public void ins(int position, E e) {
        if (position == 0) {
            NodeTDL<E> insNode = new NodeTDL<E>(e, getNode(position), null);
            firstElement.previousNodeTDL = insNode;
            firstElement = insNode;
        } else {
            NodeTDL<E> insNode = new NodeTDL<E>(e, getNode(position), getNode(position - 1));
            getNode(position).previousNodeTDL = insNode;
            getNode(position - 1).nextNodeTDL = insNode;
        }
        size++;
    }

    @Override
    public void del(int position) {
        getNode(position + 1).previousNodeTDL = getNode(position - 1);
        getNode(position - 1).nextNodeTDL = getNode(position + 1);
    }

    @Override
    public E get(int position) {
        return getNode(position).data;
    }

    private NodeTDL<E> getNode(int position) {
        int i = 0;
        NodeTDL<E> currentNode = firstElement;
        while (i < position) {
            i++;
            currentNode = currentNode.nextNodeTDL;
        }
        return currentNode;
    }

    private static class NodeTDL<E> {
        E data;
        NodeTDL<E> nextNodeTDL;
        NodeTDL<E> previousNodeTDL;

        public NodeTDL(E data, NodeTDL<E> nextNodeODL, NodeTDL<E> previousNodeTDL) {
            this.data = data;
            this.nextNodeTDL = nextNodeODL;
            this.previousNodeTDL = previousNodeTDL;
        }
    }

    private class IteratorTDL implements Iterator<E> {
        NodeTDL<E> currentNode;

        public IteratorTDL(NodeTDL<E> currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return (currentNode.nextNodeTDL != null);
        }

        @Override
        public E next() {
            currentNode = currentNode.nextNodeTDL;
            return currentNode.data;
        }


        @Override
        public void remove() {
            currentNode.previousNodeTDL.nextNodeTDL = currentNode.nextNodeTDL;
            currentNode.nextNodeTDL.previousNodeTDL = currentNode.previousNodeTDL;
        }

    }
}
