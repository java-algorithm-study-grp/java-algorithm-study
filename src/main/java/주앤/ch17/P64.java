package 주앤.ch17;

import java.util.Arrays;

/*
문제 : L148.리스트 정렬 (시간복잡도 제한: O(nlogn))
풀이 : [chatGPT&책 참고] 병합정렬
못 푼 이유 : 처음엔 ArrayList에 인덱스를 넣어서 배열로 병합정렬을 구현하였더니, 시간초과가 떴다.
		이는 새로운 ArrayList 객체를 계속 생성하고 데이터를 넣는 부분에서 발생하는 에러였다.

		listNode 에 아직 익숙하지 않아서, 중간값을 찾는 방법을 몰랐는데, 풀이를 참고하니, slow-fast로 중간값 혹은 그 근사치를 구하는 것이 생각났다.
		단방향 연결리스트에 더 익숙해져야겠다.

 */
public class P64 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// 중간 노드 찾기
		ListNode mid = findMid(head);
		ListNode midHead = mid.next;
		// 중간 노드의 연결 고리 끊기
		mid.next = null;

		ListNode sortedFirstHalf = sortList(head);
		ListNode sortedSecondHalf = sortList(midHead);

		return merge(sortedFirstHalf, sortedSecondHalf);
	}

	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode merge(ListNode head, ListNode midHead) {
		ListNode dummy = new ListNode();
		ListNode current = dummy;

		while (head != null && midHead != null) {
			if (head.val < midHead.val) {
				current.next = head;
				head = head.next;
			} else {
				current.next = midHead;
				midHead = midHead.next;
			}
			current = current.next;
		}
		if (head != null) {
			current.next = head;
		}
		if (midHead != null) {
			current.next = midHead;
		}

		return dummy.next;
	}
}
