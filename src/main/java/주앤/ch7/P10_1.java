package 주앤.ch7;

import java.util.Arrays;

/*
문제 : 561. 배열 파티션 (짝을 짓고, 최솟값의 합이 최댓값이 되어야 함.)
시간 복잡도 : O(n)
실행시간 및 메모리 : 13 ms / 45.4 MB
해결 과정 : 경우의 수로 규칙 파악 후 큰 숫자부터 크기차이가 적게 나는 숫자들을 더해가야 한다는 것을 깨달음.
풀이 : 크기 순으로 정렬하고, 0,2,4... 인덱스에 있는 값들을 더 함.
 */
public class P10_1 {
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);

        int sum = nums[0];

		for(int i=1; i < nums.length/2; i++){
			sum += nums[2*i];
		}

		return sum;
	}

	public static void main(String[] args) {
		arrayPairSum(new int[]{6,2,6,5,1,2});
	}
}
