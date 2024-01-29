package src.main.java.우형.ch15;

import java.util.Collections;
import java.util.PriorityQueue;

public class P60 {

    static public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k; i++) {
            result = pq.poll();
            System.out.println(result);
        }

        return result;

    }

    public static void main(String[] args) {
        findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

}
