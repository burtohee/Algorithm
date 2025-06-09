package Queue;


public class Code01_QueueBasic {




    public static void main(String [] args)
    {
        int N = 12;
        CustomizeQueue customizeQueue = new  CustomizeQueue(N);
        

        // try to delete element from the queue
        // currently queue is empty
        // so deletion is not possible
        customizeQueue.deQueue();

        // insert elements to the queue
        for(int i = 0; i < N; i ++) {
            customizeQueue.enQueue(i);
        }
        customizeQueue.display();

        // 6th element can't be added to queue because queue is full
        customizeQueue.enQueue(13);

        customizeQueue.display();

        // deQueue removes element entered first i.e. 1
        customizeQueue.deQueue();

        // Now we have just 4 elements
        customizeQueue.display();
    }
}
