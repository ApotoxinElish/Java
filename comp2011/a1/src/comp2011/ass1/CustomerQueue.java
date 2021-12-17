package comp2011.ass1;

import comp2011.lec4.LinkedList;

/**
 * @author yixin cao (October 1, 2020)
 * <p>
 * A simulation of the queue waiting at a cashier.
 */
public class CustomerQueue {
    private LinkedList<String> list;

    public CustomerQueue() {
        list = new LinkedList<String>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(String s) {
        list.insertLast(s);
    }

    public String dequeue() {
        return list.removeFirst();
    }

    public String toString() {
        return list.toString();
    }

    public CustomerQueue[] split(int k) {
        CustomerQueue[] result = new CustomerQueue[k];  // store the return result

        for (int index = 0; !isEmpty(); index++) {  // index is refer to the queue to enter
            if (index < k) {  // to initialize each queue
                result[index] = new CustomerQueue();
            }

            result[index % k].enqueue(dequeue());  // dequeue() get the first one and enqueue() add it to the new queue
        }

        return result;
    }

    public static void main(String[] args) {
        CustomerQueue queue = new CustomerQueue();
        queue.enqueue("Peppa");
        queue.enqueue("Leo");
        queue.enqueue("Eason");
        queue.enqueue("Denise");
        queue.enqueue("Jennifer");
        System.out.println(queue.dequeue());
        queue.enqueue("Joey");
        queue.enqueue("Kay");
        queue.enqueue("Cheung");
        queue.enqueue("Winnie");
        queue.enqueue("Mickey");
        System.out.println(queue.dequeue());
        CustomerQueue[] queues = queue.split(3);
        for (CustomerQueue q : queues) System.out.println(q);
    }
}
