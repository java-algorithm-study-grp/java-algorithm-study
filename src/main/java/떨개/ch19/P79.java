package 떨개.ch19;

public class P79 {

    public static void main(String[] args) {
        // Ch19. 비트 조작
        //  - 79. UTF-8 검증
        //   1) 입력값이 UTF-8 문자열이 맞는지 검증하라.
        //    - input1: data = {197, 130, 2}
        //    - output1: true
        //    - input2: data = {235, 140, 5}
        //    - output2: false
        // int[] data = new int[] {197, 130, 2};
        int[] data = new int[] {235, 140, 5};

        System.out.println(validUtf8(data));
    }

    private static boolean validUtf8(int[] data) {
        int start = 0;
        // 문자 전체 길이만큼 순회
        while(start < data.length) {
            // 문자의 시작 바이트
            int first = data[start];
            // 11110으로 시작하면 나머지가 3바이트여야 한다.
            if(first >> 3 == 0b11110 && check(data, start, 3)) {
                start += 4;
            }
            // 1110으로 시작하면 나머지가 2바이트여야 한다.
            else if(first >> 4 == 0b1110 && check(data, start, 2)) {
                start += 3;
            }
            // 110으로 시작하면 나머지가 1바이트여야 한다.
            else if(first >> 5 == 0b110 && check(data, start, 1)) {
                start += 2;
            }
            // 1바이트 문자
            else if(first >> 7 == 0) {
                start++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[] data, int start, int size) {
        // size만큼 이동하면서 각 바티으 10으로 시작 여부 확인
        for(int i = start + 1; i < start + size + 1; i++) {
            if(i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }
        return true;
    }

}
