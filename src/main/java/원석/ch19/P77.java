package 원석.ch19;

public class P77 {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        P77 Solution = new P77();
        int x1 = 1, y1 = 6;
        System.out.println(Solution.hammingDistance(x1,y1));
    }
}
