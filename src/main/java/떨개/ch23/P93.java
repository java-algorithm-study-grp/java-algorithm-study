package 떨개.ch23;

import java.util.Arrays;

public class P93 {

    public static void main(String[] args) {
        // Ch23. 다이나믹 프로그래밍
        //  - 93. 계단 오르기
        //   1) 당신은 계단을 오르고 있다. 정상에 도달하기 위해 n계단을 올라야 한다.
        //      매번 각각 1계단 또는 2계단씩 오를 수 있다면 정상에 도달하기 위한 방법은
        //      몇 가지 경로가 되는지 계산하라.
        int n = 45;

        System.out.println(climbStairs1(n));
        System.out.println("dp = " + Arrays.toString(dp));
    }
    static int[] dp = new int[46];

    private static int climbStairs1(int n) {
        if(n <= 2)
            return n;

        if(dp[n] != 0)
            return dp[n];

        dp[n] = climbStairs1(n - 1) + climbStairs1(n - 2);

        return dp[n];
    }

}
