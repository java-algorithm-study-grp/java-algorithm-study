package 승재.ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class P36 {

    private final Map<Character, List<String>> phoneKey = getPhoneKey();
    private final List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(final String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        dfs(digits, 0, new StringBuilder());
        return answer;
    }

    private Map<Character, List<String>> getPhoneKey() {
        return Map.of(
                '2', List.of("a", "b", "c"),
                '3', List.of("d", "e", "f"),
                '4', List.of("g", "h", "i"),
                '5', List.of("j", "k", "l"),
                '6', List.of("m", "n", "o"),
                '7', List.of("p", "q", "r", "s"),
                '8', List.of("t", "u", "v"),
                '9', List.of("w", "x", "y", "z")
        );
    }

    private void dfs(String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            answer.add(stringBuilder.toString());
            return;
        }

        final char key = digits.charAt(index);
        final List<String> letters = phoneKey.get(key);

        if (letters != null) {
            for (String letter : letters) {
                stringBuilder.append(letter);
                dfs(digits, index + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
