package 승재.ch8;

public class P14 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode head = root;

        while (!(list1 == null && list2 == null)) {
            int val1 = defaultMaxValue(list1);
            int val2 = defaultMaxValue(list2);

            final ListNode nowNode = new ListNode();

            if (val1 <= val2) {
                nowNode.val = list1.val;
                list1 = list1.next;
            } else {
                nowNode.val = list2.val;
                list2 = list2.next;
            }

            root.next = nowNode;
            root = root.next;
        }

        return head.next;
    }

    private int defaultMaxValue(ListNode listNode) {
        if (listNode == null) {
            return 101; // 최대값이 100
        }

        return listNode.val;
    }
}
