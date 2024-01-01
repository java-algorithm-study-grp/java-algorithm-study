package 떨개.ch9;

import java.util.*;

public class P20 {

    public static void main(String[] args) {
        // Ch09. 스택, 큐
        //  - 20. 유효한 괄호
        //   1) 대중소 세 종류 괄호로 된 입력값이 유효한지 판별하라.

        String input = "[]{}()";
        // String input = "[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))[{}]((()))";

        // long start1 = System.currentTimeMillis();
        System.out.println(isValidBracket1(input));
        // long end1 = System.currentTimeMillis();
        // System.out.println("1 : " + (end1 - start1));

        // long start2 = System.currentTimeMillis();
        System.out.println(isValidBracket2(input));
        // long end2 = System.currentTimeMillis();
        // System.out.println("2 : " + (end2 - start2));
    }

    private static boolean isValidBracket1(String input) {
        // 1. 스택을 이용한 방식
        //  - 대, 중, 소 괄호의 카운트
        int small = 0, middle = 0, big = 0;

        // char 배열로 수정
        char[] input_arr = input.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        //  - stack에 넣는다
        for (char c : input_arr) {
            stack.push(c);
        }

        // - FILO을 이용해 카운트의 조건을 건다.
        //  1) Last OUT임으로 정상적인 괄호 형태를 원하면 ')', '}', ']'를 이용하여 -1 시킨다.
        //  2) '(', '{', '['가 나오면 +1일텐데 이때 카운트가 양수(0보다 큰 수)가 된다면 오류가 발생한 것으로 처리한다.
        while(!stack.isEmpty()) {

            char c = stack.pop();

            switch(c) {
                case '(' :
                    small++;
                    break;
                case '{' :
                    middle++;
                    break;
                case '[' :
                    big++;
                    break;
                case ')' :
                    small--;
                    break;
                case '}' :
                    middle--;
                    break;
                case ']' :
                    big--;
                    break;
            }

            if(small > 0 || middle > 0 || big > 0) return false;
        }

        return small == 0 && middle == 0 && big == 0;
    }

    private static boolean isValidBracket2(String input) {

        // 2. 스택 일치 여부 판별(풀이1)

        // 유효성 검증을 위한 스택
        Deque<Character> stack = new ArrayDeque<>();
        // 유효성 검증을 위한 매핑 테이블
        Map<Character, Character> table = new HashMap<>() {{
           put(')', '(');
           put('}', '{');
           put(']', '[');
        }};

        // 문자열을 문자 단위로 반복
        for(int i = 0; i < input.length(); i++) {
            // 닫힌 괄호가 아닌 경우 스택에 푸시
            if(!table.containsKey(input.charAt(i))) {
                // System.out.println("if : " + input.charAt(i));
                stack.push(input.charAt(i));
            }
            // 중간에 스택이 비거나 팝 결과가 열림 괄호가 아닌 경우 유효하지 않음
            else if(stack.isEmpty() || table.get(input.charAt(i)) != stack.pop()) {
                // System.out.println("else if : " + input.charAt(i));
                return false;
            }
        }

        // 유효한 입력이 되려면 반복 완료 후 스택이 비어있음을 검증한다.
        return stack.isEmpty();
    }

}
