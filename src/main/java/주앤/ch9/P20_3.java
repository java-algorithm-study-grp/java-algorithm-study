package 주앤.ch9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 : 20. Valid Parentheses
 * 실행시간 및 메모리 : 1 ms / 41.8 MB
 * 핵심 : 문자 하나씩 조회할 때, 열린 괄호일 때는 해당 타입의 닫는 괄호를 스택에 저장하고, 닫는 괄호일 때는 스택에서 꺼내서 값이 같은지 확인한다.
 * 		모든 작업이 끝나면 스택이 비워져있어야 유효한 문자열이다.
 * 다른 코드들과의 비교 : 명료하고 간결하며 가독성이 좋음.
 **/
public class P20_3 {
	public boolean isValid(String s) {
		char[] arr = s.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();

		for(int i = 0; i < arr.length; i++){
			char c = arr[i];
			if(c == '('){
				stack.push(')');
			}else if(c == '{'){
				stack.push('}');
			}else if(c == '['){
				stack.push(']');
			}else if(stack.isEmpty() || stack.pop() != c){
				return false;
			}
		}

		return stack.isEmpty();
	}
}
