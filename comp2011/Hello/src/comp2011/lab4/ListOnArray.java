package comp2011.lab4;

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
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public void err() {
        System.out.println("Oops...");
    }

    public void insertAtFront(int x) {
    }

    public void insertAtTail(int x) {
    }

    public int deleteFirst() {
        return -1;
    }

    public int deleteLast() {
        return -1;
    }

    // this method should print out the numbers in the list in order
    // for example, after the demonstration, it should be "75, 85, 38, 49"
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        ListOnArray list = new ListOnArray();
        System.out.println(list);
        list.insertAtFront(75);
        list.insertAtFront(99);
        list.insertAtTail(85);
        list.insertAtTail(38);
        System.out.println(list);
        list.deleteFirst();
        System.out.println(list);
        list.insertAtTail(49);
        System.out.println(list);
    }
}
