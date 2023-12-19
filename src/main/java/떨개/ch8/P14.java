package 떨개.ch8;

import 떨개.Object.ListNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class P14 {

    public static void main(String[] args) {
        // Ch08. 연결 리스트
        //  - 13. 두 정렬 리스트의 병합
        //   1) 정렬되어 있는 두 연결 리스트를 합쳐라.
        //  - 12번 문제에서 ListNode에 대해서 알게 되었으므로 LeetCode에서 사용하는 ListNode를 적극적으로 사용해보자.

        ListNode node1 = ListNode.of(1, 2, 5);
        ListNode node2 = ListNode.of(1, 3, 4);
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 5));
        List<Integer> list2 = new ArrayList<>(List.of(1, 3, 4));

        Long start1 = System.currentTimeMillis();
        System.out.println(mergeTwoNodes1(node1, node2).toString());
        Long end1 = System.currentTimeMillis();
        System.out.println("second1 = " + (end1 - start1));

        Long start2 = System.currentTimeMillis();
        System.out.println(mergeTwoNodes2(list1, list2));
        Long end2 = System.currentTimeMillis();
        System.out.println("second1 = " + (end2 - start2));
    }

    private static ListNode mergeTwoNodes1(ListNode node1, ListNode node2) {

        // 1. 재귀 구조로 연결
        //  - 책을 보고, 바로 이해했음.
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        if(node1.val < node2.val) {
            // System.out.println("1 node1 = " + node1.toString());
            // System.out.println("1 node2 = " + node2.toString());
            node1.next = mergeTwoNodes1(node1.next, node2);
            return node1;
        } else {
            // System.out.println("2 node1 = " + node1.toString());
            // System.out.println("2 node2 = " + node2.toString());
            node2.next = mergeTwoNodes1(node1, node2.next);
            return node2;
        }


    }

    private static List<Integer> mergeTwoNodes2(List<Integer> list1, List<Integer> list2) {

        // 2. ListNode가 아닌 List 형식으로 구현
        //  - 다른 코드문제에서는 ListNode를 주는 것이 아니기 때문에 이를 실현해보자.
        // System.out.println("list1 = " + list1 + " list2 = " + list2);

        list1.addAll(list2);

        // System.out.println("list1 = " + list1);
        // list1.sort((o1, o2) -> o1.compareTo(o2)); // 람다식, 람다식으로 쓸 때 Comparator.naturalOrder()를 추천하고 있다.
        list1.sort(Comparator.naturalOrder());

        return list1;
    }

}
