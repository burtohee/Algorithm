package others_1_ds_sorting.Queue;

public class CustomizeQueue{
    private int [] queue;
    private int front;
    private int rear;


    CustomizeQueue(int N)
    {
        queue = new int[N];
        front = -1;
        rear = -1;

    }

    public boolean isEmpty()
    {
        if(front == -1 && rear == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean ifFull()
    {
            /*
                current position of rear: i
                next position of rear: (i + 1)
                next position of rear: (i + 1) % N; if i = N - 1, next position of rear will be N % N = 0
                prev position of rear: (i + N -1) % N; (i + N -1) make sure the value is positive
             */
        if( (rear + 1) % queue.length == front)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void enQueue(int x)
    {
        if(ifFull())
            return;
        else if(isEmpty())
        {
            front = 0;
            rear = 0;
        }
        else
        {
            rear = (rear + 1) % queue.length;
        }
        queue[rear] = x;

    }

    public void deQueue()
    {
        if(isEmpty())
            return;
        else if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % queue.length;
        }
    }

    // display element of the queue
    public void display() {
        int i;
        if (isEmpty()) {
            // display the front of the queue
            System.out.println("\nFront index-> " + front);
            System.out.print("Empty Queue");
            // display the rear of the queue
            System.out.println("\nRear index-> " + rear);
        }
        else {
            // display the front of the queue
            System.out.println("\nFront index-> " + front);

            // display element of the queue
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(queue[i] + "  ");

            // display the rear of the queue
            System.out.println("\nRear index-> " + rear);
        }
    }
}
