package 떨개.ch20;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P83 {

    public static void main(String[] args) {
        // Ch20. 슬라이딩 윈도우
        //  - 83. 가장 긴 반복 문자 대체
        //   1) 대문자로 구성된 문자열 s가 주어졌을 때 k번만큼의 변경으로 만들 수 있는 연속으로 반복된 문자열의
        //      가장 긴 길이를 출력하라.
        //    - input1: s = "AAABBCD", k = 2
        //    - output1: 5
        String s = "AAABBCD";
        int k = 2;

        System.out.println(charaterReplacement(s, k));
    }

    private static int charaterReplacement(String s, int k) {
        // 1. 투 포인터와 슬라이딩 윈도우 이용
        int left = 0;

        Map<Character, Integer> counts = new HashMap<>();
        for(int right = 1; right <= s.length(); right++) {

            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);
            // 가장 흔하게 등장하는 문자의 개수 추출
            int maxCharCount = Collections.max(counts.values());

            // k 초과시 왼쪽 포인터 이동, 조건에 맞지 않으면 윈도우 크기는 더 이상 커지지 않고 끝까지 유지된다.
            if(right - left - maxCharCount > k) {
                // 윈도우 맨 왼쪽 문자의 카운트 감소
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                // 왼쪽 포인터 이동
                left++;
            }
        }

        // 오른쪽 포인터는 이동했으므로 문자열 길이와 동일
        // 여기에 왼족 포인터 위치를 뺀 값을 정답으로 리턴
        return s.length() - left;
    }

}
