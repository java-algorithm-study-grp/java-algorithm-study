package src.main.java.우형.ch9;

import java.util.Stack;

public class P24 {

    class MyQueue {

        Stack<Integer> stack = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            Stack<Integer> temp = new Stack<>();
            for (int i = 0; i < stack.size(); i++) {
                temp.add(stack.pop());
            }

            stack.add(x);

            for (int i = 0; i < temp.size(); i++) {
                stack.add(temp.pop());
            }

        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.size() == 0;
        }
    }
}
