package 주앤.ch10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 문제 : 641. Design Circular Deque
 * 핵심 : [책] 참고함. 이전 노드와 다음 노드의 상태를 가지는 DoubleLinkedNode 클래스를 생성하여, DoubleLinkedNode를 통해 서로 연결하여 덱을 생성함.
 * 이 때, 맨 앞 노드인 head와 맨 뒤 노드의 tail은 실제 덱의 앞과 뒤를 나타내는 것이 아니기 때문에 실제 head와 tail을 추출하고 싶다면 head.next와 tail.prev를 추출해야 함.
 **/
public class P26_2 {
    class MyCircularDeque {

        static class DoubleLinkedNode{
            private int value = -1;
            private DoubleLinkedNode prev;
            private DoubleLinkedNode next;

            public DoubleLinkedNode(){
            }

            public DoubleLinkedNode(int value){
                this.value = value;
            }

            public DoubleLinkedNode(int value, DoubleLinkedNode prev, DoubleLinkedNode next){
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }

        private DoubleLinkedNode head;
        private DoubleLinkedNode tail;
        private int len;
        private int currentLen;

        public MyCircularDeque(int k) {
            head = new DoubleLinkedNode(-1,null,tail);
            tail = new DoubleLinkedNode(-1,head,null);
            this.currentLen = 0;
            this.len = k;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }

            if(isEmpty()){
                DoubleLinkedNode node = new DoubleLinkedNode(value,this.head,this.tail);
                this.head.next = node;
                this.tail.prev = node;
            }else{
                // 실제 head는 오른쪽으로 옮기고, 실제 head에는 새 노드 삽입
                DoubleLinkedNode node = new DoubleLinkedNode(value,this.head,this.head.next);
                this.head.next.prev = node;
                this.head.next = node;
            }

            currentLen++;
            return true;

        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }

            if(isEmpty()){
                DoubleLinkedNode node = new DoubleLinkedNode(value,this.head,this.tail);
                this.head.next = node;
                this.tail.prev = node;
            }else{
                // 실제 tail은 왼쪽으로 옮기고, 실제 tail에는 새 노드 삽입
                DoubleLinkedNode node = new DoubleLinkedNode(value,this.tail.prev,this.tail);
                this.tail.prev.next = node;
                this.tail.prev = node;
            }

            currentLen++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            this.head.next.next.prev = this.head;
            this.head.next = this.head.next.next;

            this.currentLen--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }

            this.tail.prev.prev.next = this.tail;
            this.tail.prev = this.tail.prev.prev;


            this.currentLen--;
            return true;
        }

        public int getFront() {
            return this.head.next.value;
        }

        public int getRear() {
            return this.tail.prev.value;
        }

        public boolean isEmpty() {
            return this.currentLen == 0;
        }

        public boolean isFull() {
            return this.len == this.currentLen;
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
