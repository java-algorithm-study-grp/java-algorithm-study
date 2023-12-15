package src.main.java.우형.ch7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P7 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (values.containsKey(target - nums[i])) {
                return new int[]{values.get(target - nums[i]), i};
            }

            values.put(nums[i], i);
        }

        return null;
    }
}
