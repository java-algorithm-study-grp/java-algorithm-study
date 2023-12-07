package 승재.ch6;

/**
 * 문자열 뒤집기
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class P2 {

    public char[] reverseString(char[] s) {
        int first = 0;
        int last = s.length - 1;

        while(first < last) {
            swap(s, first, last);
            first++;
            last--;
        }

        return s;
    }

    private void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}
