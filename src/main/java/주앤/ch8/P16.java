package 주앤.ch8;

/**
 * 문제 : 2. Add Two Numbers
 * 실행시간 및 메모리 : 1 ms /44.4 MB
 * 풀이 : 연결 리스트로 표현된 두 개의 숫자를 더하는 함수를 구현한 것으로, 주어진 두 개의 연결 리스트 l1과 l2를 이용하여 각 자릿수별로 덧셈을 수행하고 그 결과를 새로운 연결 리스트로 반환
 */
public class P16 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 결과 연결 리스트를 만들기 위한 노드
		ListNode node = new ListNode(0);
		// 결과 연결 리스트의 head를 저장하기 위한 노드
		ListNode result = node;
		// 1 더하기가 필요한 지 여부
		boolean hasPlus = false;

		while(l1 != null || l2 != null || hasPlus){
			int sumVal = 0;

			// l1이 존재하면 합하기
			if(l1 != null){
				sumVal += l1.val;
				l1 = l1.next;
			}
			// l2가 존재하면 합하기
			if(l2 != null){
				sumVal += l2.val;
				l2 = l2.next;
			}

			// 1을 더해야 하면 더하고, 다음 반복에 더하기 필요 여부 false
			if(hasPlus){
				sumVal++;
				hasPlus = false;
			}

			// 합이 9를 초과하면, 합을 10으로 나눈 나머지를 저장하고, 다음 반복에 더하기 필요 여부 true
			if(sumVal > 9){
				sumVal %= 10;
				hasPlus = true;
			}

			// 다음 노드에 새 노드를 생성하고 최종 연산된 값을 담음.
			node.next = new ListNode(sumVal);

			// 현재 노드를 다음 노드로 변경
			node = node.next;
		}

		// 첫 노드엔 연산하지 않았음으로, 다음 노드를 return
		return result.next;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode d = new ListNode(9);
		ListNode c = new ListNode(4,d);
		ListNode b = new ListNode(6, c);
		ListNode l2 = new ListNode(5, b);


		ListNode b1 = new ListNode(9);
		ListNode a1 = new ListNode(4,b1);
		ListNode l1 = new ListNode(2,a1);

		ListNode listNode = addTwoNumbers(l1, l2);

		while(listNode != null){
			System.out.println("listNode.val = " + listNode.val);
			listNode = listNode.next;
		}
	}
}
