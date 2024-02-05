package 주앤.ch19;

/*
문제 : L393.UTF-8 검증
풀이 : [타 코드 참고] 시프트로 맨 앞 비트가 무엇인지 확인하여 몇 바이트로 인코딩 되었는지 확인하고,
	확인해야 할 바이트를 세어 체크하고 이를 반복
못 푼 이유 :
	시프트 연산에 익숙하지 않음
	문제 이해에 어려움을 겪음
 */
public class P78 {

	public boolean validUtf8(int[] data) {
		int cnt = 0;

		for (int n : data) {
			if (cnt == 0) {
				if (n >> 5 == 0b110) {
					cnt = 1;
				} else if (n >> 4 == 0b1110) {
					cnt = 2;
				} else if (n >> 3 == 0b11110) {
					cnt = 3;
				} else if (n >> 7 != 0) {
					return false;
				}
			} else {
				if (n >> 6 != 0b10) {
					return false;
				}
				cnt--;
			}
		}
		return cnt == 0;
	}
}
