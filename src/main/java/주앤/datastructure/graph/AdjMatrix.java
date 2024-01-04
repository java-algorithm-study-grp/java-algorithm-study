package 주앤.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 기본 : 그래프를 인접행렬로 구현
 * DFS 재귀 구현 : depthFirstTraversal()
 * DFS 스택 구현 : iterDFT()
 * BFS 큐 구현 : breadthFirstTraversal()
 */
public class AdjMatrix<T> {

	static class Vertex<T> {
		T item;

		Vertex(T item) {
			this.item = item;
		}
	}

	// 인덱스 정점 정보
	private Vertex<T>[] vertices;

	// 정점 간 인접을 나타내는 인접 행렬
	// 대칭이면 무방향 그래프
	// 비대칭이면 방향 그래프
	private int[][] matrix;


	// 인덱스 정점에 방문 여부
	private boolean[] visited;
	private int capacity;
	private int num;

	public AdjMatrix(int capacity){
		this.vertices = new Vertex[capacity];
		this.matrix = new int[capacity][capacity]; // 초기값 0
		this.visited = new boolean[capacity]; // 초기값 false
		this.capacity = capacity;
		this.num = 0;
	}

	public void printMatrix() {
		if (num > 0) {
			for (int r = 0; r < num; r++) {
				for (int c = 0; c < num; c++)
					System.out.print(matrix[r][c] + ", ");
				System.out.println();
			}
		} else {
			System.out.println("Empty");
		}
		System.out.println();
	}

	public int getCapacity(){
		return this.capacity;
	}

	public void addVertex(T item) {
		vertices[num] = new Vertex<>(item);
		num++;
	}

	public void addEdge(int from, int to) {
		// 인덱스가 정점의 개수보다 크면, 인접행렬 값 할당(간선 추가)
	    if (from < num && to < num) {
	        matrix[from][to] = 1;
	    } else { // 크지 않으면, 에러 발생
	        throw new IllegalArgumentException("Invalid vertex indices: " + from + ", " + to);
	    }
	}

	public void depthFirstTraversal() {
		resetVisited();
		depthFirstTraversal(0);
		System.out.println();
	}

	/**
	 * @author jooany
	 * @apiNote 재귀 사용 DFS
	 */
	public void depthFirstTraversal(int index) {

		visited[index] = true;
		System.out.println("index = " + index + ", vertices[" + index + "] = " + vertices[index].item);

		for(int i = 0; i < num; i++){

			// 현재 index 인덱스를 가지는 정점과 i 인덱스를 가지는 정점이 인접관계이면서 방문하지 않았다면 재귀호출
			if(matrix[index][i] == 1 && !visited[i]){
				depthFirstTraversal(i);
			}
		}
	}

	/**
	 * @author jooany
	 * @apiNote 스택 사용 DFS
	 */
	public void iterDFT() {

		// 스택에 인덱스 저장
		Deque<Integer> stack = new ArrayDeque<>();
		int startIndex = 0;
		stack.push(startIndex); // 시작 정점 인덱스 0
		visited[startIndex] = true;

		while(!stack.isEmpty()){
			int index = stack.pop();
			System.out.println("index = " + index + ", vertices[" + index + "] = " + vertices[index].item);


			// 방문하지 않은 해당 인덱스 정점의 방문하지 않은 인접한 정점을 스택에 저장
			for(int i = 0; i < num; i++){
				if(matrix[index][i] == 1 && !visited[i]){
					stack.push(i);
					visited[i] = true;
				}
			}
		}
	}

	/**
	 * @author jooany
	 * @apiNote 큐 사용 BFS
	 */
	public void breadthFirstTraversal() {
		int firstIndex = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(firstIndex);
		visited[firstIndex] = true;

		while(!queue.isEmpty()){
			int index = queue.poll();
			System.out.println("index = " + index + ", vertices[" + index + "] = " + vertices[index].item);

			// 해당 인덱스 정점의 방문하지 않은 인접한 정점을 큐에 저장
			for(int i = 0; i < num; i++){
				if(matrix[index][i] == 1 && !visited[i]){
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

	}

	private void resetVisited() {
		if (visited == null) {
			visited = new boolean[capacity];
		}
		for (int i = 0; i < capacity; i++) {
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		AdjMatrix<Integer> graph = new AdjMatrix<>(7);

		for (int i = 0; i < graph.getCapacity(); i++) {
			graph.addVertex(i);
		}

		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(1,4);
		graph.addEdge(1,3);
		graph.addEdge(2,4);
		graph.addEdge(3,6);
		graph.addEdge(4,6);
		graph.addEdge(5,6);
		graph.addEdge(1,0);
		graph.addEdge(2,0);
		graph.addEdge(4,1);
		graph.addEdge(3,1);
		graph.addEdge(4,2);
		graph.addEdge(6,3);
		graph.addEdge(6,4);
		graph.addEdge(6,5);

		graph.printMatrix();

		System.out.println("dfs 풀이 1) 재귀 구현 >>");
		graph.depthFirstTraversal();
		graph.resetVisited();

		System.out.println("dfs 풀이 2) 스택 구현 >>");
		graph.iterDFT();
		graph.resetVisited();


		System.out.println();
		System.out.println("bfs 풀이 1) 재귀 구현 >>");
		graph.breadthFirstTraversal();


	}
}

