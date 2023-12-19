package 주앤.ch6;
/*
문제 : 5. 가장 긴 팰린드롬 부분 문자열
시간 복잡도 :
실행시간 및 메모리 : 11 ms(90.44%), 44.2 MB(37.86%)
어려웠던 것 :
	모든 경우의 수를 먼저 생각해야 해서 많은 시간이 소요됨.
	기준 포인터와 왼쪽,오른쪽 포인터로 총 3개의 포인터를 기반으로, 처음엔 짝수 팰린드롬일 경우와 홀수 팰린드롬일 경우를 나누지 않고 계산하려고 했으나, 코드가 복잡해지고 꼬임.
	따라서, 책 문제 풀이를 흘깃 보고 힌트를 얻어 홀수와 짝수를 나눠야겠다고 판단함.
풀이 :
- longestPalindrome 함수는 입력 문자열 s의 길이를 확인하고 길이가 1이면 원래 문자열 반환.
- 문자열 s를 문자 배열 chars로 변환하고, 팰린드롬을 저장할 StringBuilder인 sb 초기화.
- findPalindrome 함수를 호출하여 짝수 길이와 홀수 길이의 팰린드롬을 각각 확인.
- findPalindrome 함수는 주어진 팰린드롬의 중심을 기준으로 확장하여 최장 팰린드롬을 찾아 sb에 저장. (홀수냐 짝수냐에 따라 팰린드롬을 찾는 확장 방식이 다름)

 */
public class P6_1 {
	public static String longestPalindrome(String s) {
		int size = s.length();

		if (size == 1) {
			return s;
		}

		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder(String.valueOf(chars[0]));

		// 짝수 팰린드롬 확인
		findPalindrome(s, chars, sb, 1);

		// 홀수 팰린드롬 확인
		findPalindrome(s, chars, sb, 2);

		return sb.toString();
	}

	private static void findPalindrome(String s, char[] chars, StringBuilder sb, int pointerTerm) {
		int left = 0;
		int point = pointerTerm - 1;
		int right = pointerTerm;

		while (point < chars.length - 1) {
			if (chars[left] == chars[right]) {
				int currentLength = right - left + 1;
				if (currentLength > sb.length()) {
					sb.delete(0, sb.length());
					sb.append(s.substring(left, right + 1));
				}

				if (left != 0 && right != chars.length - 1) {
					left--;
					right++;
					continue;
				}
			}

			point++;
			left = point - (pointerTerm - 1);
			right = point + 1;
		}
	}

	public static void main(String[] args) {
		longestPalindrome("acce"); //cc
		longestPalindrome("acccce"); //cccc
		longestPalindrome("acckkkk"); //kkkk
		longestPalindrome("adddkkk"); //ddd or kkk
		longestPalindrome("addkkkkk"); // kkkkk
		longestPalindrome("kkkkk"); // kkkkk
	}
}
