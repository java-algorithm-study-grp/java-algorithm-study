package 우형.ch21;

public class P89 {

    public int majorityElement(int[] nums) {
        return majorityElement(0, nums.length -1, nums);
    }

    public int majorityElement(int left, int right, int[] nums) {
        if (left == right)
            return nums[left];

        int mid = left + (right - left) / 2;
        int a = majorityElement(left, mid, nums);
        int b = majorityElement(mid + 1, right, nums);

        int countA = 0;

        for (int i = left; i < right; i++) {
            if (nums[i] == a) {
                countA++;
            }
        }

        return countA > (right - left + 1) / 2 ? a : b;
    }
}
