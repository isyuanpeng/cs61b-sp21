package deque;

import java.util.Iterator;

/**
 * @author isyua
 */
public class LinkedListDeque<T> implements Deque<T> {

    public LinkedListDeque() {
        this.head = new Node(null, null, null);
        this.tail = new Node(null, this.head, this.head);
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node node = new Node(item, this.head.next, this.head);
        this.head.next = node;
        if (this.size == 0) {
            this.tail.pre = node;
        }
        this.size++;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(item, this.tail, this.tail.pre);
        this.tail.pre = node;
        if (this.size == 0) {
            this.head.next = node;
        }
        this.size++;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        Node node = this.head.next;
        this.head.next = node.next;
        if (node.next != null) {
            node.next.pre = this.head;
        }
        this.size--;
        return node.item;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        Node node = this.tail.pre;
        this.tail.pre = node.pre;
        node.pre.next = this.tail;
        this.size--;
        return node.item;
    }

    @Override
    public T get(int index) {
        Node t = this.head.next;
        for (int i = 1; i <= index; i++) {
            t = t.next;
        }

        return t.item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node {
        T item;
        Node next;
        Node pre;

        public Node(T item, Node next, Node pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }
    private Node head;
    private Node tail;
    private int size;



}