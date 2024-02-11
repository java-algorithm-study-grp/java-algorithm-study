package 떨개.ch19;

public class P77 {

    public static void main(String[] args) {
        // Ch19. 비트 조작
        //  - 77. 해밍 거리
        //   1) 두 정수를 입력받아 몇 비트가 다른지 계산하라.
        //    input1: x = 1, y = 6
        //    output1: 3
        //    input2: x = 1, y = 4
        //    output2: 2
        // int x = 1, y = 6;
        int x = 1, y = 4;

        System.out.println(hammingDistance(x, y));
    }

    private static int hammingDistance(int x, int y) {
        int count = 0;
        String binaryString = Integer.toBinaryString(x ^ y);

        for(char c : binaryString.toCharArray()) {
            if(c == '1') count++;
        }

        return count;
    }

}
