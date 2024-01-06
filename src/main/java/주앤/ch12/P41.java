package 주앤.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.w3c.dom.Node;

/**
 문제 : 332. Reconstruct Itinerary
 풀이 : [책] 우선순위큐 활용
 못 푼 이유 : 처음엔 인접 리스트로 접근을 시도했으나, 인접 리스트에 도착지를 삽입할 때마다, 정렬을 해야 한다는게 여간 까다로운 일이 아니며 코드도 매우 복잡해진다.
 분석 : 인접을 나타낼 자료구조는 인접리스트, 인접행렬 뿐만 아니라 어떤 것으로도 구현이 가능하다.
 키워드 연상 : 사전순으로 정렬되어야 함.
 */
public class P41 {
	public List<String> findItinerary(List<List<String>> tickets) {
		List<String> result = new ArrayList<>();
		Map<String, PriorityQueue<String>> map = new HashMap<>();

		for(List<String> list : tickets){
			String key = list.get(0);

			map.putIfAbsent(key, new PriorityQueue<>());
			map.get(key).offer(list.get(1));
		}

		dfs("JFK", result, map);

		return result;
	}

	public void dfs(String key, List<String> result, Map<String, PriorityQueue<String>> map){
	   while(map.containsKey(key) && !map.get(key).isEmpty()){
		   dfs(map.get(key).poll(), result, map);
	   }
	   result.add(0, key);
	}
}
