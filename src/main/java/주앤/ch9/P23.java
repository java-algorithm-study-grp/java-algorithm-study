package 주앤.ch9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 : 225. Implement Stack using Queues
 * 실행시간 및 메모리 : 0 ms / 40.4 MB (38.29%)
 * 풀이 : add(),remove(),element() 는 offer(),poll(),peek() 과 동일한 기능이나, 문제 발생 시, exception을 발생시킨다.
 *
 */
public class P23 {
	class MyStack {

	    private Queue<Integer> queue;

	    public MyStack() {
	        this.queue = new LinkedList<>();
	    }

	    public void push(int x) {

	        // 새 데이터를 끝에 저장
	        queue.add(x);

	        // 기존의 데이터를 앞에서 부터 저장하기 전까지 추출하여, 현재 큐의 끝에 저장하여 재배치
	        for(int i = 0; i <= queue.size() - 2; i++){
	            queue.add(queue.remove());
	        }
	    }

	    public int pop() {
	        return queue.remove();
	    }

	    public int top() {

	        return queue.element();
	    }

	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
}
