package CreatingStack;

public class Stack {

    private char[] elements;
    private int top;

    public Stack(int size) {
  elements = new char[size];
  top = -1;
    }

    public void push(char c) {
if (top == elements.length -1) {
    System.out.println("Стек заполнен!");
    return;
}
top++;
elements[top] = c;
    }

    public char pop() {
if (top == -1) {
    System.out.println("Попытка извлечь из пустого стека!");
    return 0;
}
return elements[top--];
    }

    public void print() {
        if (top == -1) {
            System.out.println("Стек пуст");
        }
        for (int i = top; i >= 0; i--) {
System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        top = -1;
    }

}
