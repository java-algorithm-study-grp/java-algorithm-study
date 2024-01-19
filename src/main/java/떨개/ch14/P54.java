package 떨개.ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P54 {

    public static void main(String[] args) {
        // Ch14. 트리
        //  - 54. 최소 높이 트리
        //   1) 노드 개수와 무방향 그래프를 입력받아 트리가 최소 높이가 되는 루트의 목록을 리턴하라.
        //      각 노드는 0부터 n-1까지, n만큼 존재한다.
        //    - input1: n = 7, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 3], [6, 5]]
        //    - output1: [3,  5]
        //    - input2: n = 10, edges = [[0, 2], [1, 2], [2, 3], [2, 4], [3, 5], [5, 9], [4, 6], [4, 7], [7, 8]]
        //    - output2: [2]

        // int n = 7;
        // int[][] edges = new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 3}, {6, 5}};
        int n = 10;
        int[][] edges = new int[][] {{0, 2}, {1, 2}, {2, 3}, {2, 4}, {3, 5}, {5, 9}, {4, 6}, {4, 7}, {7, 8}};

        System.out.println(findMinHeightTrees(n, edges));
    }

    private static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // 1. 리프노드
        //  - 처음에 리프노드에 대한 설명을 보고 책까지 확인하게 되었으나
        //    이 후, 이해 후 제대로 지우고 작성까지 완료했습니다... 다시 공부.

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 리프 노드: 연결이 하나뿐인 노드 상태, 가장 바깥쪽에 있을만한 노드 형태
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(graph.get(i).size() == 1) leaves.add(i);

        // 루프 노드(2개 이하)만 남을 때까지 반복 제거
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove(leaf);
                if(graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
