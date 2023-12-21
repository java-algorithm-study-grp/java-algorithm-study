package 주앤.ch9;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 문제 : 20. Valid Parentheses
 * 실행시간 및 메모리 : 1 ms / 41.5 MB
 * 핵심 : 열린 괄호를 저장하는 스택 사용.
 **/
public class P20_2 {
	public boolean isValid(String s) {
		char[] arr = s.toCharArray();

		// 문자 배열의 길이가 홀수이면 false
		if(arr.length % 2 != 0){
			return false;
		}

		Deque<Character> openBrackets = new ArrayDeque<>();

		for(int i = 0; i < arr.length; i++){
			char bracket = arr[i];
			if(bracket == '(' || bracket == '{' || bracket == '['){
				openBrackets.push(bracket);
			}else {
				if(openBrackets.size() == 0){
					return false;
				}

				char openBracket = openBrackets.peek();
				if((bracket == ')' && openBracket == '(') || (bracket == '}' && openBracket == '{') || (bracket == ']' && openBracket == '[')){
					openBrackets.pop();
				}else {
					return false;
				}

			}
		}

		return openBrackets.isEmpty();
	}
}
