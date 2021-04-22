
class Node {
    int data;
    Node next; 
    public Node(int data) {
      
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private static Node rear = null, front = null;

    public int dequeue() // delete at the beginning
    {
        if (front == null) {
            System.out.print("\nQueue Underflow");
            System.exit(1);
        }

        Node temp = front;
        System.out.printf("Removing %d\n", temp.data);

        front = front.next;

        if (front == null) {
            rear = null;
        }
       
        int item = temp.data;
        return item;
    }

    public void enqueue(int item)
    {
        
        Node node = new Node(item);
        System.out.printf("Inserting %d\n", item);

      
        if (front == null) {
           
            front = node;
            rear = node;
        } else {
           
            rear.next = node;
            rear = node;
        }
    }

    // Utility function to return the top element in a queue
    public int peek() {
        // check for an empty queue
        if (front != null) {
            return front.data;
        } else {
            System.exit(1);
        }

        return front.data;

    }

    public boolean isEmpty() {
        return rear == null && front == null;
    }
}
