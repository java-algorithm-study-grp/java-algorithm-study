package 원석.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P36 {

    public static List<String> P36(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 숫자와 글자 연결
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        StringBuilder currentCombination = new StringBuilder();
        generateCombinations(digits, 0, currentCombination, result, digitToLetters);

        return result;
    }

    private static void generateCombinations(String digits, int index, StringBuilder currentCombination, List<String> result, Map<Character, String> digitToLetters) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char currentDigit = digits.charAt(index);
        String letters = digitToLetters.get(currentDigit);

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            generateCombinations(digits, index + 1, currentCombination, result, digitToLetters);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(P36("23")); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(P36(""));  // Output: []
        System.out.println(P36("2")); // Output: ["a","b","c"]
    }
}
