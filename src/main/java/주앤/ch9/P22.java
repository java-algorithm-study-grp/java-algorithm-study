package 주앤.ch9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 : 739. Daily Temperatures
 * 실행시간 및 메모리 : 0 ms / 40.4 MB (38.29%)
 * 해결과정 : 처음엔 하나의 요소와 그 뒤의 요소들을 모두 비교하는 방식만 떠올랐는데,
 * 	이렇게 되면 temperatures.length의 최대가 10의 5제곱인데, 거의 n^2 시간복잡도가 나올 수 있을 것 같아서,
 * 	고민하다가 결국엔 책의 풀이를 클론함.
 * 풀이 :
 * 	배열을 주어진 길이만큼 초기화한 다음,
 * 	요소 하나씩 순회하면서, 인덱스 하나하나를 스택에 담음과 동시에
 * 	스택에 이전에 담았던 인덱스의 데이터가 더 작은 경우,
 * 	스택에 담긴 인덱스(값)을 추출(pop())하여 해당 인덱스에 현재 순회하던 차례의 인덱스와의 차이만큼을 저장함.
 *
 * 	어떻게 떠올릴 수 있을까?
 * 		-> 인덱스의 차이를 구해야 할 때 -> 스택에 넣어두기만 하면, 해당 인덱스를 나중에 비교하여 원하는 값을 채울 수 있음.
 **/
public class P22 {
	public int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> q = new ArrayDeque<>();
		int[] result = new int[temperatures.length];

		for(int i = 0; i < temperatures.length; i++){
			while(!q.isEmpty() && temperatures[q.peek()] < temperatures[i]){
				int last = q.pop();
				result[last] = i - last;
			}
		 	q.push(i);
		}
		return result;
	}
}
