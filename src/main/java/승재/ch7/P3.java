package 승재.ch7;

import java.util.HashMap;
import java.util.Map;

/**
 * 두수의 합
 * 덧셈해서 target 값을 만들어 주는 인덱스를 반환하기
 * [2, 7, 11, 15] target = 9
 */
public class P3 {

    public int[] twoSum(final int[] nums, final int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }


        return null;
    }
}
