package 주앤.ch11;

import java.util.HashMap;
import java.util.Map;

/*
문제 : 프로그래머스 - 완주하지 못한 선수
풀이 : HashMap 사용
 */
public class P34 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Map<String, Integer> map = new HashMap<>();
		for (String s : participant) {
			if (map.get(s) != null) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}

		// 완주하지 못한 선수 탐색
		for (String s : completion) {
			Integer count = map.get(s);

			if (count == 1) {
				map.remove(s);
			} else {
				map.put(s, map.get(s) - 1);
			}
		}

		for (Map.Entry e : map.entrySet()) {
			answer = (String)e.getKey();
		}

		return answer;
	}
}
