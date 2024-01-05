package 주앤.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 기본 : 그래프를 인접리스트로 구현
 * DFS 재귀 구현 : depthFirstTraversal()
 * DFS 스택 구현 : iterDFT()
 * BFS 큐 구현 : breadthFirstTraversal()
 */
public class AdjListGraph<T> {
    static class Vertex<T> {
        T item;

        Vertex(T item) {
            this.item = item;
        }
    }

    static class Node {
        int vertex;
        Node next;

        Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }

    private Vertex[] vertices;
    private Node[] list;
    private boolean[] visited;
    private int capacity;
    private int n;

    public AdjListGraph(int capacity) {
        this.capacity = capacity;
        this.vertices = new Vertex[capacity];
        this.list = new Node[capacity];
        this.visited = new boolean[capacity];
        this.n = 0;
    }

    void addVertex(T item) {
        vertices[n] = new Vertex(item);
        n++;
    }

    // v 인덱스에 u노드가 v노드를 가리키게 한다.
    // v 인덱스에는 최종적으로 v 노드를 가리키도록 노드들이 연결되어있는데,
    // 실제로는 v 노드와 각 노드가 한 쌍 인접한다고 보면 된다.
    // ex) v [] 4->3->v 는, (4,v),(3,v) 인접
    void addEdge(int u, int v) {
        if(u < n && v < n){
            Node temp = new Node(u, list[v]);
            list[v] = temp;
        }else{
            throw new IllegalArgumentException();
        }
    }

    int capacity() {
        return capacity;
    }

    void print() {
        for (int v = 0; v < n; v++) {
            System.out.print(vertices[v].item + " : ");

            Node current = list[v];
            while (current != null) {
                System.out.print(vertices[current.vertex].item + " ");
                current = current.next;
            }
            System.out.println();
        }

        System.out.println();
    }

    void depthFirstTraversal() {
        depthFirstTraversal(0);
    }

    /**
     * @author jooany
     * @apiNote 재귀 사용 DFS
     */
    void depthFirstTraversal(int v) {
        System.out.println("index = " + v + " vertices[" + v + "] = " + vertices[v].item);
        visited[v] = true;

        Node node = list[v];
        while(node.next != null){
            if(!visited[node.vertex]){
                depthFirstTraversal(node.vertex);
            }

            node = node.next;
        }
    }

    /**
     * @author jooany
     * @apiNote 스택 사용 DFS
     */
    void iterDFT() {
        int v = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);
        visited[v] = true;

        while(!stack.isEmpty()){
            v = stack.poll();
            System.out.println("index = " + v + " vertices[" + v + "] = " + vertices[v].item);

            Node node = list[v];
            while(node != null){
                int index = node.vertex;
                if(!visited[index]){
                    stack.push(index);
                    visited[index] = true;
                }
                node = node.next;
            }
        }

    }

    /**
     * @author jooany
     * @apiNote 큐 사용 BFS
     */
    void breadthFirstTraversal() {
        int v = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            v = q.poll();
            System.out.println("index = " + v + " vertices[" + v + "] = " + vertices[v].item);

            Node node = list[v];
            while(node != null){
                int index = node.vertex;
                if(!visited[index]){
                    q.offer(index);
                    visited[index] = true;
                }
                node = node.next;
            }

        }

    }

    void resetVisited() {
        if (visited == null)
            visited = new boolean[capacity];
        for (int i = 0; i < capacity; i++) visited[i] = false;
    }

    public static void main(String[] args) {
        AdjListGraph<Integer> g = new AdjListGraph<>(7);

        for (int i = 0; i < g.capacity(); i++){
            g.addVertex(i);
        }

        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(3, 6);
        g.addEdge(6, 3);
        g.addEdge(4, 6);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 5);

        g.print();

        g.depthFirstTraversal();
        g.resetVisited();
        System.out.println();

        g.iterDFT();
        g.resetVisited();
        System.out.println();

        g.breadthFirstTraversal();
    }
}
