package 떨개.ch17;

import 떨개.Object.ListNode;

public class P64 {

    public static void main(String[] args) {
        // Ch17. 정렬
        //  - 64. 리스트 정렬
        //   1) 연결 리스트를 O(nlogn)에 정렬하라.
        //  - input1: {-1, 5, 3, 4, 0}
        //  - output1: {-1, 0, 3, 4, 5}
        ListNode node = ListNode.of(-1, 5, 3, 4, 0);

        System.out.println(node);

        System.out.println(sortList1(node));
        System.out.println(sortList2(node));
    }

    private static ListNode sortList1(ListNode node) {

        // 1. 병합정렬
        //  - 이해가 잘 되지 않아 책을 보면서 풀이
        //  - 나중에 다시 확인하면서 풀어볼 예정.

        if(node == null || node.next == null) return node;

        // 러너 기법 활용, 빠른 노드가 끝까지 갈 때 느린(slow) 노드는 중간까지 이동한다.
        ListNode half = null, slow = node, fast = node;
        while(fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // head를 시작으로 하는 노드와 slow를 시작하는 노드의 연결고리를 끊는다.
        half.next = null;

        // 분할(divide) 재귀 호출, 각 노드는 거듭된 분할의 결과로 더 이상 쪼갤 수 없는 단위까지 분할된다.
        ListNode l1 = sortList1(node);
        ListNode l2 = sortList1(slow);

        mergeTwoLists(l1, l2);

        return node;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // 앞 노드의 값이 더 크다면 스왑 진행
        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        // 앞 노드의 다음 결과는 재귀로 처리한 결과 지정
        l1.next = mergeTwoLists(l1.next, l2);
        // l1 쪽으로 작은 노드를 스왑하므로 l1 리턴
        return l1;
    }

    private static ListNode sortList2(ListNode node) {
        // 2. 퀵 정렬
        //  - 정렬을 구현하는것이니 책을 참고로 코드를 작성.
        //  - 좀 더 이해를 해보고 스스로 풀어보도록 노력해야할 거 같습니다.

        // 연결 리스트의 마지막은 널이므로 tail을 null로 하여 호출
        quicksort(node, null);

        return node;
    }

    private static void quicksort(ListNode head, ListNode tail) {
        // 단일 노드일 때는 그냥 리턴
        if(head == tail) return;
        // 연결 리스트이기 때문에 로무토 파티션이 아닌 이상 편의상 첫 번째 노드를 피벗으로 선택
        ListNode pivot = head;
        // 왼쪽 포인터는 첫 번째 노드
        ListNode left = head;
        // 오른쪽 포인터는 그 다음 노드
        ListNode right = head.next;

        // 오른쪽 포인터가 맨 끝에 도달할 때까지 진행
        while(right != tail) {
            if(right.val < pivot.val) {
                // 왼쪽 포인터 진행
                left = left.next;
                // 스왑, 연결 리스트이므로 노드 처리를 단순한게 하기 위해 값만 교환
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }
            // 오른쪽 포인터 진행
            right = right.next;
        }
        // 피벗과 왼쪽 포인터 값 교환, 피벗은 첫 번째 노드
        int temp = head.val;
        head.val = left.val;
        left.val = temp;

        // 왼쪽 포인터를 중심으로 분할하여 재귀 호출
        quicksort(head, left);
        quicksort(left.next, tail);
    }

}
