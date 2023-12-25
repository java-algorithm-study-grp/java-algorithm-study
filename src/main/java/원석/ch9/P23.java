package 원석.ch9;

import java.util.LinkedList;
import java.util.Queue;

public class P23 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public P23() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.poll();
        swapQueues();
        return topElement;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.offer(queue1.poll());
        swapQueues();
        return topElement;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public void swapQueues() {
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public static void main(String[] args) {
        P23 myStack = new P23();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // Output: 2
        System.out.println(myStack.pop()); // Output: 2
        System.out.println(myStack.empty()); // Output: false
    }

}
