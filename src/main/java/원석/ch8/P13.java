package 원석.ch8;

import java.util.Deque;
import java.util.LinkedList;

public class P13 extends ListNode{
    P13(int val) {
        super(val);
    }

    public static boolean isPalindrome(ListNode head) {
        // 데크 선언
        Deque<Integer> deque = new LinkedList<>();

        // 연결 리스트의 값을 데크에 저장
        ListNode current = head;
        while (current != null) {
            deque.addLast(current.val);
            current = current.next;
        }

        // 양쪽에서 값을 하나씩 비교
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 예제 사용법:
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head1));  // 출력: true

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(isPalindrome(head2));  // 출력: false
    }
}
