public class Stack<T extends Object> {
    public static void main(String[] args) {
        Queue<String> myQueue = new Queue<String>();
        myQueue.enQueue("a");
        myQueue.enQueue("b");
        myQueue.enQueue("c");
        myQueue.enQueue("d");
        myQueue.enQueue("e");
        Stack<String> myStack = new Stack<String>();
        while (!myQueue.isEmpty()) {
            myStack.push(myQueue.deQueue());
        }
        while (!myStack.isEmpty()) {
            myQueue.enQueue(myStack.top());
            myStack.pop();
        }
        myQueue.printQueue();
    }
    public class Node{
        T data;
        Node next;
    }
    int length;
    Node top;
    public Stack() {
        this.top = null;
    }
    // public Templates(String input) {
    //     for (int i = 0; i < input.length(); i++) {
    //         this.push(input.charAt(i));
    //     }
    // }
    public String reverse() {
        String backwards = "";
        while (!isEmpty()) {
            backwards += top();
            pop();
        }
        return backwards;
    }
    public Stack<T> reverseStack() {
        Stack<T> returner = new Stack<T>();
        while (!isEmpty()) {
            returner.push(top());
            pop();
        }
        return returner;
    }

    public void push(T x) {
        Node nextNode = new Node();
        nextNode.data = x;
        nextNode.next = top;
        top = nextNode;
        length++;
    }
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
    public void pop() {
        if (isEmpty()) {
            return;
        }
        top = top.next;
        length--;
    }
    public T popWithReturn() {
        if (isEmpty()) {
            return null;
        }
        Node temp = new Node();
        temp = this.top;
        top = top.next;
        return temp.data;
    }
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }
    public int length() {
        return this.length;
    }
    public T peek() {
        return this.top.data;
    }
}
