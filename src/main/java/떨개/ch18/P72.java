package 떨개.ch18;

import java.util.*;

public class P72 {

    public static void main(String[] args) {
        // Ch18. 이진 검색
        //  - 72. 두 배열의 교집합
        //   1) 두 배열의 교집합을 구하라.
        //    - input1: nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4, 6}
        //    - output1: {9, 4}
        //    - input2: nums1 = {1, 2, 2, 1}, nums2 = {2, 2}
        //    - output2: {2}
        int[] nums1 = new int[] {4, 9 ,5};
        int[] nums2 = new int[] {9, 4 ,9, 8, 4, 6};

        System.out.println(Arrays.toString(intersection1(nums1, nums2)));
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
        System.out.println(Arrays.toString(intersection3(nums1, nums2)));
    }

    private static int[] intersection1(int[] nums1, int[] nums2) {
        // 1. 브루트 포스
        //  - for문 2개로 nums1, nums2를 전부 순회하는 방식
        //  - 이 때 조건은, '같은 값이면서 해당 교집합 값이 list에 들어있지 않다면' list에 추가하는 식이다.
        //  - 다른 방법으로는, Set(중복 제거)를 이용하여 if문을 하나 줄일 수 있다.
        //  - 시간 복잡도 O(n^2)
        // List<Integer> list = new ArrayList<>();
        //
        // for (int i : nums1) {
        //     for (int j : nums2) {
        //         if(i == j && !list.contains(i))
        //             list.add(i);
        //     }
        // }

        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            for (int j : nums2) {
                if(i == j)
                    set.add(i);
            }
        }

        // stream에 대해서 좀 더 알아봐야 할 거 같다.
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] intersection2(int[] nums1, int[] nums2) {
        // 2. 이진 탐색
        //  - Arrays에 있는 binarySearch(이진 탐색)을 사용하는 방식.
        //  - 처음보는건 아니지만 기억에 없어서 책을 보고 이해를 했습니다.
        //  - 시간 복잡도 O(nlogn)

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for(int i : nums1) {
            int j = Arrays.binarySearch(nums1, i);
            if(j >= 0)
                set.add(i);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] intersection3(int[] nums1, int[] nums2) {
        // 3. 투 포인터
        //  - 배열을 Sort하는 시간을 뺀다면 확실하게 매우 빠른 시간 복잡도를 가지고 있습니다.
        //  - 시간 복잡도 O(n)

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j])
                j++;
            else if(nums1[i] < nums2[j])
                i++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
