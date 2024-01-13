package 떨개.ch14;

import 떨개.Object.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P47 {

    public static void main(String[] args) {
        // Ch14. 트리
        //  - 47. 이진 트리의 최대 깊이
        //   1) 이진 트리의 최대 깊이를 구하라.
        //    - input1: [3, 9, 20, null, null, 15, 7]
        //    - output1: 3
        //    - input2: [1, null, 2]
        //    - output2: 2
        TreeNode root = new TreeNode(new Integer[] {3, 9, 20, null, null, 15, 7});
        // TreeNode root = new TreeNode(new Integer[] {1, null, 2});

        System.out.println(maxDepth1(root));
        System.out.println(maxDepth2(root));

    }

    private static int maxDepth1(TreeNode root) {

        // 1. BFS를 사용한 Node 탐색
        //  - 책을 일부 확인 후 스스로 풀어보려고 노력.
        //  - 기본적으로 알고 있는 이진 트리의 탐색 기능과 같다고 생각함.

        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while(!queue.isEmpty()) {
            depth += 1;
            // System.out.println("queue = " + queue + " depth = " + depth);
            int q_size = queue.size();

            for(int i = 0; i < q_size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }

        }

        return depth;
    }

    private static int maxDepth2(TreeNode root) {

        // 2. DFS를 통한 Depth의 최대 크기 계산
        //  - BFS로 트리의 한층한층 찾는 식이었지만 이 문제는 '최대 깊이의 값'을 측정하는 것을 찾고 있다.
        //  - 즉 DFS(Depth First Search)로 깊이의 최대 값을 측정할 수 있지 않을까?
        // System.out.println("root = " + root);

        if (root == null) return 0;

        // 먼저 왼쪽을 탐색하기 때문에 쭉 탐색한다.
        int left = maxDepth2(root.left);
        // 이 후 왼쪽이 없다면 오른쪽을 탐색한다.
        int right = maxDepth2(root.right);

        return Math.max(left, right) + 1;
    }

}
