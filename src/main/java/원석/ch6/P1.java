package 원석.ch6;

public class P1 {
    public static void main(String args[]) {
        String input = "AMAIIAMA";
        P1 obj = new P1();
        boolean isPalindrome = obj.isPalindrome(input);
        System.out.println(isPalindrome);
    }

    public boolean isPalindrome(String s) {
        String sLower = s.toLowerCase();
        String sRemoved = sLower.replaceAll("[^a-zA-Z0-9]", ""); //정규표현식
        String revStr = ""; //초기화

        for(int i = sRemoved.length() - 1; i >= 0 ; i--) {
            revStr += sRemoved.charAt(i);
        }
        if (sRemoved.equals(revStr)) {
            return true;
        }
        return false;
    }


}