package 원석.ch14;

public class P56 {
    // 각 노드의 값을 설정하기 위한 변수 선언
    int val = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            // 오른쪽 자식 노드부터 탐색
            bstToGst(root.right);
            // 누적된 값에 현재 노드 값 추가
            val += root.val;
            // 현재 노드 값을 지금까지 누적된 값으로 할당
            root.val = val;
            // 왼쪽 자식 노드 탐색
            bstToGst(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        root1.left.right.right = new TreeNode(3);
        root1.right.right.right = new TreeNode(8);

        P56 solution1 = new P56();
        TreeNode result1 = solution1.bstToGst(root1);
        // Print or process the result as needed

        // Example 2
        TreeNode root2 = new TreeNode(0);
        root2.right = new TreeNode(1);

        P56 solution2 = new P56();
        TreeNode result2 = solution2.bstToGst(root2);
        // Print or process the result as needed
    }
}
