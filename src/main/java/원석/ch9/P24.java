package 원석.ch9;

import java.util.Stack;

public class P24 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public P24() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        P24 myQueue = new P24();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek()); // Output: 1
        System.out.println(myQueue.pop()); // Output: 1
        System.out.println(myQueue.empty()); // Output: false
    }
}
