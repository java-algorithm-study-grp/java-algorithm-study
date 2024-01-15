package src.main.java.우형.ch14;

import src.main.java.우형.object.TreeNode;

public class P59 {


    public TreeNode dfs(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIndex > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preIndex]) {
                inIndex = i;
            }
        }

        TreeNode node = new TreeNode(inorder[inIndex]);
        preIndex++;
        node.left = dfs(preIndex, inStart, inIndex - 1, preorder, inorder);
        node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }

}


