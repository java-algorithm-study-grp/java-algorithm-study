package 주앤.ch8;

import java.util.ArrayList;

/*
문제 : 234. Palindrome Linked List
시간 복잡도 : O(n)
실행시간 및 메모리 : 4 ms (80.44%)/ 58.12 MB (42.59%) -> 실행시간 빠름, 메모리 안좋아짐(배열 크기 초기화때문에 메모리 공간 낭비)
풀이 : P13_1 은 ArrayList에 담아서 팰린드롬을 조회했지만, 이번엔 배열에 담아서 조회함.
 */

public class P13_2 {
	public static boolean isPalindrome(ListNode head) {
		if(head.next == null){
			return true;
		}

		ListNode currentNode = new ListNode(head.val, head.next);
		int[] arr = new int[100000];
		int i = 0;

		while(currentNode != null){
			int currentVal = currentNode.val;
			arr[i] = currentVal;
			i++;

			currentNode = currentNode.next;
		}

		int start = 0;
		int end = i - 1;

		while(start < end){
			if(arr[start] != arr[end]){
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
