package 원석.ch8;

public class P14 extends ListNode {
    P14(int val) {
        super(val);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 기저 사례: 둘 중 하나가 비어 있으면 다른 리스트를 반환
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 현재 노드 값 비교
        if (list1.val < list2.val) {
            // list1의 값이 더 작은 경우
            // list1의 다음 노드와 list2를 재귀적으로 병합
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // list2의 값이 더 작거나 같은 경우
            // list2의 다음 노드와 list1을 재귀적으로 병합
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String args[]) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList1 = mergeTwoLists(list1, list2);
        printList(mergedList1);
    }

}
