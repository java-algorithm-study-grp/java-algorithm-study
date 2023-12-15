package 원석.ch7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P7 {
    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15}; //int[] 배열
        int target = 9; //합으로 나와야 하는 수
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    //brute force, hashmap을 이용하기
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];

            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            //해시맵에 저장
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
