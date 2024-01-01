package 원석.ch11;

public class P31 {
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        // 보석의 각 문자에 대해 stones 문자열에서 몇 번 등장하는지 카운트
        for (char jewel : jewels.toCharArray()) {
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example 1
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        int result1 = numJewelsInStones(jewels1, stones1);
        System.out.println("Example 1: " + result1); // Output: 3

        // Example 2
        String jewels2 = "z";
        String stones2 = "ZZ";
        int result2 = numJewelsInStones(jewels2, stones2);
        System.out.println("Example 2: " + result2); // Output: 0
    }
}