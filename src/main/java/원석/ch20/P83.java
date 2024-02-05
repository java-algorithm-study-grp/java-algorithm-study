package 원석.ch20;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P83 {

    public int characterReplacement(String s, int k) {
        int left = 0;

        Map<Character, Integer> counts = new HashMap<>();

        for (int right = 1; right <= s.length(); right++) {

            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);

            int maxCharCount = Collections.max(counts.values());

            if (right - left - maxCharCount > k) {
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return s.length() - left;
    }

    public static void main(String[] args) {
        P83 Solution = new P83();

        String s1 = "ABAB";
        int k1 = 2;

        System.out.println(Solution.characterReplacement(s1, k1));
    }
}
