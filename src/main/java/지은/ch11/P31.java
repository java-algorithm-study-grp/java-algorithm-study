package 지은.ch11;
/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".



Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0


Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 */
import java.util.HashMap;
import java.util.Map;

public class P31 {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Map<Character, Integer> freqs = new HashMap<>();

        for (char stone: stones.toCharArray()) {
            if (freqs.containsKey(stone)) {
                freqs.put(stone, freqs.get(stone) + 1);
            } else {
                freqs.put(stone, 1);
            }
        }
        for(char jewel: jewels.toCharArray()) {
            if (freqs.containsKey(jewel)) {
                count+= freqs.get(jewel);
            }
        }
        return count;
    }
    public int numJewelsInStones2(String jewels, String stones) {
        int count = 0;
        for (int i=0;i<jewels.length();i++){
            for (int j=0;j<stones.length();j++){
                if (stones.charAt(j)==jewels.charAt(i))
                    count++;
            }
        }
        return count;
    }

}
