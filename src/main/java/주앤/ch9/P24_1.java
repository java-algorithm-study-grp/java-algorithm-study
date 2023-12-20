package 주앤.ch9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 : 225. Implement Stack using Queues
 * 실행시간 및 메모리 : 0 ms / 41.1 MB
 * 풀이 : 하나의 덱에 옮겨 담으면 역순으로 담기고, 새로운 요소를 추가한 후에 모든 요소를 다시 옮겨 담으면 원하는 형태로 데이터를 담을 수 있음.
 * 스택을 거꾸로 저장하여 큐로 만듬.
 *
 **/
public class P24_1 {
	class MyQueue {

	    private Deque<Integer> stack;

	    public MyQueue() {
	        stack = new ArrayDeque<>();
	    }

	    public void push(int x) {
	        Deque<Integer> temp = new ArrayDeque<>();

	        while(stack.size() > 0){
	            temp.push(stack.pop());
	        }

	        temp.push(x);

	        while(temp.size() > 0){
	            stack.push(temp.pop());
	        }
	    }

	    public int pop() {
	        return stack.pop();
	    }

	    public int peek() {
	        return stack.peek();
	    }

	    public boolean empty() {
	        return stack.isEmpty();
	    }
	}
}
