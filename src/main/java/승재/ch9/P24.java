package 승재.ch9;

import java.util.ArrayDeque;
import java.util.Deque;

public class P24 {

    private static class MyQueue {

        private final Deque<Integer> front = new ArrayDeque<>();
        private final Deque<Integer> back = new ArrayDeque<>();

        public MyQueue() {
        }

        public void push(int x) {
            front.push(x);
        }

        public int pop() {
            peek();
            return back.pop();
        }

        public int peek() {
            if (back.isEmpty()) {
                while (!front.isEmpty()) {
                    back.push(front.pop());
                }
            }
            return back.peek();
        }

        public boolean empty() {
            return front.isEmpty() && back.isEmpty();
        }
    }

}
