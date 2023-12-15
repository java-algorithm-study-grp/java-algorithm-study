package src.main.java.우형.ch6;

public class P1 {

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length-1;

        while (start < end) {
            if (!Character.isLetterOrDigit(arr[start]))
                start++;
            else if (!Character.isLetterOrDigit(arr[end])) {
                end--;
            }
            else {
                if (Character.toLowerCase(arr[start]) != Character.toLowerCase(arr[end])) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
