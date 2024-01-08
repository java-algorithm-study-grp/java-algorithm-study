package 주앤.ch13;

import java.util.PriorityQueue;
/*
문제 : 743. Network Delay Time
핵심 : 다익스트라 알고리즘을 구현하는 기본 문제. 최단 거리로 모든 노드를 탐색하고, 가장 긴 시간을 반환한다. 만약, 모든 노드 중에 INF인 값이 있다면 -1을 반환한다.
 */
public class P44 {
    static final int INF = 987654321;

    public static int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0, k-1});

        int[] distance = new int[n];
        for(int i = 0; i < n; i++){
            distance[i] = INF;
        }
        distance[k-1] = 0;

        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) graph[i][j] = 0;
                else       graph[i][j] = INF;
            }
        }

        boolean[] visited = new boolean[n];

        // 노드 간 인접 관계 추가
        for(int[] a : times){
            graph[a[0]-1][a[1]-1] = a[2];
        }

        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int u = polled[1];
            if(visited[u] == true) continue;

            visited[u] = true;
            // u노드가 가리키는 인접한 v노드 탐색
            for(int v = 0; v < n; v++){
                if(distance[v] > distance[u] + graph[u][v]){
                    distance[v] = distance[u] + graph[u][v];
                    pq.offer(new int[]{distance[v], v});
                }
            }
        }

        int max = 0;
        for(int d : distance){
            if(d == INF) return -1;

            if(d > max){
                max = d;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
        networkDelayTime(new int[][]{{1,2,1}}, 2, 1);
        networkDelayTime(new int[][]{{1,2,1}}, 2, 2);
    }
}
