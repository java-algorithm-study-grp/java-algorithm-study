package 떨개.ch14;

import 떨개.Object.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P48 {

    static int longest = 0;

    public static void main(String[] args) {
        // Ch14. 트리
        //  - 48. 이진 트리의 직경
        //   1) 이진 트리에서 두 노드 간 가장 긴 경로의 길이를 출력하라.
        //    - input1: [1,2,3,4,5]
        //    - output1: 3
        //    - input2: [1,2]
        //    - output2: 1

        TreeNode root = new TreeNode(new Integer[]{1, 2, 3, 4, 5});
        // TreeNode root = new TreeNode(new Integer[]{1, 2});
        // TreeNode root
        //      = new TreeNode(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null
        //          ,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2}); // 리트코드의 예제인데 해결이 안됨.


        System.out.println(diameterOfBinaryTree1(root));
    }

    private static int diameterOfBinaryTree1(TreeNode root) {
        // 1. DFS를 이용한 끝 노드의 계산식
        //  - 끝의 노드를 사용하는 방식이라는 것은 알았지만 max 계산처리를 어떻게 해야할 지 몰랐습니다.
        //  - 책을 보고 이해가 바로 갔습니다... 다시 풀어 볼 예정.

        dfs(root);
        return longest;
    }

    private static int dfs(TreeNode root) {
        if(root == null) return -1;

        int left = dfs(root.left);
        int right = dfs(root.right);

        System.out.println("root = " + root);
        System.out.println("left = " + left + " right = " + right);

        longest = Math.max(longest, left + right + 2);

        return Math.max(left, right) + 1;
    }
}
