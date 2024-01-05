package 주앤.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 문제 : 17. Letter Combinations of a Phone Number
 * 핵심 : [책] 풀이
 * 키워드 연상 : 순서없는 조합
 **/
public class P36 {
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits.length() == 0){
			return result;
		}

		Map<Character, List<Character>> map = new HashMap<>();
		mappingLetters(map);

		dfs(map, digits, result, new StringBuilder(), 0);

		return result;

	}

	public static void dfs(Map<Character, List<Character>> map, String digits, List<String> result, StringBuilder sb, int index){
		System.out.println("index[" + index + "], sb.toString() = "  + sb.toString());
		if(index == digits.length()){
			result.add(String.valueOf(sb));
			System.out.println();
			return;
		}

		for(char c : map.get(digits.charAt(index))){
			if(index < digits.length()){
				dfs(map, digits, result, new StringBuilder(sb).append(c), index + 1);
			}
		}
	}

	public static void mappingLetters(Map<Character, List<Character>> map){
		map.put('2',List.of('a','b','c'));
		map.put('3',List.of('d','e','f'));
		map.put('4',List.of('g','h','i'));
		map.put('5',List.of('j','k','l'));
		map.put('6',List.of('m','n','o'));
		map.put('7',List.of('p','q','r','s'));
		map.put('8',List.of('t','u','v'));
		map.put('9',List.of('w','x','y','z'));
	}

	public static void main(String[] args) {
		letterCombinations("23");
	}
}
