package 떨개.ch21;

import java.util.*;

public class P85 {

    public static void main(String[] args) {
        // Ch21. 그리디 알고리즘
        //  - 85. 키에 따른 대기열 재구성
        //   1) 여러 명의 사람들이 줄을 서 있다. 각각의 사람들은 (h, k)의 두 정수 쌍을 갖는다
        //      , h는 그 사람의 키, k는 앞에 줄 서있는 사람들 중 자신과 키가 같거나 더 큰 사람들의 수를 뜻한다.
        //      이 값이 올바르도록 줄을 재정렬하는 알고리즘을 작성하라.
        //    - input1: people = {{7, 0}, {4, 4}, {7, 1}, {6, 0}, {6, 2}, {5, 2}}
        //    - output1: {{6, 0}, {7, 0}, {5, 2}, {6, 2}, {4, 4}, {7, 1}}
        //    - input2: people = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}}
        //    - output2: {{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}}
        int[][] people = new int[][] {{7, 0}, {4, 4}, {7, 1}, {6, 0}, {6, 2}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    private static int[][] reconstructQueue(int[][] people) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ?
                        b[0] - a[0] : a[1] - b[1]
        );

        for (int[] person : people) {
            pq.add(person);
        }

        List<int[]> result = new ArrayList<>();

        // 우선순위 큐에서 모두 추출할 때까지 반복
        while(!pq.isEmpty()) {
            // 큰 키 우선, 앞에 줄 서 있는 사람이 작은 순으로 추출
            int[] person = pq.poll();
            // 앞에 줄 서 있는 사람을 인덱스로 정해서 삽입
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }

}
