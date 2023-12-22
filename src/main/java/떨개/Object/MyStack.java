package 떨개.Object;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    // 큐를 이용한 스택 구현을 위한 'MyStack'
    Queue<Integer> queue = new LinkedList<>();

    public void push(Integer integer) {
        // push 진행 시 FILO(First IN Last OUT)으로 처리 하기 위해
        // 기존에 있던 Queue 값을 재정렬.

        queue.add(integer);
        // 여기서 조금 헷갈려서 책을 봤음.
        for(int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public Integer pop() {
        return queue.remove();
    }

    public Integer top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
