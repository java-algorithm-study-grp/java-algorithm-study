package 주앤.ch8;

import java.util.ArrayList;

/*
문제 : 234. Palindrome Linked List
시간 복잡도 : O(n)
실행시간 및 메모리 : 8 ms (27.50%)/ 54.5 MB (99.81%) -> 실행시간 느림, 메모리 좋음
어려웠던 점 및 해결 과정 : 단방향 연결리스트이기 때문에, 다른 배열이나 컬렉션을 사용하여 팰린드롬을 확인해야겠다고 판단함.
결론, ArrayList에 담아서 팰린드롬 확인
 */

public class P13_1 {
	public static boolean isPalindrome(ListNode head) {
		if(head.next == null){
			return true;
		}

		ListNode currentNode = new ListNode(head.val, head.next);
		ArrayList<Integer> list = new ArrayList<>(100000);

		while(currentNode != null){
			int currentVal = currentNode.val;
			list.add(currentVal);

			currentNode = currentNode.next;
		}

		int start = 0;
		int end = list.size() - 1;

		while(start < end){
			if(list.get(start) != list.get(end)){
				return false;
			}
			start++;
			end--;
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
