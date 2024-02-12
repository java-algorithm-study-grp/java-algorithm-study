package 떨개.ch21;

public class P84 {

    public static void main(String[] args) {
        // Ch21. 그리디 알고리즘
        //  - 84. 주식을 사고팔기 가장 좋은 시점 2
        //   1) 여러 번의 거래로 낼 수 있는 최대 이익을 산출하라.
        //    - input1: prices = {8, 1, 5, 3, 6, 4}
        //    - output1: 7
        //    - input2: prices = {1, 2, 3, 4, 5}
        //    - output2: 4
        int[] prices = new int[] {8, 1, 5, 3, 6, 4};
        // int[] prices = new int[] {1, 2, 3, 4, 5};

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        int result = 0;

        // 전체를 순회하며 다음번 값이 오르는 경우를 찾는다.
        for(int i = 0; i < prices.length - 1; i++) {
            // 다음번 값이 오르는 경우 항상 이익을 취한다.
            System.out.println("result = " + result);
            if(prices[i + 1] > prices[i])
                result += prices[i + 1] - prices[i];
        }

        return result;
    }

}
