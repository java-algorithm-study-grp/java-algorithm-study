package 떨개.ch7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class P10 {

    public static void main(String[] args) {

        // Ch07. 배열
        //  - 10. 배열 파티션 1
        //   1) n개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
        int[] fair = new int[] {1, 3, 4, 2};
        // int[] fair = new int[] {6, 2, 6, 5, 1, 2};

        System.out.println(answer1(fair));
        System.out.println(answer2(fair));
    }

    private static int answer1(int[] fair) {

        // 1. 배열을 올림차순 정렬 후 순서대로 페어 진행하여 계산 -> 스스로 생각한 것인데 1번 답안으로 동일하게 있음.
        //  - Arrays.sort() : DualPivotQuicksort, 평균 O(nlog(n)) / 최악 O(n^2)
        //  - Collections.sort() : TimeSort(삽입정렬 + 합병정렬), 평균/최악 O(nlog(n))
        int answer = 0;

        Arrays.sort(fair);

        for (int i = 0; i < fair.length; i += 2) {
            answer += Math.min(fair[i], fair[i+1]);
        }

        return answer;
    }

    private static int answer2(int[] fair) {

        // 2. 오름차순 정렬 후 짝수 번째 값만 계산
        //  - 오름차순 후 위와 동일하게 Math.min()을 진행하면 무조건 짝수 번째의 값이 나타난다.
        int answer = 0;

        Arrays.sort(fair);

        for(int i = 0; i < fair.length; i += 2) {
            answer += fair[i];
        }

        return answer;
    }
}
