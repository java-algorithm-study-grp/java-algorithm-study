package 주앤.ch13;

import java.util.PriorityQueue;

/*
문제 : 다익스트라 알고리즘 구현
    Q1. 특정 도착점까지 가중치 구하기
    Q2. 최대 가중치를 찾아 반환 (모든 경로를 탐색한 경우 최종 시간 구하기)
    Q3. 목표 방문 노드까지의 경로 구하기
핵심 : 다익스트라 알고리즘을 구현하는 기본 문제. 최단 거리로 모든 노드를 탐색하고, 가장 긴 시간을 반환한다. 만약, 모든 노드 중에 INF인 값이 있다면 -1을 반환한다.
 */
public class P44_활용 {

    // 상수 INF를 최대값으로 설정
    static final int INF = 987654321;
    static final int GOAL = 4;

    public static int networkDelayTime(int[][] times, int n, int k) {

        // 그래프의 인접 행렬을 생성하고 초기화
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(i == j) graph[i][j] = 0;
                else       graph[i][j] = INF;
            }
        }
        // 노드 간 인접 관계 추가
        for (int[] a : times){
            graph[a[0]-1][a[1]-1] = a[2];
        }

        // 각 노드까지의 가중치를 저장하는 배열 초기화
        int[] weight = new int[n];
        for (int i = 0; i < n; i++){
            weight[i] = INF;

        }
        weight[k-1] = 0; // 시작 노드 가중치 0

        // 우선순위 큐를 이용하여 최소 힙 구현
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0, k-1});

        // 방문 여부 배열 초기화
        boolean[] visited = new boolean[n];

        // 최단 방문 경로 저장
        int[] shortPath = new int[n];

        // 다익스트라 알고리즘 수행
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int u = current[1];

            // Q1. 특정 도착점까지 가중치 구하기
            if(u == GOAL){
                return current[0];
            }

            // 이미 방문한 노드는 건너뛰기
            if(visited[u] == true) continue;

            visited[u] = true;
            // 현재 노드 u에서 인접한 노드 v까지의 가중치 갱신
            for (int v = 0; v < n; v++){
                if(weight[v] > weight[u] + graph[u][v]){
                    weight[v] = weight[u] + graph[u][v];
                    pq.offer(new int[]{weight[v], v});

                    // Q3. 목표 방문 노드까지의 경로 구하기
                    shortPath[v] = u;
                }
            }
        }

        // Q2. 최대 가중치를 찾아 반환 (모든 경로를 탐색한 경우 최종 시간 구하기)
        int max = 0;
        for (int w : weight){
            if(w == INF) return -1;

            if(w > max){
                max = w;
            }
        }

        // Q3. 목표 방문 노드까지의 경로 구하기
        int curr = GOAL;
        while(curr != 0){
            System.out.print((curr + 1) + "<");
            curr = shortPath[curr];
        }

        return max;
    }

    public static void main(String[] args) {
        networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
        // networkDelayTime(new int[][]{{1,2,1}}, 2, 1);
        // networkDelayTime(new int[][]{{1,2,1}}, 2, 2);
    }
}
