package 승재.ch8;

import java.util.Stack;

public class P15 {


    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val;
     * } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode root = new ListNode();
        ListNode node = root;

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            ListNode nowNode = new ListNode();
            nowNode.val = stack.pop();

            root.next = nowNode;
            root = root.next;
        }

        return node.next;
    }
}
