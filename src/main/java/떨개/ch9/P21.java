package 떨개.ch9;

import java.util.*;

public class P21 {

    public static void main(String[] args) {
        // Ch09. 스택, 큐
        //  - 21. 중복 문자 제거
        //   1) 중복된 문자를 제외하고 사전식 순서(Lexicographical Order)로 나열하라.
        //      -> 사전식 순서 : 사전에서 가장 먼저 찾을 수 있는 순서
        //    - input : dbacdcbc
        //    - output : acdb

        // String s = "dbacdcbc";
        String s = "ebcabc";
        System.out.println(removeDuplicate1(s));
        // System.out.println(removeDuplicate2(s));
    }

    private static String removeDuplicate1(String s) {

        // 1. Stack을 이용하는 풀이
        //  - 스스로 생각해보는 중 -> (X, 결국 책을 봤습니다.). 먼저 풀어본 재귀 방식을 참고하여 풀어보기.
        //  - 이해가 더 덜 되어 있어서 좀 더 신중하게 확인해야 하면서 백준에 있는 걸 비교해봐야 할 듯 합니다.

        // 문자 개수를 계산해서 담아둘 변수 선언
        Map<Character, Integer> counter = new HashMap<>();
        // 이미 처리한 문자여부를 확인하기 위한 변수 선언
        Map<Character, Boolean> seen = new HashMap<>();
        // 문제 풀이에 사용할 스택 선언
        Deque<Character> stack = new ArrayDeque<>();

        // 문자별 개수 계산
        for(char c : s.toCharArray())
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);

        for(char c : s.toCharArray()) {
            System.out.println("counter = " + counter);
            System.out.println("seen = " + seen);
            System.out.println("stack = " + stack);

            // 현재 처리하는 문자는 카운터에서 -1 처리
            counter.put(c, counter.get(c) - 1);

            // 이미 처리한 문자는 건너뛴다.
            if(seen.get(c) != null && seen.get(c))
                continue;

            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙어야 할 문자라면 스택에서 제거하고 처리하지 않는 것으로 표시
            while(!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);

            // 현재 문자를 스택에 삽입
            stack.push(c);

            // 현재 문자를 처리한 걸로 선언
            seen.put(c, true);
        }

        // 스택에 있는 문자를 큐 순서대로 추출하여 리턴
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pollLast());

        return sb.toString();
    }

    private static String removeDuplicate2(String s) {

        // 2. 재귀를 이용하는 풀이
        //  - 도무지 방법을 떠오르는게 힘들어서 책을 봤음.
        //  - 처음에 Set을 이용하여 개수가 같은 값의 문자열을 진행한다면 계속 확인! 한다는 생각이 거의 똑같았다.
        //    for문으로 하나씩 확인한다는 것으로 시간 복잡도가 늘어나는 거에 걱정한 것과 재귀인 것만 제외하고.

        for (Character c : toSortedSet(s)) {

            String suffix = s.substring(s.indexOf(c));
            // System.out.println(c + " " + suffix);

            // suffix로 나뉜 값을 Set으로 정렬한 값과 동일하다면, 해당하는 문자를 삭제 후 계속 재귀
            if(toSortedSet(s).equals(toSortedSet(suffix))) {
                return c + removeDuplicate2(suffix.replace(String.valueOf(c), ""));
            }
        }

        return "";
    }

    public static Set<Character> toSortedSet(String s) {

        // 책에서는 순수 new Comparator를 이용한 정렬 방식을 사용했다.
        Set<Character> set = new TreeSet<>(Comparator.naturalOrder());

        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set;
    }

}