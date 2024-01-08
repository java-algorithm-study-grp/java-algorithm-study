package 원석.ch13;

import java.util.*;

public class P44 {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        // 시간 배열에 따른 그래프 형성
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], key -> new HashMap<>()).put(time[1], time[2]);
        }

        // Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        Map<Integer, Integer> distances = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if (distances.containsKey(node)) {
                continue;
            }

            distances.put(node, distance);

            Map<Integer, Integer> neighbors = graph.getOrDefault(node, new HashMap<>());
            for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                int neighbor = entry.getKey();
                int weight = entry.getValue();

                if (!distances.containsKey(neighbor)) {
                    pq.offer(new int[]{neighbor, distance + weight});
                }
            }
        }

        // 모든 노드가 신호를 받았는지 확인
        if (distances.size() != n) {
            return -1;
        }

        // 모든 노드 중 가장 오래 걸리는 시간 파악
        int maxTime = 0;
        for (int distance : distances.values()) {
            maxTime = Math.max(maxTime, distance);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        P44 solution = new P44();

        // Example 1
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n1 = 4, k1 = 2;
        System.out.println(solution.networkDelayTime(times1, n1, k1));

        // Example 2
        int[][] times2 = {{1, 2, 1}};
        int n2 = 2, k2 = 1;
        System.out.println(solution.networkDelayTime(times2, n2, k2));

        // Example 3
        int[][] times3 = {{1, 2, 1}};
        int n3 = 2, k3 = 2;
        System.out.println(solution.networkDelayTime(times3, n3, k3));
    }
}