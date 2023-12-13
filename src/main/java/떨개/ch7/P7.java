package 떨개.ch7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P7 {

    public static void main(String[] args) {

        // ch07. 배열
        //  - P7. 두수의 합 : 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.

        // int[] nums = {2, 6, 11, 15};
        int[] nums = {2, 6, 11, 15};
        int target = 8;

        // System.out.println(Arrays.toString(answer1(nums, target)));
        System.out.println(Arrays.toString(answer2(nums, target)));
    }

    public static int[] answer1(int[] nums, int target) {

        // 1. 배열 i번째부터 계산하여 i+1부터 j로 취급 후 이중 for문으로 target에 맞는 값이 나오면 count에 1씩 덧셈 처리.
        //  - 해당 책에서 브루트 포스(Brute-Force) 방식이라고 칭하고 있으며 시간 복잡도는 O(n^2)다.

        //  - 해당 문제의 이해를 잘못하여 덧셈 값의 갯수를 정했다. 다시 수정 완료.

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                // System.out.println(nums[i] + " | " + nums[j]);
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] answer2(int[] nums, int target) {

        // 2. 시간 복잡도 개선 형태.
        //  - HashMap 형태로 값을 저장한다. 조회는 평균적으로 O(1), 최악의 경우는 O(n)을 가지고 있다.
        Map<Integer, Integer> numsMap = new HashMap<>();

        // 키와 값을 바꿔서 맵으로 저장
        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // System.out.println("numsMap = " + numsMap);

        // target에서 첫 번째 수를 뺀 결과를 키로 조회하고 현재 인덱스가 아닌 경우 정답으로 리턴
        for(int i = 0; i < nums.length; i++) {
            if(numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }

        return null;
    }

    public static int[] answer3(int[] nums, int target) {

        // 3. 2의 시간 복잡도 개선에서 조회 구조를 개선.
        //  - 2개의 for문이 아닌 1개의 for문으로 처리한다.
        //  - 여기는 아직 좀 이해가 덜 되었기에 복기!
        Map<Integer, Integer> numsMap = new HashMap<>();

        // 하나의 for문 반복으로 통합
        for(int i = 0; i < nums.length; i++) {
            // target에서 num을 뺀 값이 있으면 정답으로 리턴!
            if(numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }

            // 정답이 아니라면 다음 번 비교를 위해 인덱스를 맵에 저장.
            numsMap.put(nums[i], i);
        }

        return null;
    }

    public static int[] answer4(int[] nums, int target) {

        // 4. 투 포인터 활용
        //  - 투 포인터의 시간 복잡도는 평균 O(n)이다.
        //  - 현재 문제가 Array 형식이 정렬된 상태여서 정상이지만, 코딩 테스트에서는 기본적으로 섞여있는 상태로 나오기 때문에
        //    정상적으로는 투포인터로 확인 할 수가 없다.
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left != right) {
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if(nums[left] + nums[right] < target) {
                left += 1;
            }
            // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
            else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }
        
        return null;

    }

}
