package 주앤.ch6;

class P1_2 {
    public boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while(start < end){
            if(!Character.isLetterOrDigit(chars[start])){
                start++;
            } else if(!Character.isLetterOrDigit(chars[end])){
                end--;
            } else if( Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end]) ){
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}