package 원석.ch14;

public class P51 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 한쪽이 널이면 널이 아닌 노드를 리턴한다.
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        // 병합된 노드 생성
        TreeNode node = new TreeNode(root1.val + root2.val);
        // 병합된 노드의 자식 노드로 기존 노드 왼쪽 자식 노드 DFS 진행
        node.left = mergeTrees(root1.left, root2.left);
        // 병합된 노드의 자식 노드로 기존 노드 오른쪽 자식 노드 DFS 진행
        node.right = mergeTrees(root1.right, root2.right);
        // 병합된 노드 리턴
        return node;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        P51 merger = new P51();
        TreeNode mergedTree = merger.mergeTrees(root1, root2);

        // Example 2
        TreeNode singleRoot1 = new TreeNode(1);
        TreeNode root2WithChild = new TreeNode(1);
        root2WithChild.right = new TreeNode(2);

        TreeNode mergedSingleTree = merger.mergeTrees(singleRoot1, root2WithChild);
    }
}
