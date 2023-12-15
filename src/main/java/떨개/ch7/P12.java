package 떨개.ch7;

public class P12 {

    public static void main(String[] args) {

        // Ch07. 배열
        //  - 12. 주식을 사고팔기 가장 좋은 시점
        //   1) 한 번의 거래로 낼 수 있는 최대 이익을 산출하라.
        int[] deals = new int[] {8, 1, 5, 3, 6, 4};
        // int[] deals = new int[] {7, 1, 5, 3, 6, 4};
        // int[] deals = new int[] {7, 6, 4, 3, 1};

        System.out.println(answer2(deals));

    }

    private static int answer1(int[] deals) {

        // 1. 브루트 포스(Brute Force)
        //  - 스스로 생각한 것.
        //  - O(n) * O(n - 1) 계산.
        int max = 0;
        for(int i = 0; i < deals.length; i++) {
            for(int j = i + 1; j < deals.length; j++) {
                // 첫 번째 비교 값이 다른 비교값보다 크거나 같다면 건너뛴다.
                if(deals[i] >= deals[j]) {
                    continue;
                }
                // 첫 번째 비교 값이 다른 비교값보다 작으면 해당 조건을 작동한다.
                else {
                    // 현재 최대 값이 두 비교 값을 뺀 최대 이익보다 작다면 갱신한다.
                    if(max < deals[j] - deals[i]) max = deals[j] - deals[i];
                }
            }
        }

        return max;
    }

    private static int answer2(int[] deals) {

        // 2. 저점과 현재 값과의 차이 계산
        //  - 저점을 체크하는 식으로 O(n) 풀이가 가능해진다.

        int max = 0, min = deals[0];

        for (int deal : deals) {
            min = Math.min(min, deal);

            max = Math.max(max, deal - min);
        }

        return max;
    }

}
