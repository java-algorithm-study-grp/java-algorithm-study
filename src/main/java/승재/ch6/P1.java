package 승재.ch6;

/**
 * 유효한 팰린드롬
 * 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영숫자만을 대상으로 한다.
 */
public class P1 {

    public boolean palindrome(final String text) {
        int first = 0;
        int last = text.length() - 1;

        while (first < last) {
            if (letterOrDigit(text.charAt(first))) {
                first++;
                continue;
            }

            if (letterOrDigit(text.charAt(last))) {
                last--;
                continue;
            }

            if (Character.toLowerCase(text.charAt(first)) != Character.toLowerCase(text.charAt(last))) {
                return false;
            }

            first++;
            last--;
        }

        return true;
    }

    private boolean letterOrDigit(char text) {
        return !Character.isLetterOrDigit(text);
    }

}
