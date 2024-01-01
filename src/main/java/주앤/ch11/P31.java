package 주앤.ch11;

import java.util.HashMap;
import java.util.Map;
/**
 * 문제 : 771. Jewels and Stones
 * 핵심 : HashMap을 이용한 풀이
 * 		풀이 1) 보석을 map 에 담고, 돌을 하나씩 살펴보며 보석인 경우 map의 값에 1을 더한 후, 마지막에 합산함.
 * 		풀이 2) 돌을 모두 map에 담고, 겹치면 값에 1을 더함. 보석을 하나씩 살펴보며 map에 포함되어 있으면 값을 꺼내어 합산함
 **/
public class P31 {

	// 보석을 map 에 담고, 돌을 하나씩 살펴보며 보석인 경우 map의 값에 1을 더한 후, 마지막에 합산함.
	public int numJewelsInStones(String jewels, String stones) {

		Map<Character, Integer> map = new HashMap<>();

		for(char c : jewels.toCharArray()){
			map.put(c, 0);
		}

		for(char c : stones.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}
		}

		int sum = 0;
		for(Map.Entry e : map.entrySet()){
			sum += (int)e.getValue();
		}

		return sum;
	}

	// 책 참고하여 수정한 풀이.
	public int numJewelsInStones_2(String jewels, String stones) {

		Map<Character, Integer> map = new HashMap<>();

		int sum = 0;
		for(char c : stones.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c,1);
			}
		}

		for(char c : jewels.toCharArray()){
			if(map.containsKey(c)){
				sum += map.get(c);
			}
		}

		return sum;
	}
}
