package comp2011.lab3;

public class IntStack {

    private static final int CAPACITY = 128;
    private int[] data;
    private int top;

    public IntStack() {
        this(CAPACITY);
    }

    public IntStack(int size) {
        top = -1;
        data = new int[size];
    }

    public void push(int c) {
        data[++top] = c;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Oops...");
            return ' ';
        }
        // return data[top--];
        int c = data[top];
        top--;
        return c;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Oops...");
            return ' ';
        }
        return data[top];
    }

}
