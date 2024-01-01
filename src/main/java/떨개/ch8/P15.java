package 떨개.ch8;

import 떨개.Object.ListNode;

import java.util.LinkedList;
import java.util.List;

public class P15 {

    public static void main(String[] args) {
        // Ch08. 연결 리스트
        //  - 15. 역순 연결리스트
        //   1) 연결리스트를 뒤집어라.
        //   ex : 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //        6 -> 5 -> 4 -> 3 -> 2 -> 1
        List<Integer> list = new LinkedList<>(List.of(1, 2, 4, 3, 5, 6));
        ListNode node = ListNode.of(1, 5, 4, 3, 2, 6);

        System.out.println(reverse1(list));
        // System.out.println(reverse2(node));
        System.out.println(reverseList(node));
    }

    private static List<Integer> reverse1(List<Integer> list) {

        // 1. List를 역순하는 방법 1
        //  - 스스로 생각한 것.
        //  - 너무 단순하게 List를 역순하는 for문을 통해 output이라는 출력용 List를 리턴했다.
        List<Integer> output = new LinkedList<>();

        for(int i = list.size() - 1; i >= 0; i--) {
            output.add(list.get(i));
        }

        return output;
    }

    private static ListNode reverse2(ListNode node) {

        // 2. ListNode를 역순하는 방법 1
        //  - 책을 보게 된 내용. 반복문을 통한 역순 진행.
        ListNode output = null, origin = node;

        while(origin != null) {
            // 현재 노드의 다음 노드 미리 지정.
            ListNode next = origin.next;

            // 현재 노드 다음으로 이전 노드 지정
            origin.next = output;

            // 이전 노드는 현재 노드로 지정
            output = origin;

            // 미리 지정했던 다음 노드를 현재 노드로 변경
            origin = next;

        }

        return output;
    }

    private static ListNode reverse3(ListNode node, ListNode prev) {
        // 2. ListNode를 역순하는 방법 2
        //  - 책을 보게 된 내용. 재귀를 통한 역순 진행.
        //  - 이해는 되나, 이 방법이 떠오르지 않아서 많이 풀어봐야 합니다.

        // 현재 노드가 null이면 리턴 처리.
        if(node == null) return prev;

        // 현재 노드의 다음 노드 미리 지정.
        ListNode next = node.next;

        // 현재 노드의 다음으로 이전 노드 지정.
        node.next = prev;

        // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출.
        return reverse3(next, node);
    }

    private static ListNode reverseList(ListNode node) {
        return reverse3(node, null);
    }

}
