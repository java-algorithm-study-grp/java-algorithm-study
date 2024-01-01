package 떨개.Object;

import java.util.Deque;
import java.util.LinkedList;

public class MyCircularDeque2 {

    // Deque를 사용하는 방법

    int k;
    Deque<Integer> deque = new LinkedList<>();

    public MyCircularDeque2(int k) {
        // 데크 크기를 k로 지정하는 생성자
        this.k = k;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        return deque.offerFirst(value);
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        return deque.offerLast(value);
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        return deque.pollFirst() != null;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        return deque.pollLast() != null;
    }

    public int getFront() {
        return deque.getFirst() == null ? -1 : deque.getFirst();
    }

    public int getRear() {
        return deque.getLast() == null ? -1 : deque.getLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == k;
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
