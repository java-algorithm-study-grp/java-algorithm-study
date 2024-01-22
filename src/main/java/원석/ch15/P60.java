package 원석.ch15;

import java.io.BufferedWriter;
import java.util.*;

public class P60 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums)
            pq.add(n);

        for (int i = 0; i < k - 1; i++)
            pq.poll();

        return pq.poll();
    }

    public static void main(String[] args) {
        P60 solution = new P60();

        int[] nums1 = {3,2,1,5,6,4};
        int k1 = 2;
        System.out.println(solution.findKthLargest(nums1, k1));
    }
}