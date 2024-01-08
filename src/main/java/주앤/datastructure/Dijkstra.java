package 주앤.datastructure;

import java.util.PriorityQueue;

public class Dijkstra {
    static final int INF = 987654321;
    static final int MAX_N = 10;
    static int N,E;
    static int[][] graph;
    static int[] distance;

    static void dijkstra(int src){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]); // 우선순위큐에 int[시작점부터 특정 노드까지의 최단 거리,특정 노드]를 담음
        boolean[] visited = new boolean[MAX_N]; // 각 노드 방문 여부
        for(int i = 0; i < N; i++) distance[i] = INF; // 모든 최단거리를 무한으로 설정
        distance[src] = 0; // 시작노드에서 시작노드까지의 최단 거리 0
        pq.add(new int[]{0, src});

        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int u = polled[1];
            if(visited[u] == true) continue;

            visited[u] = true;
            for(int v = 0 ; v < N; v++){
                if(distance[v] > distance[u] + graph[u][v]){
                    distance[v] = distance[u] + graph[u][v];
                    pq.add(new int[]{distance[v], v}); // 특정노드까지의 최단거리와 특정노드에서 v노드까지의 거리를 합한게 기존 v까지의 최단거리보다 짧으면, 특정노드와 v까지의 최단거리를 우선순위큐 등록.
                }
            }
        }


    }

    static void addCost(int u, int v, int cost){
        graph[u][v] = cost;
        graph[v][u] = cost; // 양방향 그래프인 경우에만 추가
    }

    public static void main(String[] args) {
        N = 6;
        E = 9;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) graph[i][j] = 0;
                else       graph[i][j] = INF;
            }
        }

        addCost(0,1,50);
        addCost(0,2,30);
        addCost(1,3,30);
        addCost(1,4,70);
        addCost(2,3,20);
        addCost(2,4,40);
        addCost(3,4,10);
        addCost(3,5,80);
        addCost(4,5,30);

        dijkstra(0);
        
        for(int i = 0; i < N; i++){
            System.out.println("distance[i] = " + distance[i]);
        }
    }

}
