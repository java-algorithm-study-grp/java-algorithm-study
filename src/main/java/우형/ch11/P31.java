package src.main.java.우형.ch11;

import java.util.HashMap;

public class P31 {

    public int numJewelsInStones(String jewels, String stones) {
        char[] charJewels = jewels.toCharArray();
        char[] charStones = stones.toCharArray();

        int result = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char charJewel : charJewels) {
            hashMap.put(charJewel, 0);
        }

        for (char charStone : charStones) {
            if (hashMap.containsKey(charStone)) {
                hashMap.put(charStone, hashMap.get(charStone) + 1);
                result++;
            }
        }

        return result;
    }

}
