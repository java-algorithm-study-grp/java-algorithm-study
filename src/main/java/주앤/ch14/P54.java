package 주앤.ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
문제 : L310. 최소 높이 트리 - 주어진 무방향 간선과 노드의 개수로, 최소 높이 트리를 찾아 루트를 반환하라.
풀이 : [책] 리프 노드를 제거한다.
못 푼 이유 : 구해야 하는 값이 가장 자식을 많이 가진 노드들인 것만 찾고, 그 노드를 어떻게 구할 수 있을지 생각하지 못함.
			리프 노드를 제거하다보면, 가장 자식을 많이 가지는 노드들만 남게 됨.
			따라서, 남는 루트 노드는 1개 혹은 서로 인접한 노드 2개가 된다.
 */
public class P54 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		if (n == 1) return List.of(0);

		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] edge : edges){
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.putIfAbsent(edge[1], new ArrayList<>());

			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; i++){
			if(graph.get(i).size() == 1){
				leaves.add(i);
			}
		}

		while (n > 2){
			// 이전 단계 리프 노드 개수만큼 n에서 제거
			n -= leaves.size();

			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves){
				// 이웃 노드 선언
				int neighbor = graph.get(leaf).get(0);
				// 이웃 노드에서 값을 삭제
				graph.get(neighbor).remove((Object)leaf);

				// 이웃 노드가 리프 노드이면 저장
				if(graph.get(neighbor).size() == 1){
					newLeaves.add(neighbor);
				}

				leaves = newLeaves;
			}
		}

		return leaves;
	}
}
