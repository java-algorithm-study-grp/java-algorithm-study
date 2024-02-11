package 우형.ch19;

public class P77 {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;

        return Integer.bitCount(xor);
    }
}
