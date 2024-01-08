package 떨개.ch13;

import java.util.*;

public class P44 {

    public static void main(String[] args) {
        // Ch13. 최단 경로 문제
        //  - 41. 네트워크 딜레이 타임
        //   1) k에서 출발해 모든 노드가 신호를 받을 수 있는 시간을 계산하라. 한 군데라도 노드에 도달할 수 없는 경우
        //      -1을 리턴한다. 입력값 (u, v, w)는 각각 출발지, 도착지, 소요 시간으로 구성되며 전체 노드의 개수는 n이다.
        //    -> 모든 노드가 신호를 받는 데 걸리는 시간 => 가장 오래 걸리는 노드까지의 시간???
        //    input1:
        //     times = [[3,1,5], [3,2,2], [2,1,2], [3,4,1], [4,5,1], [5,6,1], [6,7,1], [7,8,1], [8,1,1]], n = 8, k = 3
        //    output1: 5
        //    input2: times = [[1,2,1]], n = 2, k = 2
        //    output2: -1
        int[][] times = new int[][] {{3,1,5}, {3,2,2}, {2,1,2}, {3,4,1}, {4,5,1}, {5,6,1}, {6,7,1}, {7,8,1}, {8,1,1}};
        int n = 8, k = 3;
        // int[][] times = new int[][] {{1,2,1}};
        // int n = 2, k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }

    private static int networkDelayTime(int[][] times, int n, int k) {

        // 1. 다익스트라 알고리즘
        //  - 정보 및 꿀팁에 올려주신 Graph 링크를 통해 다익스트라 알고리즘에 대한 설명이 있는데
        //    거기에 사용된 Node와 Graph 개념을 이용하려고 합니다.
        //  - times[i][0]: 시작점, times[i][1]: 종료점, times[i][2]: 걸리는 시간
        //  - 결국 풀이책을 보고 이해하는 중.
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        System.out.println("graph = " + graph);

        // 우선순위 큐 생성, 값이 (도착지, 소요 시간)으로 구성되므로
        // 정렬 기준은 도착지(key)와 소요 시간(value) 중 소요 시간을 기준으로 한다.
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        // (도착지, 소요시간) 최종 결과를 저장하는 변수 선언
        Map<Integer, Integer> dist = new HashMap<>();

        // 큐에 값이 남아 있다면 없어질 때까지 반복
        while(!pq.isEmpty()) {
            // 소요 시간이 가장 빠른 값 추출
            Map.Entry<Integer, Integer> cur = pq.poll();

            int u = cur.getKey(); // 다음 도착지
            int dist_u = cur.getValue(); // 소요 시간

            // u 지점까지의 소요 시간이 아직 계산되지 않았다면 처리 시작
            if(!dist.containsKey(u)) {
                // u 지점까지의 소요 시간(dist_u)을 결과 변수에 삽입
                dist.put(u, dist_u);

                // u 지점을 출발지로 한 경로가 있다면 처리 시작
                if(graph.containsKey(u)) {
                    // u 지점을 출발지로 한 모든 경로 순회
                    for(Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // u 지점까지의 소요 시간(dist_u) + u 지점을 출발지로 한 도착지까지의 소요 시간
                        int alt = dist_u + v.getValue();

                        // 우선 순위 큐에 (도착지, 소요 시간)을 삽입
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));

                        System.out.println("v.getKey = " + v.getKey() + " pq = " + pq);
                    }
                }
            }
        }

        System.out.println("dist = " + dist);

        // 결과 변수가 노드의 수와 같다면 모든 노드의 소요 시간을 측정했고, 도달 가능하다는 의미
        if(dist.size() == n) {
            return Collections.max(dist.values());
        }

        return -1;
    }
}
