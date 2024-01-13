package 떨개.ch14;

import 떨개.Object.TreeNode;

import java.util.*;

public class P51 {

    public static void main(String[] args) {
        // Ch14. 트리
        //  - 51. 두 이진 트리 병합
        //   1) 두 이진 트리를 병합하라. 중복되는 노드는 값을 합산한다.
        //    - input1-1: [1, 4, 2, 5]
        //    - input1-2: [2, 1, 3, null, 4, null, 7]
        //    - output1: [3, 5, 5, 5, 4, null, 7]
        //    - input2-1: [1]
        //    - input2-2: [1, 2]
        //    - output2: [2, 2]
        TreeNode root1 = new TreeNode(new Integer[] {1, 4, 2, 5});
        TreeNode root2 = new TreeNode(new Integer[] {2, 1, 3, null, 4, null, 7});

        mergeNodes1(root1, root2);
        // mergeNodes2(root1, root2);
    }

    private static TreeNode mergeNodes1(TreeNode root1, TreeNode root2) {

        // 1. BFS 탐색
        //  - 47번 문제의 한 방법인 BFS 방식으로 풀어볼 예정.
        //  - null에 대한 값을 0으로 처리나 new TreeNode(0)으로 하면 무한 재귀가 걸려 방법이 없는 듯 합니다.
        //    좀 더 찾아보려고 했으나 방법이 없어 여기까지만 작성하겠습니다.

        // Queue<TreeNode> queue1 = new LinkedList<>();
        // Queue<TreeNode> queue2 = new LinkedList<>();
        //
        // queue1.offer(root1);
        // queue2.offer(root2);
        //
        // List<Integer> list1 = new ArrayList<>();
        // List<Integer> list2 = new ArrayList<>();
        //
        // while(!queue1.isEmpty()) {
        //
        //     int q1_size = queue1.size();
        //
        //     for(int i = 0; i < q1_size; i++) {
        //         TreeNode node1 = queue1.poll();
        //
        //         list1.add(node1.val);
        //
        //         if(node1.left != null) queue1.offer(node1.left);
        //         if(node1.right != null) queue1.offer(node1.right);
        //     }
        // }
        //
        // System.out.println("list1 = " + list1);
        //
        // while(!queue1.isEmpty()) {
        //     int q2_size = queue2.size();
        //
        //     for(int i = 0; i < q2_size; i++) {
        //
        //     }
        // }
        //
        return null;
    }

    private static TreeNode mergeNodes2(TreeNode root1, TreeNode root2) {

        // 2. 재귀 DFS
        //  - 47번 문제의 한 방법인 재귀 DFS를 참조하여 풀 생각이었습니다.
        //  - 그러나 if로 처리하지 않았으며, 어떤 값이 left, right를 정의하지 않아 무한 재귀가 계속 발생했습니다.
        //  - 책을 본 후 바로 이해가 되었으나 반성을 해야할 듯 합니다.

        // - 풀었던 방식
        // Integer num1 = root1 == null ? 0 : root1.val;
        // Integer num2 = root2 == null ? 0 : root2.val;
        //
        // TreeNode tree = new TreeNode(num1 + num2);
        //
        // System.out.println("tree = " + tree);
        //
        // mergeNodes2(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        // mergeNodes2(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

        // - 책 풀이 방식
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        TreeNode tree = new TreeNode(root1.val + root2.val);

        tree.left = mergeNodes2(root1.left, root2.left);
        tree.right = mergeNodes2(root1.right, root2.right);

        return tree;
    }

}
