package 우형.ch18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P72 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums2);

        for (int n1 : nums1) {
            int i2 = Arrays.binarySearch(nums2, n1);

            if (i2 >= 0) {
                result.add(n1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
