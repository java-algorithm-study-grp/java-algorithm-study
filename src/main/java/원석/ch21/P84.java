package 원석.ch21;

public class P84 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] > prices[i])
                profit += prices[i+1] - prices[i];
        }
        return profit;
    }

    public static void main(String args[]) {
        P84 Solution = new P84();

        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(Solution.maxProfit(prices1));

        int[] prices2 = {1,2,3,4,5};
        System.out.println(Solution.maxProfit(prices2));

        int[] prices3 = {7,6,4,3,1};
        System.out.println(Solution.maxProfit(prices3));
    }
}
