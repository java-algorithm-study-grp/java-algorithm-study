package 주앤.ch7;

import java.util.Arrays;

/*
문제 : 121. 주식을 사고팔기 가장 좋은 시점
시간 복잡도 : O(n)
실행시간 및 메모리 : 2 ms / 60.9 MB
부족했던 점 : 비교해야 하는 요소들의 차이를 구하는 것이 목표인데, 각 요소를 구하는 것에 대해 먼저 집중했다. 구해야 하는 것에 더 집중해야 한다.
풀이 : 하루씩 확인해 가면서, 현재까지의 가장 최솟값과 현재 값의 차이를 계산해가며 가장 큰 값을 저장한다.
 */
public class P12_1 {
	public static int maxProfit(int[] prices) {

		int minPrice = prices[0];
		int maxProfit = 0;

		for(int price : prices){

			if(minPrice > price){
				minPrice = price;
				continue;
			}

			int profit = price - minPrice;
			if(maxProfit < profit ){
				maxProfit = profit;
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		maxProfit(new int[]{7,1,5,3,6,4});
	}
}
