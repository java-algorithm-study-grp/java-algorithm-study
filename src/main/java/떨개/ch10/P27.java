package 떨개.ch10;

import 떨개.Object.ListNode;

import java.util.*;

public class P27 {

    public static void main(String[] args) {
        // Ch10. 데크, 우선순위 큐
        //  - 27. k개 정렬 리스트 병합
        //   1) k개의 정렬된 리스트를 1개의 정렬된 리스트로 병합하라.

        int[][] arr = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 7}};
        ListNode[] nodes =
                new ListNode[]{ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 7)};

        System.out.println(answer1(arr));
        System.out.println(answer2(nodes));

    }

    private static List<Integer> answer1(int[][] arr) {

        // 1. PriorityQueue와 출력 List를 이용한 풀이 방식
        //  - 스스로 품.

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 해당 정렬 상태는 오름차순.

        for (int[] ints : arr) {
            for (int v : ints) {
                priorityQueue.offer(v);
            }
        }

        List<Integer> answer = new ArrayList<>();

        while(!priorityQueue.isEmpty()) {
            answer.add(priorityQueue.poll());
        }

        return answer;
    }

    private static ListNode answer2(ListNode[] nodes) {

        // 2. PriorityQueue와 출력 ListNode를 이용한 풀이 방식
        //  - 처음엔 이해가 잘 가지 않았으나 next를 계속 큐에 넣어 val의 우선순위를 정해
        //    계속 val 값이 우선순위에 맞춰져 나오는 것을 root.next로 보여주며 확인 할 수 있게 된다.

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode root = new ListNode(0);
        ListNode tail = root;

        // 각 연결 리스트의 첫 번째 노드를 큐에 저장
        for (ListNode node : nodes) {
            if(node != null)
                pq.add(node);
        }

        // 큐가 모두 빌 때까지 반복
        while(!pq.isEmpty()) {
            // 우선순위에 따라 추출, 다음 노드로 이동
            tail.next = pq.poll();
            tail = tail.next;

            if(tail.next != null)
                pq.add(tail.next);
        }

        return root.next;
    }

}
