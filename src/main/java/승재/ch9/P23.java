package 승재.ch9;

import java.util.LinkedList;
import java.util.Queue;

public class P23 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());

    }

    static class MyStack {

        Queue<Integer> q = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            q.offer(x);
            for (int i = 1; i < q.size(); i++) {
                q.offer(q.remove());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
