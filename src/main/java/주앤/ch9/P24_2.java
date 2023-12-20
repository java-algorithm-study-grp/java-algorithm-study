package 주앤.ch9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 : 225. Implement Stack using Queues
 * 실행시간 및 메모리 : 0 ms / 41.3 MB
 * 풀이 : [책] 삽입 큐와 추출 큐를 사용
 * 기존 풀이와 비교 :
 * 		기존 풀이에서는 pop()을 위해서 미리 push() 할 때마다 while문이 사용되었지만,
 * 		책 풀이에서는 실제로 pop()을 할 때 while문을 사용하기 때문에 더 상황에 맞게 연산 처리를 할 수 있다.
 *
 **/
public class P24_2 {
	class MyQueue {

	    private Deque<Integer> input;
	    private Deque<Integer> output;

	    public MyQueue() {
	        input = new ArrayDeque<>();
	        output = new ArrayDeque<>();
	    }

	    public void push(int x) {
	        input.push(x);
	    }

	    public int pop() {
	        peek();

	        return output.pop();
	    }

	    public int peek() {
	        if(output.isEmpty()){
	            while(!input.isEmpty()){
	                output.push(input.pop());
	            }
	        }
	        return output.peek();
	    }

	    public boolean empty() {
	        return input.isEmpty() && output.isEmpty();
	    }
	}
}
