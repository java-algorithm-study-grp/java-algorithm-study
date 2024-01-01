package 승재.ch8;

import java.util.Stack;
import 승재.common.ListNode;

public class P13 {

    public boolean isPalindrome(ListNode head) {
        final Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
