package 떨개.ch12;

import java.util.*;

public class P36 {

    public static void main(String[] args) {
        // Ch12. 그래프
        //  - 36. 전화번호 조합
        //   1) 2에서 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자를 출력하라.
        //    - input : "24"
        //    - output : ["ag", "ah", "ai", "bg", "bh", "bi", "cg", "ch", "cl"]

        String digits = "929";

        System.out.println(answer1(digits));

    }

    private static List<String> answer1(String digits) {

        // 1. Stack과 Queue를 이용한 방식
        //  - 스스로 풀어봄. 다만, 이 방식이 맞는지 솔직히 잘 모르겠다. 시간 복잡도가...
        Map<Integer, List<Character>> phone = new HashMap<>() {{
            put(2, Arrays.asList('a', 'b', 'c'));
            put(3, Arrays.asList('d', 'e', 'f'));
            put(4, Arrays.asList('g', 'h', 'i'));
            put(5, Arrays.asList('j', 'k', 'l'));
            put(6, Arrays.asList('m', 'n', 'o'));
            put(7, Arrays.asList('p', 'g', 'r', 's'));
            put(8, Arrays.asList('t', 'u', 'v'));
            put(9, Arrays.asList('w', 'x', 'y', 'z'));
        }};

        // 순서대로 들어온 값을 While문에서 풀어 쓰기 위함(FIFO)
        Queue<List<Character>> queue = new ArrayDeque<>();

        // queue에 해당하는 번호의 문자 List를 넣는다.
        for (char c : digits.toCharArray())
            queue.offer(phone.get(Character.getNumericValue(c)));

        // 문자로 구성된 값을 넣는 stack
        Deque<List<String>> stack = new ArrayDeque<>();

        // queue가 poll로 소진될 때 까지 진행
        while(!queue.isEmpty()) {

            List<Character> list = queue.poll();
            List<String> answer = new ArrayList<>();

            if(!stack.isEmpty()) {
                List<String> pop = stack.pop();

                for (String s : pop) {
                    for (Character c : list) {
                        answer.add(s + c);
                    }
                }
            } else {
                for (Character c : list) {
                    answer.add(String.valueOf(c));
                }
            }

            stack.push(answer);
        }

        return stack.peek();
    }



    private static void dfs(List<String> result, Map<Integer, List<Character>> dic, String digits, int index, StringBuilder path) {

        // 끝까지 탐색했으면 결과를 저장하고 리턴
        if(path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        // 현재 자리 숫자에 해당하는 모든 문자열 탐색
        for (Character c : dic.get(Character.getNumericValue(digits.charAt(index)))) {
            // 현재 자리 + 1, 지금까지 구성된 문자열 path 이용 재귀 DFS
            dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
        }
    }

    private static List<String> answer2(String digits) {

        // 2. 재귀 DFS를 이용한 조합 탐색
        //  - 풀이법을 보고 그대로 작성, 이해는 했으나 스스로 풀 때 이 방법을 떠올랐음에도
        //    코드를 작성하지 못하여 다시 복기를 해야함.

        List<String> result = new ArrayList<>();

        if(digits.isEmpty())
            return result;

        Map<Integer, List<Character>> phone = new HashMap<>() {{
            put(2, Arrays.asList('a', 'b', 'c'));
            put(3, Arrays.asList('d', 'e', 'f'));
            put(4, Arrays.asList('g', 'h', 'i'));
            put(5, Arrays.asList('j', 'k', 'l'));
            put(6, Arrays.asList('m', 'n', 'o'));
            put(7, Arrays.asList('p', 'g', 'r', 's'));
            put(8, Arrays.asList('t', 'u', 'v'));
            put(9, Arrays.asList('w', 'x', 'y', 'z'));
        }};

        dfs(result, phone, digits, 0, new StringBuilder());

        return result;
    }
}
