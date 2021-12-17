package comp2011.lab4a;

import java.util.Arrays;

/**
 * @author yixin cao (September 28, 2020)
 * <p>
 * Simulating a linked list with an array.
 * Try to finish all the methods.
 */
public class ListOnArray {
    private int[] data;
    private static final int SIZE = 128; // it needs to be even.

    public ListOnArray() {
        data = new int[SIZE];

        data[0] = 0; // may be omitted in Java.
        for (int i = 2; i < SIZE - 2; i += 2)
            data[i] = i + 1;
        data[SIZE - 1] = 1;
        data[SIZE - 2] = 0;
    }

    public boolean isEmpty() {
        return data[0] == 0;
    }

    public boolean isFull() {
        return data[SIZE - 1] == 0;
    }

    public void err() {
        System.out.println("Oops...");
    }

    public void insertFirst(int x) {
        if (isFull()) {
            err();
            return;
        }
        int i = data[SIZE - 1];
        data[SIZE - 1] = data[i + 1];
        data[i + 1] = data[0];
        data[0] = i;
        data[i] = x;
    }

    public void insertLast(int x) {
        if (isFull()) {
            err();
            return;
        }
        if (isEmpty()) {
            insertFirst(x);
            return;
        }
        int i = 0;
        while (data[i] != 0) i = data[i] + 1;
        int n = data[SIZE - 1];
        data[SIZE - 1] = data[n + 1];
        data[i] = n;
        data[n] = x;
        data[n + 1] = 0;
    }

    public int removeFirst() {
        if (isEmpty()) {
            err();
            return -1;
        }
        int head = data[0];
        data[0] = data[head + 1];
        data[head + 1] = data[SIZE - 1];
        data[SIZE - 1] = head;
        return data[head];
    }

    public int removeLast() {
        if (isEmpty()) {
            err();
            return -1;
        }
        int tail = data[0];
        if (data[tail + 1] == 0) {
            return removeFirst();
        }
        int i = 0;
        while (data[tail + 1] != 0) {
            i = tail;
            tail = data[i + 1];
        }
        data[i + 1] = 0;
        data[tail + 1] = data[SIZE - 1];
        data[SIZE - 1] = tail;
        return data[tail];
    }


    // this method should print out the numbers in the list in order
    // for example, after the demonstration, it should be "75, 85, 38, 49"
    public String toString() {
        if (isEmpty()) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        int i = data[0];
        sb.append(data[i++]);
        while (data[i] != 0) {
            i = data[i];
            sb.append(", ").append(data[i++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListOnArray list = new ListOnArray();
        System.out.println(Arrays.toString(list.data));
        System.out.println(list);
        list.insertFirst(75);
        list.insertFirst(99);
        list.insertLast(85);
        list.insertLast(38);
        System.out.println(Arrays.toString(list.data));
        System.out.println(list);
        list.removeFirst();
        System.out.println(Arrays.toString(list.data));
        System.out.println(list);
        list.insertLast(49);
        System.out.println(Arrays.toString(list.data));
        System.out.println(list);


    }
}
