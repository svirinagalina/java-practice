package ParametrizedClasses;

public class MySet <E> {

    private E[] elements;
    private int size;

    public void add(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return;
            }
        }

    if (size == elements.length) {
    expandArray();
    }

    elements[size++] = e;
    }

    @SuppressWarnings("unchecked")
private void expandArray() {
        int newLength = (int)(elements.length * 1.5) + 1;

E[] newArray = (E[]) new Object[newLength];
for (int i = 0; i < size; i++) {
    newArray[i] = elements[i];
}
elements = newArray;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public MySet() {
        elements = (E[]) new Object[10];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MySet(int n) {
        elements = (E[]) new Object[n];
        size = 0;
    }
}
