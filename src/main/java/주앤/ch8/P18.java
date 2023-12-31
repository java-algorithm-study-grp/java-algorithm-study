package 주앤.ch8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 : 328. Odd Even Linked List
 * 해결 과정 : 홀수 순서는 다음 홀수 순서를 바라보게 하고, 짝수 순서도 다음 짝수 순서를 바라보게 하면서, 기존의 하나로 연결된 것을 끊어내며,
 * 결국 하나의 홀수 연결 리스트와 짝수 연결 리스트를 만들어, 마지막 홀수 연결 리스트의 노드가 짝수 연결 리스트의 헤드 노드를 담는다.
 * 
 * 풀지 못한 이유 : 위의 설계까지는 동일하게 하였으나, 기존에는 head에 head.next를 담아 하나씩 순회하여 현재노드의 다다음노드를 가리키게 하는 방식으로 구현했더니, 서로의 노드가 결국 끊어지지 않는 문제가 발생했다.
 * 순회를 할 때, 한 가지씩만 해야 한다는 편견을 버려야 할 것 같다.
 */
public class P18 {
	public ListNode oddEvenList(ListNode head) {

		Queue<Integer> q = new LinkedList<>();

        if(head == null){ // 노드가 null이면, null 반환
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
