package 떨개.ch15;

import 떨개.Object.BinaryHeap1;
import 떨개.Object.BinaryHeap2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P60 {

    public static void main(String[] args) {
        // Ch15. 힙
        //  - 60. 배열의 k번째 큰 엘리먼트
        //   1) 정렬되지 않은 배열에서 k번째 큰 엘리먼트를 추출하라.
        //    - input1: nums = {1, 3, 2, 3, 1, 2, 4, 5, 5, 6}, k = 4
        //    - output1: 4
        //    - input2: nums = {3, 2, 1, 5, 6, 4}, k = 2
        //    - output2: 5

        int[] nums = {1, 3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        // System.out.println(findKthLargest1(nums, k));
        System.out.println(findKthLargest2(nums, k));
    }

    private static int findKthLargest1(int[] nums, int k) {

        // 1. 소개에 써있는 BinaryHeap을 사용 1
        //  - 반복문이 2개나 사용된 거 같아 이상하다...
        //  - 다만 k번째의 '큰' 값이기 때문에 추출하는 값은 min이기 때문에 반대 값을 사용했다.

        int answer = 0;
        BinaryHeap1 heap = new BinaryHeap1();

        for (int num : nums)
            heap.insert(num);


        int count = nums.length - k;

        while(count >= 0) {
            answer = heap.extract();
            count--;
        }

        return answer;
    }

    private static int findKthLargest2(int[] nums, int k) {
        // 2. 소개에 써있는 BinaryHeap을 사용 2
        //  - 첫번째 BinaryHeap은 최소값에 대한 Heap이었기에 조건을 최대값으로 변경

        int answer = 0;
        BinaryHeap2 heap = new BinaryHeap2();

        for (int num : nums)
            heap.insert(num);

        while(k > 0) {
            answer = heap.extract();
            k--;
        }

        return answer;
    }

    private static int findKthLargest3(int[] nums, int k) {

        // 3. 우선순위 큐를 사용
        //  - 힙은 우선순위 큐에 사용이 되었다고 써있었다.
        //  - 즉, 우선순위 큐를 이용해서 추출하면 코드도 간결해진다.

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums)
            priorityQueue.add(num);

        for(int i = 0; i < k - 1; i++)
            priorityQueue.poll();

        return priorityQueue.poll();
    }

}
