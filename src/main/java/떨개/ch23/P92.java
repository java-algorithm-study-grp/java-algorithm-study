package 떨개.ch23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P92 {

    public static void main(String[] args) {
        // Ch23. 다이나믹 프로그래밍
        //  - 92. 최대 서브 배열
        //   1) 연속된 값으로 구성된 가장 큰 서브 배열을 찾아 합을 리턴하라.

        // int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -6, 4};
        // int[] nums = new int[] {1};
        int[] nums = new int[] {5, 4, -1, 7, 8};

        System.out.println(maxSubArray1(nums));
        // System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));

    }

    private static int maxSubArray1(int[] nums) {
        List<Integer> sums = new ArrayList<>(List.of(nums[0]));

        for(int i = 1; i < nums.length; i++)
            sums.add(nums[i] + (sums.get(i - 1) > 0 ? sums.get(i - 1) : 0));

        return Collections.max(sums);
    }

    private static int maxSubArray2(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += Math.max(nums[i - 1], 0);

        return Arrays.stream(nums).max().getAsInt();
    }

    private static int maxSubArray3(int[] nums) {
        // 카데인 알고리즘: 책을 보고 이해하는 중
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;
        for(int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;

    }

}
