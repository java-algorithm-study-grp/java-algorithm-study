package 떨개.ch23;

public class P91 {

    public static void main(String[] args) {
        // Ch23. 다이나믹 프로그래밍
        //  - 91. 피보나치 수
        //   1) 피보나치 수를 구하라.

        int n = 30;

        System.out.println(fib1(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        System.out.println(fib4(n));

    }

    private static int fib1(int n) {
        // 1. if를 통한 브루트포스
        if(n <= 1) {
            return n;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    private static int fib2(int n) {
        // 2. 상향식 피보나치 수열
        int[] dp = new int[31];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 2] + dp[i - 1];

        return dp[n];
    }

    private static int fib3(int n) {
        // 3. 하향식 피보나치 수열
        int[] dp = new int[31];

        if(n <= 1)
            return n;

        if(dp[n] != 0)
            return dp[n];

        dp[n] = fib3(n - 2) + fib3(n - 1);
        return dp[n];
    }
    
    private static int fib4(int n) {
        // 4. 공간 절약
        
        int x = 0, y = 1;
        for(int i = 0; i < n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return x;
    }
}
