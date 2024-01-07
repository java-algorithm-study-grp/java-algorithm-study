package 떨개.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P37 {
    public static void main(String[] args) {
        // Ch12. 그래프
        //  - 36. 순열(Permutation)
        //   1) 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라.
        //    - input : [1, 2, 4]
        //    - output : [
        //                [1,2,4],
        //                [1,4,2],
        //                [2,1,4],
        //                [2,4,1],
        //                [4,1,2],
        //                [4,2,1]
        //               ]
        // int[] input = new int[] {1,2,4};
        int[] input = new int[] {1,2,4,5,7};

        System.out.println(answer1(input));

    }

    private static List<List<Integer>> answer1(int[] input) {

        // 1. DFS를 사용
        //  - 스스로 풀지 못하여 책과 인터넷을 확인. 다시 지우고 풀어볼 예정
        //  - 인터넷에 있는 순열을 기반으로 재 생성, 순열에서 계속 visited를 사용하려는게 문제였음.
        List<List<Integer>> results = new ArrayList<>();

        dfs1(results, input, new ArrayList<>(), input.length);

        return results;
    }

    private static void dfs1(List<List<Integer>> results, int[] input, List<Integer> list, int count) {

        if(count == 0) {
            System.out.println("results = " + results + " list = " + list);

            results.add(list.stream().toList());
            return;
        }

        for (int i : input) {
            if (list.contains(i)) continue;
            list.add(i);
            dfs1(results, input, list, count - 1);
            list.remove(Integer.valueOf(i));
        }
    }
}
