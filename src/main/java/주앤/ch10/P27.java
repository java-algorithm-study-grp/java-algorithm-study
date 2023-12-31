package 주앤.ch10;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 문제 : 23. Merge k Sorted Lists (우선순위 큐 활용 문제)
 * 핵심 : [책] 참고함. 우선순위 큐 학습
 * 	- Java의 PriorityQueue :
 *		- 생성자 호출할 때, 파라미터로 Comparator을 익명클래스나 람다식으로 구현하여 로 정렬기준을 정의할 수 있음.
 *		- null 은 값을 비교할 수 없기 때문에 저장할 수 없음
 *	- 우선순위 큐를 연상하는 방법 :
 *		- 연결리스트 & 정렬
 *
 **/
public class P27 {
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> q = new PriorityQueue<>((o1,o2)->
		{
			if(o1.val < o2.val){
				return -1;
			}
			return o1.val - o2.val;
		});

		// 각 연결리스트의 head를 우선순위 큐에 저장
		for(ListNode node : lists){
			if(node != null){
				q.offer(node);
			}
		}

		ListNode head = new ListNode(-1);
		ListNode result = head;
		while(!q.isEmpty()){
			ListNode polled = q.poll();

			if(polled.next != null){
				q.offer(polled.next);
			}

			head.next = new ListNode(polled.val);
			head = head.next;
		}


		return result.next;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
