package 떨개.ch19;

public class P76 {

    public static void main(String[] args) {
        // Ch19. 비트 조작
        //  - 76. 싱글 넘버
        //   1) 딱 하나를 제외하고 모든 엘리먼트가 2개씩 있다. 1개인 엘리먼트를 찾아라.
        //    input1: nums = {1, 2, 1}
        //    output1: 2
        //    input2: nums = {4, 1, 2, 1, 2}
        //    output2: 4
        // int[] nums = new int[] {1, 2, 1};
        int[] nums = new int[] {4, 1, 2, 1, 2};

        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }

}
