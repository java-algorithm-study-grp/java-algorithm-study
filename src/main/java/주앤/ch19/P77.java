package 주앤.ch19;
/*
문제 : L461. 해밍거리
풀이 : 십진수를 이진수로 변환하기 위해 2로 계속 나눠 나머지를 배열의 작은 인덱스부터 할당하고,
	몫이 1이나 0이 나오면 몫을 마지막 인덱스 위치에 할당한다.
	이후, 각 배열을 서로 비교하여 개수를 세어 반환한다.
 */
public class P77 {
	public int hammingDistance(int x, int y) {
		int[] xArr = new int[31];
		int[] yArr = new int[31];

		int i = 0;
		while (x >= 2) {
			xArr[i++] = x % 2;
			x = x / 2;
		}
		xArr[i] = x;

		int j = 0;
		while (y >= 2) {
			yArr[j++] = y % 2;
			y = y / 2;
		}
		yArr[j] = y;

		int cnt = 0;
		for (int k = 0; k < 31; k++) {
			if (xArr[k] != yArr[k]) {
				cnt++;
			}
		}
		return cnt;
	}
}
