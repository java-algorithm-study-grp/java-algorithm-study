package 떨개.ch14;

import 떨개.Object.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P59 {

    public static void main(String[] args) {
        // Ch14. 트리
        //  - 59. 전위, 중위 순회 결과로 이진 트리 구축
        //   1) 트리의 전위, 중위 순의 결과를 입력값으로 받아 이진 트리를 구축하라.
        //    - 전위는 (루트 -> 왼쪽 -> 오른쪽) / 중위는 (왼쪽 -> 루트 -> 오른쪽) / 후위는 (왼쪽 -> 오른쪽 -> 루트)
        //    - 전위1: [1, 2, 4, 5, 3, 6, 7, 9 ,8]
        //    - 중위1: [4, 2, 5, 1, 7, 9, 6, 8, 3]
        //    - 결과1: [1
        //              , 2, 3
        //              , 4, 5, 6, null
        //              , null, null, null, null, 7, 8, null, null
        //              , null * 8, null , 9, null * 4]
        //    - 전위2: [3, 9, 20, 15, 7]
        //    - 중위2: [9, 3, 15, 20, 7]
        //    - 결과2: [3, 9, 20, null, null, 15, 7]
        int[] preorder = new int[] {1, 2, 4, 5, 3, 6, 7, 9 ,8};
        int[] inorder = new int[] {4, 2, 5, 1, 7, 9, 6, 8, 3};
        // int[] preorder = new int[] {3, 9, 20, 15, 7};
        // int[] inorder = new int[] {9, 3, 15, 20, 7};

        // System.out.println(buildTree1(preorder, inorder));
        System.out.println(buildTree2(preorder, inorder));
    }

    private static TreeNode buildTree1(int[] preorder, int[] inorder) {

        // 1. 전위 순회 결과를 통해 중위 순회 분할 정복
        //  - 전위의 첫 번째 값은 무조건 root에 해당하는 초기값이다.
        //  - 책의 풀이를 보고 바로 이해는 했습니다. 다시 지우고 진행할 예정.
        return dfs1(0, 0, inorder.length - 1, preorder, inorder);
    }

    private static TreeNode buildTree2(int[] preorder, int[] inorder) {
        // 2. 참조형(1번의 dfs문에서 배열이 아닌 List로 진행)
        // - 이 또한 1번 문제의 코드 개선형이라 보고 바로 이해는 했습니다. 다시 지우고 진행할 예정.
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        for (int i : preorder)
            pre.add(i);

        for (int i : inorder)
            in.add(i);

        return dfs2(pre, in);
    }

    private static TreeNode dfs1(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {

        if(preIndex > preorder.length - 1 || inStart > inEnd)
            return null;

        // 전위 순회 값이 중위 순회에서는 몇 번째 인덱스 인지 추출
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preIndex])
                inIndex = i;
        }

        // 해당 인덱스는 중위 순회를 분할하는 노드로 지정 -> 제일 맨 위의 부모 노드
        TreeNode node = new TreeNode(inorder[inIndex]);
        // 전위 순회 다음 결과를 보도록 인덱스 + 1
        preIndex++;
        // 왼쪽 자식 노드부터 진행
        node.left = dfs1(preIndex, inStart, inIndex - 1, preorder, inorder);
        // 남은 지역으로 오른쪽 자식 노드 진행
        node.right = dfs1(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

        return node;
    }

    private static TreeNode dfs2(List<Integer> preorder, List<Integer> inorder) {

        if(inorder.isEmpty())
            return null;

        // 전위 순회 값이 중위 순회에서 몇 번째 인덱스인지 추출
        int inIndex = inorder.indexOf(preorder.get(0));
        // 해당 인덱스는 제일 맨 위 부모 노드임.
        TreeNode node = new TreeNode(inorder.get(inIndex));

        // 왼쪽에 해당하는 중위 순회 지역을 탐색
        node.left = dfs2(preorder.subList(1, inIndex + 1), inorder.subList(0, inIndex));
        // 오른쪽에 해당하는 중위 순회 지역을 탐색
        node.right = dfs2(preorder.subList(inIndex + 1, preorder.size()), inorder.subList(inIndex + 1, inorder.size()));

        return node;
    }
}
