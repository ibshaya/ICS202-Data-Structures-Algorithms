package Lab05_Recursion.Task02;


public class QueueAsArrayTest {
    public static void main(String[] args) {
        QueueAsArray<Integer> myQueue = new QueueAsArray<>(5);

        myQueue.enqueue(60);
        myQueue.enqueue(20);
        myQueue.enqueue(40);
        myQueue.enqueue(30);
        myQueue.enqueue(70);

        System.out.println("The queue is: " + myQueue);
        System.out.println("First dequeued element is: " + myQueue.dequeue());
        System.out.println("Second dequeued element is: " + myQueue.dequeue());
        System.out.println("After two node deletion the queue is: " + myQueue);
        System.out.println("Element at queue front is: " + myQueue.peek());
    }
}

