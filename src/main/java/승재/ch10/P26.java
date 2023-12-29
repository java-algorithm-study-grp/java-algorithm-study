package 승재.ch10;

import java.util.Deque;
import java.util.LinkedList;

public class P26 {
    Deque<Integer> d;
    int size;


    public P26(int k) {
        d = new LinkedList<>();
        size = k;

    }

    public boolean insertFront(int value) {
        if (d.size() < size) {
            d.addFirst(value);
            return true;
        }
        return false;

    }

    public boolean insertLast(int value) {
        if (d.size() < size) {
            d.addLast(value);
            return true;
        }
        return false;

    }

    public boolean deleteFront() {
        if (!d.isEmpty()) {
            d.removeFirst();
            return true;
        }
        return false;

    }

    public boolean deleteLast() {
        if (!d.isEmpty()) {
            d.removeLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        if (d.isEmpty()) {

            return -1;
        }
        return d.getFirst();
    }

    public int getRear() {
        if (d.isEmpty()) {

            return -1;
        }
        return d.getLast();

    }

    public boolean isEmpty() {
        return d.isEmpty();
    }

    public boolean isFull() {
        return d.size() == size;
    }
}
