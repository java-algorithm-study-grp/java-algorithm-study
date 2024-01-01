package 지은.ch10;

import java.util.Deque;
import java.util.LinkedList;
/*
Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.

Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4


Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
 */

public class P26 {

    class MyCircularDeque {

        Deque<Integer> deque;
        int size;

        public MyCircularDeque(int k) {
            deque = new LinkedList<>();
            size = k;
        }

        public boolean insertFront(int value) {
            if (deque.size() == size) {
                return false;
            }
            deque.offerFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (deque.size() == size) {
                return false;
            }
            deque.offer(value);
            return true;
        }

        public boolean deleteFront() {
            if (deque.isEmpty()) {
                return false;
            }
            deque.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (deque.isEmpty()) {
                return false;
            }
            deque.removeLast();
            return true;
        }

        public int getFront() {
            if (!deque.isEmpty()) {
                return deque.getFirst();
            }
            return -1;
        }

        public int getRear() {
            if (deque.isEmpty()) {
                return deque.getLast();
            }
            return -1;
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public boolean isFull() {
            return deque.size() == size;
        }
    }

    class MyCircularDeque2 {
        class DoublyLinkedList {
            DoublyLinkedList left;
            DoublyLinkedList right;
            int val;

            public DoublyLinkedList (int val) {
                this.val = val;
            }
        }

        int len;
        int k;
        DoublyLinkedList head;
        DoublyLinkedList tail;

        public MyCircularDeque2(int k) {
            this.k = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = new DoublyLinkedList(value);
                tail = head;
            } else {
                DoublyLinkedList node = new DoublyLinkedList(value);
                head.left = node;
                node.right = head;
                head = node;
            }
            len++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()){
                head = new DoublyLinkedList(value);
                tail = head;
            } else {
                DoublyLinkedList node = new DoublyLinkedList(value);
                tail.right = node;
                node.left = tail;
                tail = node;
            }
            len++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            if (len == 1) {
                head = null;
                tail = null;
            } else {
                head = head.right;
                head.left = null;
            }
            len--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            if (len == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.left;
                tail.right = null;
            }
            len--;
            return true;
        }

        public int getFront() {
            if (len == 0) {
                return -1;
            }
            return head.val;
        }

        public int getRear() {
            if (len == 0) {
                return -1;
            }
            return tail.val;
        }

        public boolean isEmpty() {
            return len == 0;
        }

        public boolean isFull() {
            return len == k;
        }
    }

}
