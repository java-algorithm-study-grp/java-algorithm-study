package 떨개.ch9;

import 떨개.Object.MyQueue1;
import 떨개.Object.MyQueue2;

public class P24 {

    public static void main(String[] args) {
        // Ch09. 스택, 큐
        //  - 24. 스택을 이용한 큐 구현
        //   1) push(x) : 엘리먼트 x를 큐 마지막에 삽입한다.
        //   2) pop() : 큐 처음에 있는 엘리먼트를 제거한다.
        //   3) peek() : 큐 처음에 있는 엘리먼트를 조회한다.
        //   4) empty() : 큐가 비어 있는지 여부를 리턴한다.

        //  - 해당 큐의 사용 예는 다음과 같다.
        //  MyQueue queue = new MyQueue();
        //  queue.push(1);
        //  queue.push(2);
        //  queue.push(3);
        //  queue.peek();  // 1 리턴
        //  queue.pop();   // 1 리턴
        //  queue.empty();  // false 리턴

        // answer1();
        answer2();
    }

    private static void answer1() {
        
        // Deque 기능으로 존재하는 First, Last 메서드 방식
        
        MyQueue1 queue = new MyQueue1();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());  // 1 리턴
        System.out.println(queue.pop());   // 1 리턴
        // System.out.println(queue.pop());   // 2 리턴
        // System.out.println(queue.pop());   // 3 리턴
        System.out.println(queue.empty());  // false 리턴
    }

    private static void answer2() {
        
        // 책에서 제시한 Stack 2개를 이용한 방식.
        
        MyQueue2 queue = new MyQueue2();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());  // 1 리턴
        System.out.println(queue.pop());   // 1 리턴
        // System.out.println(queue.pop());   // 2 리턴
        // System.out.println(queue.pop());   // 3 리턴
        System.out.println(queue.empty());  // false 리턴
    }

}
