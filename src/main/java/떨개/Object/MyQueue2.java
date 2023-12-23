package 떨개.Object;


import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue2 {

    // 현재 자.알.인 책에서 Stack<Integer> stack = new Stack(); 에 대한 단점을 나열하고 있다.
    // 자바 공식 문서에도 권고하고 있는 내용이기에 이로 스택을 구현한다.

    // 스택을 이용한 큐 구현을 위한 'MyQueue'
    //  - 여기에서는 책에 씌여저 있는 스택 2개를 사용한 방법을 이용하겠다.

    // 삽입용 Stack
    Deque<Integer> input = new ArrayDeque<>();
    // 추출용 Stack
    Deque<Integer> output = new ArrayDeque<>();

    public void push(Integer e) {
        // 삽입용 Stack에 추가.
        input.push(e);
    }

    public Integer pop() {
        peek();

        return output.pop();
    }

    public Integer peek() {
        // 추출 스택에 저장된 게 없다면 진행.
        if(output.isEmpty()) {
            // 삽입 Stack이 비워질 때까지 진행.
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

}
