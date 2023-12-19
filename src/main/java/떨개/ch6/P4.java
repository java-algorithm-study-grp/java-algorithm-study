package 떨개.ch6;

import java.util.*;

public class P4 {

    public static void main(String[] args) {
        // Ch6. 문자열 처리
        //  - 04. 가장 흔한 단어
        //   1) 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않으며 구두점(마침표, 쉼표 등) 또한 무시한다.
        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit";
        String[] ban_words = new String[] {};
        mostCommandWord1(paragraph, ban_words);
    }

    private static String mostCommandWord1(String paragraph, String[] ban_words) {

        // 1. 정규식으로 문자 구분 후 처리
        //  - 문자("\\W+")만 표시하도록 정규표현식 사용
        Set<String> ban = new HashSet<>(Arrays.asList(ban_words));
        String[] words = paragraph.replaceAll("\\W+", "").toLowerCase().split(" ");

        //  - 단어 Map을 만들어 카운트
        Map<String, Integer> word_map = new HashMap<>();
        for (String word : words) {
            if(!ban.contains(word)) {
                word_map.put(word, word_map.getOrDefault(word, 0));
            }
        }

        // 리턴 할 때 또 for문이 아닌 메서드들이 있는데 여기서 책을 보았다.
        // Collections : collections에 사용할 정적 유틸리티 메소드의 모음이 있는 java.util.Collections 클래스.
        //  - max :
        //   1) primitive 타입일 때 : 비교한 요소 중 의미상 가장 큰 값을 찾는다.
        //   2) reference 타입일 때 : Comparable을 구현한 클래스의 조건에 따라 비교한 요소 중 가장 큰 값을 찾는다.

        //  - public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
        //         if (comp==null)
        //             return (T)max((Collection) coll);
        //
        //         Iterator<? extends T> i = coll.iterator();
        //         T candidate = i.next();
        //
        //         while (i.hasNext()) {
        //             T next = i.next();
        //             if (comp.compare(next, candidate) > 0)
        //                 candidate = next;
        //         }
        //         return candidate;
        //     }
        //  - Iterator에 해당하는 Map을 entrySet()으로 추출 후 Value 값을 오름차순으로 정렬한 값에서 최대값을 추출.

        // entrySet() : Map의 Key와 Value 값 모두를 필요로 사용할 때 이용.
        // comparingByValue() : Map의 Value 값을 오름차순으로 정렬.

        return Collections.max(word_map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
