class Queue {
    int maxsize;
    int QueueArray[];
    int front;
    int rear;
    int count;

    Queue(int size) {
        maxsize = size;
        QueueArray = new int[maxsize];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enQueue(int value) {
        if (count == maxsize) {
            System.out.println("Queue is full. Cannot add item");
        } else {
            rear = (rear + 1) % maxsize;  // ✅ Corrected line
            QueueArray[rear] = value;
            System.out.println("Value " + value + " is inserted in Queue.");
            count++;
        }
    }

    public void deQueue() {
        if (count == 0) {
            System.out.println("Queue is Empty.");
        } else {
            System.out.println("\n" + QueueArray[front] + " is removed.");
            front = (front + 1) % maxsize;
            count--;
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Queue Elements are:");
            for (int i = 0; i < count; i++) {
                int index = (front + i) % maxsize;
                System.out.print(QueueArray[index] + "\t");
            }
            System.out.println();
        }
    }
}

public class QueueDemo {   // ✅ public class must match filename
    public static void main(String s[]) {
        Queue queue1 = new Queue(5);
        queue1.enQueue(12);
        queue1.enQueue(7);
        queue1.enQueue(8);
        queue1.enQueue(9);
        queue1.enQueue(13);
        queue1.enQueue(14);   // This will show "Queue is full"

        queue1.display();

        queue1.deQueue();
        queue1.deQueue();

        queue1.display();
    }
}