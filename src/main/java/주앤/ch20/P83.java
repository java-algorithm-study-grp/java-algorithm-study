package 주앤.ch20;
/*
문제 : L424.가장 긴 반복 문자 대체
풀이 : [책 및 타 코드 참고]
	- 슬라이딩 윈도우 크기에서 가장 반복되는 알파벳의 개수를 뺀 값이 k 보다 작거나 같으면, 슬라이딩 윈도우 크기를 result에 저장
	- 오른쪽 포인터가 클 수록 가장 긴 문자열을 추출할 수 있음으로, 오른쪽 포인터를 인덱스 0부터 끝까지 1씩 증가해서 동작을 수행함
	- arr[] : 알파벳 인덱스에 반복되는 알파벳의 개수를 값으로 가지기
못 푼 이유 : 규칙을 찾지 못함.
 */
public class P83 {
	public static int characterReplacement(String s, int k) {
		// 알파벳 개수 만큼의 크기 할당
		int[] arr = new int[26];
		int res = 0;
		// 슬라이딩 윈도우 사이에서 가장 많이 반복되는 알파벳의 인덱스
		int max = 0;

		int l = 0;
		for (int r = 0; r < s.length(); r++) {
			int rIdx = s.charAt(r) - 'A';
			arr[rIdx]++;

			max = Math.max(max, arr[rIdx]);

			if (r - l + 1 - max > k) {
				arr[s.charAt(l) - 'A']--;
				l++;
			}
			res = Math.max(res, r - l + 1);
			System.out.println("r = "+ r + "rIdx = "+ rIdx + "max = " + max + "res = " + res);
		}

		return res;
	}

	public static void main(String[] args) {
		characterReplacement("ABACD", 2);
	}
}
