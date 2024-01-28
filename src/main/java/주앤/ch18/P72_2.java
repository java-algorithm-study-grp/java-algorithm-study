package 주앤.ch18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
문제 : L179.가장 큰 수
풀이 : [책] Arrays의 binarySearch 메소드 활용
새로 알거나 헷갈리는 부분:
	- Arrays.binarySearch(int[] arr, int num) -> num과 같은 수를 이진탐색하여 인덱스 반환
	- Arrays 를 사용해서 일반 배열을 정렬할 수 있었다.


*/
public class P72_2 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> result = new HashSet<>();
		Arrays.sort(nums2);

		for (int n1 : nums1){
			int idx = Arrays.binarySearch(nums2, n1);

			if (idx >= 0){
				result.add(nums2[idx]);
			}
		}

		int[] resultArr = new int[result.size()];
		int i = 0;
		for (int j : result){
			resultArr[i] = j;
		}

		return resultArr;
	}

}
