package 승재.ch7;

import org.junit.jupiter.api.Test;

class P5Test {

    private final P5 p = new P5();

    @Test
    void test() {
        final int answer = p.maxProfit(new int[]{8, 1, 5, 3, 6, 4});
        System.out.println(answer);
    }

}