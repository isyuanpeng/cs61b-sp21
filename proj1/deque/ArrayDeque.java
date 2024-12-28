package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public ArrayDeque() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void resizeFirst(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 1, size);
        array = newArray;
    }

    @Override
    public void modify(int index, T element) {
        array[index] = element;
    }

    @Override
    public void addFirst(T item) {
        if (size == array.length) {
            resizeFirst(array.length * 2);
        }
        array[0] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size++] = item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        T t = array[0];
        T[] newArray = (T[]) new Object[array.length - 1];
        System.arraycopy(array, 1, newArray, 0, size);
        size--;
        return t;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
