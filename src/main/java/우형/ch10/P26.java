package src.main.java.우형.ch10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//leetcode 641
public class P26 {

    class MyCircularDeque {

        Deque<Integer> deque;
        int size;


        public MyCircularDeque(int k) {
            deque = new ArrayDeque<>();
            size = k;
        }

        public boolean insertFront(int value) {
            //isFull check
            if (isFull())
                return false;
            deque.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull())
                return false;
            deque.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty())
                return false;
            deque.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty())
                return false;
            deque.removeLast();
            return true;
        }

        public int getFront() {
            if (isEmpty())
                return -1;
            return deque.getFirst();
        }

        public int getRear() {
            if (isEmpty())
                return -1;
            return deque.getLast();

        }

        public boolean isEmpty() {
            if (deque.isEmpty())
                return true;
            return false;
        }

        public boolean isFull() {
            if (deque.size() == size) {
                return true;
            }
            return false;
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
