package 주앤.ch9;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 문제 : 20. Valid Parentheses
 * 실행시간 및 메모리 : 3 ms / 41.6 MB
 * 핵심 : 스택 두 개를 사용. 하나의 스택은 문자 전체를 담고, 하나의 스택은 닫는 괄호를 담음.
 **/
public class P20 {
	public boolean isValid(String s) {
		char[] arr = s.toCharArray();

		// 문자 배열의 길이가 홀수이면 false
		if(arr.length % 2 != 0){
			return false;
		}

		Deque<Character> stack = new ArrayDeque<>();
		Deque<Character> closeStack = new ArrayDeque<>();

		// 전체를 stack에 담기
		for(int i = 0; i < arr.length; i++){
			stack.push(arr[i]);
		}

		// 배열 크기 만큼 반복
		for(int i = 0; i < arr.length; i++){
			char bracket = stack.peek();
			if(bracket == ')' || bracket == '}' || bracket == ']'){
				closeStack.push(stack.pop());
				continue;
			}

			if(closeStack.size() != 0){
				char closeBracket = closeStack.peek();
				if(bracket == '(' && closeBracket == ')'){
					stack.pop();
					closeStack.pop();
				}else if(bracket == '{' && closeBracket == '}'){
					stack.pop();
					closeStack.pop();
				}else if(bracket == '[' && closeBracket == ']'){
					stack.pop();
					closeStack.pop();
				}else {
					return false;
				}
			}
		}

		if(stack.size() != 0 || closeStack.size() != 0){
			return false;
		}

		return true;
	}
}
