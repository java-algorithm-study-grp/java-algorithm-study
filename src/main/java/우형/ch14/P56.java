package src.main.java.우형.ch14;


public class P56 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            val += root.val;
            root.val = val;
            bstToGst(root.left);
        }

        return root;
    }
}



