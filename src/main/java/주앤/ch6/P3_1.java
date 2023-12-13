package 주앤.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
P3 로그 파일 재정렬

문제 풀이 : 책 그대로

메소드 연상 방법 및 메소드:
특정 regex로 분리된 형태 -> split (정규식,원소 개수)
문자열 정렬 -> a.compareTo(b) 의 결과가 -1이라면 사전순 우선순위는 a/ 양수라면 사전순 우선순위는 b/ 0이라면 같음
단순한 값의 비교가 아닌 무언가 추가된 비교 조건이 있다면 -> sort(정렬 함수)

부족했던 점 : 람다식에 대한 이해, Comparable과 sort(),addList() 에 대한 이해. 클래스 별 빈출 메소드 숙지 필요

letterList.toArray(new String[0]); // 내부에서 필요한 크기만큼의 배열을 조정해주기 때문에 빈 배열로 전달함.
 */

class P3_1 {
	public static String[] reorderLogFiles(String[] logs) {
		List<String> letterList = new ArrayList<>();
		List<String> digitList = new ArrayList<>();

		for (String log : logs){
			if(Character.isDigit(log.split(" ")[1].charAt(0))){
				digitList.add(log);
			}else {
				letterList.add(log);
			}
		}

		// Collections.sort(letterList, new Comparator<String>() {
		// 	@Override
		// 	public int compare(String s1, String s2) {
		// 		String[] s1x = s1.split(" ", 2);
		// 		String[] s2x = s2.split(" ", 2);
		// 		int contentCompared = s1x[1].compareTo(s2x[1]);
		//
		// 		if(s1x[1].compareTo(s2x[1]) == 0){
		// 			return s1x[0].compareTo(s2x[0]);
		// 		}
		// 		return contentCompared;
		// 	}
		// });

		letterList.sort( (s1, s2) -> {
			String[] s1x = s1.split(" ", 2);
			String[] s2x = s2.split(" ", 2);
			int contentCompared = s1x[1].compareTo(s2x[1]);

			if(s1x[1].compareTo(s2x[1]) == 0){
				return s1x[0].compareTo(s2x[0]);
			}
			return contentCompared;
		});

		letterList.addAll(digitList);

		return letterList.toArray(new String[0]);
 	}

	public static void main(String[] args){
		reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
	}
}
