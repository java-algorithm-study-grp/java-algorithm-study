package 승재.ch10;

import java.util.HashMap;
import java.util.Map;

public class P31 {

    private final Map<String, Integer> map = new HashMap<>();
    public int numJewelsInStones(String jewels, String stones) {
        final String[] keys = jewels.split("");

        final String[] stonesString = stones.split("");
        for (String s : stonesString) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int answer = 0;
        for (String key : keys) {
            answer += map.getOrDefault(key, 0);
        }
        return answer;
    }

}
