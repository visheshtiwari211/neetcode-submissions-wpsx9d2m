class MyCircularQueue {
    LinkNode front, rear;
    int size = 0, capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        front = null;
        rear = null;
    }
    
    public boolean enQueue(int value) {
        if(size < capacity) {
            LinkNode node = new LinkNode(value);
            if(size <= 0) {
                front = node;
                rear = front;
            } else {
                rear.next = node;
                node.next = front;
                rear = node;
            }
            size++;
            return true;
        } else {
            return false;
        }

    }
    
    public boolean deQueue() {
        if(size > 0) {
            front = front.next;
            rear.next = front;
            size--;
            return true;
        } else {
            return false;
        }
    }
    
    public int Front() {
        if(size > 0) {
            return front.value;
        } else {
            return -1;
        }
    }
    
    public int Rear() {
        if(size > 0) {
            return rear.value;
        } else {
            return -1;
        }
    }
    
    public boolean isEmpty() {
        return size <= 0;
    }
    
    public boolean isFull() {
        return size >= capacity;
    }
}

public class LinkNode {
    int value; // The data stored in this node
    LinkNode next; // Reference to the next node in the list

    // Constructor to initialize a new node
    public LinkNode(int v) {
        this.value = v;
        this.next = null; // Initially, a new node points to nothing
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */