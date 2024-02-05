package 우형.ch17;

import java.util.Arrays;

public class P67 {

    public boolean toSwap(int n1, int n2) {
        return Long.parseLong(String.valueOf(n1) + n2) < Long.parseLong(String.valueOf(n2) + n1);
    }
    public String largestNumber(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (i > 0 && toSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j-1] = temp;
                j--;
            }
            i++;
        }

        if (nums[0] == 0) {
            return "0";
        } else {
            return Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
        }
    }

}
