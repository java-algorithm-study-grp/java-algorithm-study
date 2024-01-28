package 주앤.ch18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
문제 : L179.가장 큰 수
풀이 : 이진탐색 구현으로 풀이
분석 : 실행시간이 하위 5%로 나올 만큼 심각하게 비효율적이다.
		이유는 중복을 없애고 시작하기 위해, stream distinct를 사용하였는데, 이를 사용하는 것보다
		2번째 풀이의 Set을 사용하여 결과를 담을 때 중복을 무시하는 것이 훨씬 더 효율적이다.
*/
public class P72 {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list1 = new ArrayList(nums1.length);
		List<Integer> list2 = new ArrayList(nums2.length);
		for (int n : nums1){
			list1.add(n);
		}
		for (int n : nums2){
			list2.add(n);
		}
		list1 = list1.stream().distinct().collect(Collectors.toList());
		Collections.sort(list1);
		list2 = list2.stream().distinct().collect(Collectors.toList());
		Collections.sort(list2);

		List<Integer> resultList = new ArrayList<>();

		for (int x : list1) {
			System.out.println("x: " +x);

			int left = 0;
			int right = list2.size() - 1;
			int middle;

			while (left <= right){
				middle = (right + left)/2;

				if (x < list2.get(middle) ){
					right = middle - 1;
				}else if ( list2.get(middle) < x){
					left = middle + 1;
				}else {
					resultList.add(list2.get(middle));
					break;
				}
			}
		}

		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++){
			result[i] = resultList.get(i);
			System.out.println("result: "+ result[i]);
		}

		return result;
	}
}
