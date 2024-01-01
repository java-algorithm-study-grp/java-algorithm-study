package 떨개.ch10;

import 떨개.Object.MyCircularDeque1;
import 떨개.Object.MyCircularDeque2;

public class P26 {

    public static void main(String[] args) {
        // Ch10. 데크, 우선순위 큐
        //  - 26. 원형 데크 디자인
        //   1) MyClircularDeque(k): 데크 크기를 k로 지정하는 생성자다.
        //   2) insertFront(): 데크 처음에 아이템을 추가하고 성공할 경우 true를 리턴한다.
        //   3) insertLast(): 데크 마지막에 아이템을 추가하고 성공할 경우 true를 리턴한다.
        //   4) deleteFront(): 데크 처음에 아이템을 삭제하고 성공할 경우 true를 리턴한다.
        //   5) deleteLast(): 데크 마지막에 아이템을 삭제하고 성공할 경우 true를 리턴한다.
        //   6) getFront(): 데크 첫 번째 아이템을 가져온다. 데크가 비어있는 경우 -1을 리턴한다.
        //   7) getRear(): 데크 마지막 아이템을 가져온다. 데크가 비어 있다면 -1을 리턴한다.
        //   8) isEmpty(): 데크가 비어 있는지 여부를 판별한다.
        //   9) isFull(): 데크가 가득 차 있는지 여부를 판별한다.

        circularDeque1();
        circularDeque2();

    }

    private static void circularDeque1() {

        // 1. 이중 연결 리스트를 이용한 데크 구현
        //  - 책을 봤음. 이중 연결 리스트를 확인해봤는데 생각보다 많이 복잡해서 어려웠음.

        MyCircularDeque1 deque = new MyCircularDeque1(3);
        System.out.println(deque.insertLast(1)); // return true
        System.out.println(deque.insertLast(2)); // return true
        System.out.println(deque.insertFront(3)); // return true
        System.out.println(deque.insertFront(4)); // return false
        System.out.println(deque.deleteLast()); // return true
        System.out.println(deque.getRear()); // return 1
        System.out.println(deque.isFull()); // return false
        System.out.println(deque.deleteLast()); // return true
        System.out.println(deque.insertFront(4)); // return true
        System.out.println(deque.getFront()); // return 4

    }

    private static void circularDeque2() {

        // 2. Deque를 사용한 방법
        //  - 스스로 풀어보는 방법.
        //  - 근데 Deque - LinkedList로 하면 크기를 정할 수가 없다. 이를 제약하는 방법을 찾아야한다.
        MyCircularDeque2 deque = new MyCircularDeque2(3);
        System.out.println(deque.insertLast(1)); // return true
        System.out.println(deque.insertLast(2)); // return true
        System.out.println(deque.insertFront(3)); // return true
        System.out.println(deque.insertFront(4)); // return false
        System.out.println(deque.deleteLast()); // return true
        System.out.println(deque.getRear()); // return 1
        System.out.println(deque.isFull()); // return false
        System.out.println(deque.deleteLast()); // return true
        System.out.println(deque.insertFront(4)); // return true
        System.out.println(deque.getFront()); // return 4

    }


}
