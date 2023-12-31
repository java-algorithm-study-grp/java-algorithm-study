package 떨개.Object;

public class MyCircularDeque1 {

    int length;
    int k;
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public MyCircularDeque1(int k) {
        // 데크 크기를 k로 지정하는 생성자
        // 이중 연결 리스트
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        // 서로 연결
        head.right = tail;
        tail.left = head;
        // 전체 큐 크기 지정
        this.k = k;
        // 현재 큐 크기 지정
        this.length = 0;
    }

    public boolean insertFront(int value) {

        if(isFull())
            return false;

        DoublyLinkedList node = new DoublyLinkedList(value);
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
        length++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;

        DoublyLinkedList node = new DoublyLinkedList(value);
        node.left = head.left;
        node.right = tail;
        tail.left.right = node;
        tail.left = node;
        length++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty())
            return false;
        // head 바로 오른쪽 노드를 연결에서 끊음
        head.right.right.left = head;
        head.right = head.right.right;
        length--;

        return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;
        // tail 바로 왼쪽 노드를 연결에서 끊음
        tail.left.left.right = tail;
        tail.left = tail.left.left;
        length--;

        return true;
    }

    public int getFront() {
        return (isEmpty()) ? -1 : head.right.val;
    }

    public int getRear() {
        return (isEmpty()) ? -1 : tail.left.val;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == k;
    }

    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int val;

        public DoublyLinkedList(int val) {
            this.val = val;
        }
    }
}
