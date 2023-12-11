package 주앤.ch7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
	풀이 방법 : [책 풀이]Map을 활용하여 타겟에서 특정 값을 뺀 나머지 값을 원소로 가지는지 확인하는 방법
	시간 복잡도 : O(n)
	실행시간 및 메모리 : 45 -> 9 -> 4 ms,43.84 MB
 */
public class P7_3 {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
		  map.put(nums[i],i);
		}

		for(int i=0; i<nums.length; i++){
		  if(map.containsKey(target-nums[i]) && i != map.get(target - nums[i])){
			  return new int[]{i,map.get(target-nums[i])};
		  }
		}

		return null;
	}

	public static void main(String[] args) {
		twoSum(new int[]{3,3}, 6);
	}
}
