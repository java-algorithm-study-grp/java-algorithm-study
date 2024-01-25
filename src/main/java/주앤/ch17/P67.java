package 주앤.ch17;

import java.util.Arrays;
/*
문제 : L179.가장 큰 수
풀이 : 처음에는 선택정렬을 사용하여 O(n^2)로 풀이하였는데,
		자바의 Arrays.sort는 내부에서 병합정렬로 구현되었기 때문에
	 	해당 메소드를 사용하는 방식으로 풀이하여 9초가량 실행시간을 감소시켰다.
	 	병합 정렬의 시간 복잡도는 O(nlogn) 이다.
 */
public class P67 {

	public String largestNumber(int[] nums) {
		// 숫자를 문자열로 변환하여 문자열 배열에 저장
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}

		// a와 b를 합치고 b와 a를 합쳐서 사전 내림차순으로 정렬
		Arrays.sort(arr, (b, a) -> (a + b).compareTo(b + a));

		// 0으로 시작하는 경우, 0 반환
		if (arr[0].equals("0")) {
			return "0";
		}

		// 문자열 배열을 문자열로 합치기
		StringBuilder sb = new StringBuilder("");
		for (String s : arr) {
			sb.append(s);
		}
		return sb.toString();
	}
}
