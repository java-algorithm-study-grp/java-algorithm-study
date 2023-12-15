package src.main.java.우형.ch6;

public class P2_solution {
    public void reverseString(char[] s) {
        char temp;
        int n = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            if (i < n-i) {
                temp = s[n-i];
                s[n-i] = s[i];
                s[i] = temp;
            }
        }


    }
}
