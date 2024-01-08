package 승재.ch13;

public class P44 {

    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] rows : times) {
            //time가 그래프이며
            graph[rows[0] - 1][rows[1] - 1] = rows[2];
        }

        int[] distance = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[K - 1] = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int index = minIndex(distance, visited);
            if (index == -1) {
                continue;
            }

            visited[index] = true;
            for (int j = 0; j < n; j++) {
                if (graph[index][j] != Integer.MAX_VALUE) {
                    int newDist = graph[index][j] + distance[index];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                    }
                }
            }
        }
        int result = 0;

        for (int dist : distance) {
            if (dist == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dist);
        }
        return result;
    }

    private int minIndex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
