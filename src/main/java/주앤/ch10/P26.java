package 주앤.ch10;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 문제 : 641. Design Circular Deque
 * 핵심 : Deque 를 구현한 LinkedList 사용하여 구현. 자바에서 LinkedList는 계속해서 데이터를 늘릴 수 있는 점이 문제의 요구사항과 조금 달랐다.
 **/
public class P26 {
    class MyCircularDeque {
        private Deque<Integer> deque;
        private int len = 0;

        public MyCircularDeque(int k) {
            deque = new LinkedList<>();
            len = k;
        }

        public boolean insertFront(int value) {
            if(deque.size() == this.len){
                return false;
            }
            return deque.offerFirst(value);
        }

        public boolean insertLast(int value) {
            if(deque.size() == this.len){
                return false;
            }
            return deque.offerLast(value);
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            return deque.pollFirst() >= 0 ? true : false;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            return deque.pollLast() >= 0 ? true : false;
        }

        public int getFront() {
            return isEmpty() ? -1 : deque.peekFirst();
        }

        public int getRear() {
            return isEmpty() ? -1 : deque.peekLast();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public boolean isFull() {
            return deque.size() == this.len;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
