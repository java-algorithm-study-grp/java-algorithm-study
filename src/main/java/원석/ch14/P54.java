package 원석.ch14;

import java.util.*;

class MHT {
    private int V; // node의 갯수

    // 인접 리스트
    private LinkedList<Integer>[] adj;

    private int[] degree;

    //생성자
    @SuppressWarnings("unchecked")
    public MHT(int v)
    {
        V = v;
        adj = new LinkedList[v];
        degree = new int[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) //
    {
        adj[v].add(w);
        adj[w].add(v);
        degree[v]++;
        degree[w]++;
    }

    // 최소 높이를 보장하는 트리의 루트를 반환하는 함수
    public LinkedList<Integer> rootForMinimumHeight()
    {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (degree[i] == 1)
                q.add(i);
        }

        // node의 총합이 2개 이하가 될 때까지
        while (V > 2) {
            int popEle = q.size();
            V -= popEle;

            for (int i = 0; i < popEle; i++) {
                int t = q.poll();

                for (int j : adj[t]) {
                    degree[j]--;
                    if (degree[j] == 1)
                        q.add(j);
                }
            }
        }
        
        LinkedList<Integer> res = new LinkedList<Integer>();
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }

    public static void main(String[] args)
    {
        MHT t = new MHT(6);
        t.addEdge(0, 3);
        t.addEdge(1, 3);
        t.addEdge(2, 3);
        t.addEdge(4, 3);
        t.addEdge(5, 4);

        LinkedList<Integer> res = t.rootForMinimumHeight();
        for (int i : res)
            System.out.print(i + " ");
        System.out.println();
    }
}