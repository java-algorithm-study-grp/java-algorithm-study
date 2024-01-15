package 떨개.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // TreeNode Integer 배열로 처리 하는 법
    public TreeNode(Integer... integers) {
        List<TreeNode> list = new ArrayList<>();
        this.val = integers[0];
        for (Integer integer : integers) {
            list.add(integer == null ? null : new TreeNode(integer));
        }

        // 배열의 길이가 1보다 크다면 왼쪽 트리로 정의
        if(integers.length > 1) {
            this.left = list.get(1);
        }

        // 배열의 길이가 2보다 크다면 오른쪽 트리로 정의
        if(integers.length > 2) {
            this.right = list.get(2);
        }

        for(int i = 3; i < integers.length; i++) {
            // 더 큰 값에서 왼쪽/오른쪽 트리 정의
            if(i % 2 == 0) {
                // 4, 6... 등의 index는 바로 위의 트리 오른쪽 트리로 정의
                list.get((i - 1) / 2).right = list.get(i);
            } else {
                // 3, 5... 등의 index는 바로 위의 트리 왼쪽 트리로 정의
                list.get((i - 1) / 2).left = list.get(i);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
