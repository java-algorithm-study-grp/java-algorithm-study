package 주앤.ch6;

class P2_1 {
    public void reverseString(char[] s) {
		int length = s.length;
		char temp = 0;

		for(int i = 0 ; i < length/2; i++){
			temp = s[i];
			s[i] = s[length - i - 1];
			s[length - i - 1] = temp;
		}
    }
}
