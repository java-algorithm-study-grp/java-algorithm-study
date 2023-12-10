package 원석.ch6;

import java.util.Arrays;

public class P2 {
    public static void main(String args[]) {
        P2 p2Instance = new P2();
        char[] input = {'h', 'e', 'l', 'l', 'o'};

        // reverseString 메소드 호출
        p2Instance.reverseString(input);

        // 뒤집힌 문자열 출력
        System.out.println("Reversed String: " + Arrays.toString(input));
    }

    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
