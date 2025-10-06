package UniversalStack;

class StackException extends Exception {
    public StackException(String message) {
        super(message);
    }

    //put your code here
}

class Stack <T> {
    private T[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        elements = (T[]) new Object[size];
        top = -1;
    }

    public void push(T value) throws StackException {
        if (top == elements.length -1) {
            throw new StackException("Стек переполнен");
        }
        elements[++top] = value;
    }

    public T pop() throws StackException {
        if (top == -1) {
            throw new StackException("Стек пуст");
        }
        return elements[top--];
    }

    public void printReverse() throws StackException {
        if (top == -1)
        { throw new StackException("Стек пуст");
        }
        for (int i = top; i >= 0; i--){
            System.out.print(elements[i]);
            if (i > 0) System.out.print(" ");
        }
    }
}
