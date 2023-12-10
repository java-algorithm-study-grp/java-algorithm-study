package 주앤.ch6;

class P1_1 {
    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s.replaceAll("[^A-Za-z0-9]","").toLowerCase());
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
}