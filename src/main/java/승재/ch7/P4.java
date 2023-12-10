package 승재.ch7;

import java.util.Arrays;

public class P4 {

    public int arrayPairSum(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                answer += nums[i];
            }
        }
        return answer;
    }

}
