public class Queue<T extends Object> {
    private class Node{
        T data;
        Node next;
    }
    Node front;
    Node back;
    int length;
    public Queue() {
        this.back = null;
        this.front = null;
    }
    public boolean isEmpty() {
        if (this.back == null && this.front == null) {
            return true;
        }
        return false;
    }
    public void enQueue(T x) {
        Node newNode = new Node();
        newNode.data = x;
        newNode.next = null;
        if (isEmpty()) {
            this.back = newNode;
            this.front = newNode;
            length++;
            return;
        }
        this.back.next = newNode;
        this.back = newNode;
        length++;
    }
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        Node temporary = this.front;
        this.front= this.front.next;
        if (this.front == null) {
            this.back = null;
        }
        length--;
        return temporary.data;
    }
    public void printQueue() {
        while (!isEmpty()) {
            System.out.println(deQueue());
        }
    }
    public T peek() {
        return this.front.data;
    }
}
