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
        int[] input = new int[] {1,2,4};

        System.out.println(answer1(input));

    }

    private static List<List<Integer>> answer1(int[] input) {

        // 1. DFS를 사용
        //  - 스스로 풀지 못하여 책과 인터넷을 확인. 다시 지우고 풀어볼 예정
        List<List<Integer>> results = new ArrayList<>();

        return results;
    }

    private static void dfs(List<List<Integer>> results, int[] input, boolean[] visited, List<Integer> list, int index) {


    }
}
