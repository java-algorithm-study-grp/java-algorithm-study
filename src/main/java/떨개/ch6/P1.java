package 떨개.ch6;

public class P1 {
    public static void main(String[] args) {
    
        // Ch6. 문자열 처리
        //  - 01. 유효한 팰린드롬 : 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영숫자(영문자와 숫자)만을 대상으로 한다.
        
        String str = "Do geese see God";

        //  - Answer 01. 답안에서 정규식으로 문자만을 나타내도록 설정하는 방식이 있다.
        //  - replaceAll("[^A-Za-z0-9]", "") : 대소문자와 숫자만 제외하고 전부 제거

        System.out.println(isPalindrome2(str));
    }

    public static boolean isPalindrome1(String str) {

        // 1) 첫 번째 팰린드롬 확인 : 문자열 하나씩 확인

        // 1. '띄어쓰기'를 구분하지 않은 듯 하여 '띄어쓰기' 를 replace로 처리
        // 2. 이 후 '대소문자'를 구분하지 않으므로 toLowerCase() 적용
        // String s = str.replaceAll(" ", "").toLowerCase(); // 처음 작성한 형태, 띄어쓰기만 없앰
        String s = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // 3. 문자열 반으로 자르면서 양 끝부터 하나씩 확인.
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(String str) {

        // 2) 두 번째 팰린드롬 확인 : StringBuilder의 reverse() 메서드 활용

        // StringBuilder sb = new StringBuilder(str.replaceAll(" ", "").toLowerCase()); // 처음 작성한 형태, 띄어쓰기만 없앰
        StringBuilder sb = new StringBuilder(str.replaceAll("[^A-Za-z0-9]", "").toLowerCase());

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();

        return s1.equals(s2);
    }
}
