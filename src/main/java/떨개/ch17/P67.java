package 떨개.ch17;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P67 {

    public static void main(String[] args) {
        // Ch17. 정렬
        //  - 67. 가장 큰 수
        //   1) 엘리먼트를 조합해 만들 수 있는 가장 큰 수를 출력하라.
        //    - input1: {3, 30, 34, 8, 9}
        //    - output1: 9834330
        //    - input2: {10, 2}
        //    - output2: 210
        int[] nums = new int[] {3, 30, 34, 8, 9};
        System.out.println(largesNumber(nums));
    }

    private static String largesNumber(int[] nums) {

        // 1. 삽입 정렬
        //  - 책을 본 후, 다시 스스로 풀어봄. 다만 기억이 되살아나 금방 쓴거라 다시 풀어볼 예정.
        int i = 1;
        while(i < nums.length) {
            int j = i;
            while(j > 0 && toSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }

        if(nums[0] == 0)
            return "0";
        else
            return Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
    }

    private static boolean toSwap(int n1, int n2) {
        System.out.println("n1 = " + n1 + " n2 = " + n2);
        return Long.parseLong(String.valueOf(n1) + n2) < Long.parseLong(String.valueOf(n2) + n1);
    }

}
