package Lesson3;

public class OneDirectedList<E> implements DirectedList<E>{
    private NodeODL<E> firstElement;
    private NodeODL<E> lastElement;
    private int size;

    public OneDirectedList() {
        size=0;
    }

    @Override
    public void add(E e) {
        if (size==0) {
            firstElement=new NodeODL<E>(e, null);
            lastElement = firstElement;
        } else {
            lastElement.nextNodeODL = new NodeODL<E>(e, null);
            lastElement = lastElement.nextNodeODL;
        }
        size++;
    }

    @Override
    public void ins(int position, E e) {
        NodeODL<E> insNode = new NodeODL<E>(e, getNode(position));
        if (position==0) {
            firstElement = insNode;
        } else {
            getNode(position-1).nextNodeODL = insNode;
        }
        size++;
    }

    @Override
    public void del(int position) {
        getNode(position-1).nextNodeODL = getNode(position).nextNodeODL;
    }

    @Override
    public E get(int position) {
        return getNode(position).data;
    }

    private NodeODL<E> getNode(int position) {
        int i=0;
        NodeODL<E> currentNode = firstElement;
        while (i<position) {
            i++;
            currentNode = currentNode.nextNodeODL;
        }
        return currentNode;
    }

    private class NodeODL<E> {
        E data;
        NodeODL<E> nextNodeODL;

        public NodeODL(E data, NodeODL<E> nextNodeODL) {
            this.data = data;
            this.nextNodeODL = nextNodeODL;
        }
    }
}

