package 떨개.Object;


import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue1 {

    // 현재 자.알.인 책에서 Stack<Integer> stack = new Stack(); 에 대한 단점을 나열하고 있다.
    // 자바 공식 문서에도 권고하고 있는 내용이기에 이로 스택을 구현한다.

    // 스택을 이용한 큐 구현을 위한 'MyQueue'
    //  - 여기에서는 단순히 Deque에 있는 간단한 메소드로 진행해보겠다.
    //  - 현재 스택(Stack) First IN Last OUT 이기 때문에
    //    Deque에서 들어간 값이 First가 마지막으로 들어간 값, Last가 처음으로 들어간 값이다.
    Deque<Integer> stack = new ArrayDeque<>();

    public void push(Integer e) {
        stack.push(e);
    }

    public Integer pop() {
        // pollFirst() : 마지막으로 들어간 엘리멘트 값을 제거 후 출력
        // pollLast() : 처음으로 들어간 엘리멘트 값을 제거 후 출력
        return stack.pollLast();
    }

    public Integer peek() {
        // peekFirst() : 마지막으로 들어간 엘리멘트 값을 출력
        // peekLast() : 처음으로 들어간 엘리멘트 값을 출력
        return stack.peekLast();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
