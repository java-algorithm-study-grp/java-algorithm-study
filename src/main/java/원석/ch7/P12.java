package 원석.ch7;

import java.util.Arrays;

public class P12 {
    public static void main(String args[]) {
        int[] prices1 = {7,1,5,3,6,4};
        int profit1 = maxProfit(prices1);
        System.out.println(profit1);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int price : prices) {
            if (price < min) {
                min = price;
            }
            else {
                max = Math.max(max, price - min);
            }
        }

        return max;
    }
}
