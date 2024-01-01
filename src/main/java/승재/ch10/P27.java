package 승재.ch10;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import 승재.common.ListNode;

public class P27 {

    public ListNode mergeKLists(final ListNode[] lists) {

        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode root = new ListNode(0);
        ListNode tail = root;

        for (ListNode list : lists) {
            if (list != null) {
                q.offer(list);
            }
        }

        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;

            if (tail.next != null) {
                q.offer(tail.next);
            }
        }

        return root.next;
    }

}
