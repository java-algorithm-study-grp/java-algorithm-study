package 원석.ch7;

import java.util.Arrays;

public class P10 {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 3, 2};
        int result1 = arrayPairSum(nums1);
        System.out.println(result1);

        int[] nums2 = {6, 2, 6, 5, 1, 2};
        int result2 = arrayPairSum(nums2);
        System.out.println(result2);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i <nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;

    }
}

