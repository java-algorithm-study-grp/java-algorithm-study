package 떨개.ch22;

import java.util.*;

public class P89 {

    public static void main(String[] args) {
        // Ch22. 분할 정복
        //  - 89. 과반수 엘리먼트
        //   1) 과반수를 차지하는(절반을 초과하는) 엘리먼트를 출력하라.
        //    - input1: {2, 2, 1, 1, 3, 2, 2}
        //    - output1: 2
        //    - input2: {3, 2, 3}
        //    - output2: 3

        int[] nums = new int[] {2, 2, 1, 1, 3, 2, 2};

        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(0, nums.length -1, nums));
        System.out.println(majorityElement3(nums));

    }

    private static int majorityElement1(int[] nums) {

        // 1. 매우 단순한 풀이
        //  - nums의 크기와 map으로 데이터 값을 확인
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // 왜 hashMap은 정렬이 안되고 LinkedHashMap만 가능할까??
        //  -> 책에 HashMap은 입력 순서를 유지하지 않고 LinkedHashMap은 유지가 되기 때문이다 라고 쓰여있다.
        Map<Integer, Integer> orderMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> orderMap.put(x.getKey(), x.getValue()));

        Map.Entry<Integer, Integer> entry = orderMap.entrySet().stream().iterator().next();
        if(entry.getValue() > nums.length / 2)
            return entry.getKey();

        return -1;
    }

    private static int majorityElement2(int left, int right, int[] nums) {
        // 2. 분할 정복

        // 최소 분할 단위 리턴
        if(left == right)
            return nums[left];

        // 중앙 위치 인덱스 계산
        int mid = left + (right - left) / 2;
        int a = majorityElement2(left, mid, nums);
        int b = majorityElement2(mid + 1, right, nums);

        int countA = 0;

        // 해당 구간의 a 개수 계산
        for(int i = left; i <= right; i++) {
            if(nums[i] == a)
                countA++;
        }
        // a가 과반수를 넘으면 a 리턴
        return countA > (right - left + 1) / 2 ? a : b;
    }

    private static int majorityElement3(int[] nums) {
        // 3. 매우 간단한 방식
        //  - 해당 문제는 무조건 과반수가 넘는 값이 있기 때문에 이런 방식이 유효하다.
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
