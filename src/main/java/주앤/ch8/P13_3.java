package 주앤.ch8;

/*
문제 : 234. Palindrome Linked List
시간 복잡도 : O(n)
실행시간 및 메모리 : 10 ms (21.10%)/ 60.08 MB (21.09%) -> 둘 다 안좋음.
풀이 : Deque 사용
 */

import java.util.LinkedList;

public class P13_3 {
	public static boolean isPalindrome(ListNode head) {
		if(head.next == null){
			return true;
		}

		ListNode currentNode = new ListNode(head.val, head.next);
		LinkedList<Integer> list = new LinkedList<>();

		while(currentNode != null){
			list.add(currentNode.val);
			currentNode = currentNode.next;
		}

		while(list.size() > 1){
			if(list.pollFirst() != list.pollLast()){
				return false;
			}
		}

		return true;
	}


	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode d = new ListNode(1);
		ListNode c = new ListNode(0, d);
		ListNode b = new ListNode(0, c);
		ListNode a = new ListNode(1, b);

		boolean palindrome = isPalindrome(a);

		System.out.println("palindrome = " + palindrome);

	}
}
