package 주앤.ch7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
	풀이 방법 : map(index,원소값) 백업 후, 정렬 후 크기 비교하며 체크하기
	시간 복잡도 : O(nlogn)
	실행시간 및 메모리 : 45 -> 9 ms,43.96 MB
 */
public class P7_2 {
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for(int i = 0; i < nums.length; i++){
	        map.put(i, nums[i]);
	    }

	    Arrays.sort(nums);
	    int start = 0;
	    int end = nums.length - 1;
	    int resultElements[] = new int[2];

	    while(start <= end){

	        if(nums[start] + nums[end] > target){
	            end--;
	        }else if(nums[start] + nums[end] < target) {
	            start++;
	        }else {
	            resultElements = new int[]{nums[start], nums[end]};
	            break;
	        }
	    }

	    Integer[] result = new Integer[2];
	    for(Map.Entry e : map.entrySet()){
	        if((int)e.getValue() == resultElements[0] && result[0] == null){
	            result[0] = (int)e.getKey();
	        }else if((int)e.getValue() == resultElements[1] && result[1] == null){
	            result[1] = (int)e.getKey();
	        }
	    }

	    return new int[]{result[0],result[1]};
	}

	public static void main(String[] args) {
		twoSum(new int[]{3,3}, 6);
	}
}
