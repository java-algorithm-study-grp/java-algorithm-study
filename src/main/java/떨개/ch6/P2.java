package 떨개.ch6;

import java.util.Arrays;

public class P2 {

    public static void main(String[] args) {

        // Ch6. 문자열 처리
        //  - 02. 문자열 뒤집기 : 문자열을 뒤집는 함수를 작성하라. 입력값은 문자 배열이며, [리턴 없이 입력 배열 내부를 직접 조작하라].

        //  - 문제점 : 문제 내용을 제대로 보자. [리턴 없이 입력 배열 내부를 직접 조작] 이라는 뜻이 있으므로 함수 자체를 만들어서 사용해야한다.
        //   -> List로 변경 후 Collections 클래스의 reverse 메서드를 사용하는 방법이 있으나 직접 조작이 아니므로 예외해야한다.

        char[] str_arr = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};

        reverse(str_arr);

        System.out.println(str_arr);

    }
    
    public static void reverse(char[] str_arr) {

        // 1) 문자열 뒤집기 : 각 위치에 문자열 하나씩 바꿔가며 확인
        int start = 0;
        int end = str_arr.length - 1;

        while (start < end) {
            char temp = str_arr[start];
            str_arr[start] = str_arr[end];
            str_arr[end] = temp;

            start++;
            end--;
        }
    }

}
