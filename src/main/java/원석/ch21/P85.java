package 원석.ch21;

import java.util.*;

public class P85 {
    public int[][] reconstructQueue(int[][] people) {
        // 키가 큰 순서로 정렬하고, 키가 같을 경우 k가 작은 순으로 정렬
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0]; // 내림차순 정렬
                } else {
                    return a[1] - b[1]; // 오름차순 정렬
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            // k 값에 따라 위치에 삽입
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][]);
    }


    public static void main(String[] args) {
        P85 Solution = new P85();

        int[][] people1 = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(Arrays.deepToString(Solution.reconstructQueue(people1)));

        int[][] people2 = {{6,0}, {5,0}, {4,0}, {3,2}, {2,2}, {1,4}};
        System.out.println(Arrays.deepToString(Solution.reconstructQueue(people1)));
    }
}
