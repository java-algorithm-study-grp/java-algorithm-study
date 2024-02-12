package 우형.ch21;

public class P84 {
    public static void main(String[] args) {
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
    static public int maxProfit(int[] prices) {

        int cur = prices[prices.length - 1];
        int result = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > cur)
                cur = prices[i];
            else {
                result += cur - prices[i];
                cur = prices[i];
            }
        }

        return result;

    }

}
