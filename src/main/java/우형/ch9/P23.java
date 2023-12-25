package src.main.java.우형.ch9;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P23 {

    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);

            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            //queue.poll(); 큐가 비어있는 경우 null을 반환하게되는데 return 타입이
            // int 이기때문에 에러 발생
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.size() == 0;
        }
    }
}
