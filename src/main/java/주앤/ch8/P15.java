package 주앤.ch8;

/**
 * 문제 : 206. Reverse Linked List
 * 실행시간 및 메모리 : 0 ms / 42.8 MB
 * 풀이 : 반복문을 돌며 기존 연결 리스트의 head 노드를 조작하여 역순 연결 리스트에 담는다.
 * 1. 기존 연결 리스트의 head의 next로 역순 연결 리스트의 head 인스턴스를 가리키게 하고,
 * 2. 역순 연결리스트의 head 위치에는 기존 연결 리스트의 head를 담는다.
 */
public class P15 {
	public ListNode reverseList(ListNode head) {
		// 역순 연결 리스트의 head
		ListNode reverse = null;

		// 기존 연결 리스트의 head
		ListNode current = head;

		while(current != null){
			// 다음 반복에서 사용해야 할 노드 저장
			ListNode nextTurn = current.next;

			current.next = reverse;
			reverse = current;


			// 기존 순서에 따른 다음 노드를 현재 노드에 가져옴.
			current = nextTurn;
		}

		return reverse;
	}

	public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
