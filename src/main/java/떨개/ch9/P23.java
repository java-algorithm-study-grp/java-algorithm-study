package 떨개.ch9;

import 떨개.Object.ListNode;
import 떨개.Object.MyStack;

import java.util.LinkedList;
import java.util.List;

public class P23 {

    public static void main(String[] args) {
        // Ch09. 스택, 큐
        //  - 23. 큐를 이용한 스택 구현
        //   1) push(x) : 엘리먼트 x를 스택에 삽입한다.
        //   2) pop() : 스택의 첫 번째 엘리먼트를 삭제한다.
        //   3) top() : 스택의 첫 번째 엘리먼트를 가져온다.
        //   4) empty() : 스택이 비어 있는지 여부를 리턴한다.

        //  - 해당 스택의 사용 예는 다음과 같다.
        //  MyStack stack = new Stack();
        //  stack.push(1);
        //  stack.push(2);
        //  stack.push(3);
        //  stack.top(); // 3 리턴
        //  stack.pop(); // 3 리턴
        //  stack.empty(); // false 리턴

        answer1();

    }

    private static void answer1() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top()); // 3 리턴
        System.out.println(stack.pop()); // 3 리턴
        System.out.println(stack.empty()); // false 리턴
    }

}
