package 주앤.ch8;

/*
문제 : 234. Palindrome Linked List
시간 복잡도 : O(n)
실행시간 및 메모리 : 3 ms / 57.3 MB
풀이 : [책] 러너를 이용한 우아한 풀이, 핵심은 느린 러너는 1씩 이동, 빠른 러너는 2씩 이동.
체감 난이도 : 5/5
 */

public class P13_4 {
	public static boolean isPalindrome(ListNode head) {
		if(head.next == null){
			return true;
		}

		ListNode fast = head, slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// 홀수 개일 때 느린 러너가 한 칸 더 앞으로 가도록 처리
		if (fast != null){ // fast.next == null인 경우
			slow = slow.next;
		}

		// 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만듦.
		ListNode rev = null;
		while( slow != null ){
			// 느린 러너로 역순 연결 리스트 rev를 만들어 간다.
			ListNode next = slow.next;
			slow.next = rev;
			rev = slow;
			slow = next;
		}


		// rev 연결 리스트를 끝까지 이동하며 비교
		while ( rev != null ){
			// 역순 연결 리스트 rev와 기존 연결 리스트 head를 차례대로 비교
			if(rev.val != head.val){
				return false;
			}
			rev = rev.next;
			head = head.next;
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
		ListNode b = new ListNode(1, c);
		ListNode a = new ListNode(1, b);

		boolean palindrome = isPalindrome(a);

		System.out.println("palindrome = " + palindrome);

	}
}
