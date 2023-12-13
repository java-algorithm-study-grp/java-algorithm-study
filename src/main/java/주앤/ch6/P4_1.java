package 주앤.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
문제 : 49. 그룹 애너그램
시간 복잡도 : O(n)
실행시간 및 메모리 : 6 ms (74.26%) / 46.4 MB (94.26%)
부족했던 점 :
	1. char[] 배열에 toString() 을 하면 Object.toString() 한 것과 같이 char배열의 주소가 나온다. 값을 꺼내려면 String.valueOf()을 사용해야 한다.
해결 방법 :
	1. 하나로 묶어야 하는 문자열들의 공통점 찾기 -> 같은 알파벳
	2. 하나로 묶는 방법 -> Map
 */

public class P4_1 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for(String str : strs){
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = String.valueOf(chars);

			if(map.containsKey(sortedStr)){
				map.get(sortedStr).add(str);
			}else{
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(sortedStr, list);
			}
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
	}
}
