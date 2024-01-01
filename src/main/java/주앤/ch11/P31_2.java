package 주앤.ch11;

import java.util.HashSet;
import java.util.Set;
/**
 * 문제 : 771. Jewels and Stones
 * 핵심 : HashSet 을 이용한 풀이
 **/
public class P31_2 {

	public int numJewelsInStones(String jewels, String stones) {

		Set<Character> set = new HashSet<>();
		int sum = 0;

		for(char c : jewels.toCharArray()){
			set.add(c);
		}

		for(char c : stones.toCharArray()){
			if(set.contains(c)){
				sum++;
			}
		}

		return sum;
	}

}
