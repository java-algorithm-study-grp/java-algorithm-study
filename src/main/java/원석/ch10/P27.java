package 원석.ch10;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P27 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 우선순위 큐를 사용하여 최소값을 빠르게 찾을 수 있도록 함
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // 모든 연결 리스트의 루트 노드를 우선순위 큐에 추가
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // 결과 연결 리스트의 가상 헤드 노드 생성
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 우선순위 큐가 비어 있을 때까지 루프 실행
        while (!minHeap.isEmpty()) {
            // 가장 작은 노드를 우선순위 큐에서 추출
            ListNode minNode = minHeap.poll();

            // 결과 연결 리스트에 현재 최소 노드를 추가
            current.next = minNode;
            current = current.next;

            // 추출한 노드의 다음 노드를 우선순위 큐에 추가
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next; // 가상 헤드 다음부터가 실제 결과 리스트
    }

    private static void test(ListNode[] lists) {
        P27 merger = new P27();
        ListNode result = merger.mergeKLists(lists);
        printlist(result);
        System.out.println();
    }

    private static void printlist(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }


    public static void main(String[] args) {
        ListNode[] lists1 = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
            };
        test(lists1);

        ListNode[] lists2 = new ListNode[]{};
        test(lists2);

        ListNode[] lists3 = new ListNode[]{new ListNode()};
        test(lists3);
    }
}