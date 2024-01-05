package 떨개.ch12;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P38 {

    public static void main(String[] args) {
        // Ch12. 그래프
        //  - 38. 조합(Combination)
        //   1) 전체 수 n을 입력받아 k개의 조합을 리턴하라
        //    - input : n = 5, k = 3
        //    - output : [
        //                [1,2,3],
        //                [1,2,4],
        //                [1,2,5],
        //                ...
        //                [2,4,1],
        //                [2,4,5],
        //                [3,4,5]
        //               ]

        int n = 5, k = 3;

        combination1(n, k);

    }

    private static List<List<Integer>> combination1(int n, int k) {

        // 1. 재귀 DFS
        //  - 거의 유사하게 만들었으나 계속 중복되는 값이 List에 들어가게 되어 정답을 보게 됨.
        //  - 애석하게도 재귀식에 들어가는 index 값을 index + 1로 설정하여 문제가 발생함을 확인하게 됨.
        //  - 다시 지우고 풀어볼 예정.

        List<List<Integer>> results = new ArrayList<>();
        dfs1(results, new ArrayList<>(), n, 1, k);
        return results;
    }

    private static void dfs1(List<List<Integer>> results, List<Integer> list, int n, int index, int k) {
        if(k == 0) {
            // System.out.println("list = " + list);
            results.add(list.stream().toList());
            return;
        }

        // System.out.println("index : " + index + " results = " + results + " list = " + list);

        for(int i = index; i <= n; i++) {
            list.add(i);
            dfs1(results, list, n, i + 1, k - 1);
            list.remove(Integer.valueOf(i));
        }
    }
}
