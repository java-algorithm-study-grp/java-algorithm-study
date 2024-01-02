package 떨개.ch11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P31 {

    public static void main(String[] args) {
        // Ch11. 해시 테이블
        //  - 31. 보석과 돌
        //   1) J는 보석이며, S는 갖고 있는 돌이다. S에는 보석이 몇 개나 있을까? 대소문자는 구분한다.
        //   1 <= J, S <= 50
        //   input : J = "aA", S = "aAAbbbb" / J = "z", S = "ZZ"
        //   output : 3 / 0

        // String J = "aA";
        // String S = "aAAbbbb";
        String J = "abc";
        String S = "abcABCabcABCcbaCBAcbaCBA";

        // System.out.println(jewelNums1(J, S));
        System.out.println(jewelNums2(J, S));
        System.out.println(jewelNums3(J, S));
    }

    private static int jewelNums1(String J, String S) {

        // 1. HashMap을 이용한 방식.
        //  - 스스로 푼 과정. HashMap의 대상을 J(보석)으로 진행하였다.
        //  - 진행하다보니 for문을 3개나 사용했다.
        //  - 수정하면 2개로도 줄일 수 있을 것 같다.

        Map<Character, Integer> j = new HashMap<>();

        for (char c : J.toCharArray()) {
            j.put(c, 0);
        }

        for(char c: S.toCharArray()) {
            if(j.containsKey(c))
                j.replace(c, j.get(c) + 1);
        }

        int count = 0;

        for (Integer value : j.values()) {
            count += value;
        }

        return count;
    }

    private static int jewelNums2(String J, String S) {

        // 2. HashMap을 사용한 방식.
        //  - 책에서 풀이를 잠시 살펴봤는데 보석이 아닌 돌을 넣는 식으로 했다.

        Map<Character, Integer> s = new HashMap<>();

        for(char c: S.toCharArray()) {
            if(s.containsKey(c)) {
                s.replace(c, s.get(c) + 1);
            } else {
                s.put(c, 1);
            }
        }

        int count = 0;

        for (char c : J.toCharArray()) {
            if(s.containsKey(c))
                count += s.get(c);
        }

        return count;

    }

    private static int jewelNums3(String J, String S) {

        // 3. HashSet을 이용하는 방법
        //  - 스스로 + 책을 확인하면서 작업한 과정. HashSet의 대상을 J(보석)으로 진행하였다.
        Set<Character> j = new HashSet<>();

        for (char c : J.toCharArray())
            j.add(c);

        int count = 0;

        for (char c : S.toCharArray())
            if(j.contains(c)) count++;

        return count;
    }

}
