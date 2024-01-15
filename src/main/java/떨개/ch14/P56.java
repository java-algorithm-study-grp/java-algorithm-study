package 떨개.ch14;

import 떨개.Object.TreeNode;

import java.util.*;

public class P56 {

    static Integer sum = 0;

    public static void main(String[] args) {
        // Ch14. 트리
        //  - 56. 이진 탐색 트리(BST)를 더 큰 수 합계 트리로
        //   1) BST의 각 노드를 자신과 자신보다 더 큰 값을 가진 모든 노드의 합으로 만들어라.
        //      - 참고로 이진 검색 트리는 다음 제약 조건을 충족하는 트리입니다.
        //      - 노드의 왼쪽 하위 트리에는 해당 노드의 키 보다 작은 키를 가진 노드만 포함됩니다.
        //      - 노드의 오른쪽 하위 트리에는 노드의 키 보다 큰 키를 가진 노드만 포함됩니다.
        //      - 왼쪽 및 오른쪽 하위 트리도 모두 이진 검색 트리여야 합니다.
        //    - input1: [4, 1, 6, 0, 2, 5, 7, null, null, 3, null, null, null, null, 9]
        //    - output1: [31, 37, 22, 37, 36, 27, 16, null, null, 34, null, null, null, 9]
        //    - input2: [4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8]
        //    - output2: [30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8]
        TreeNode root = new TreeNode(4, 1, 6, 0, 2, 5, 7, null, null, 3, null, null, null, null, 9);
        // TreeNode root = new TreeNode(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);

        // System.out.println("preorder(전위 순회) 실행");
        // preorder(root);
        // System.out.println("inorder(중위 순회) 실행");
        // inorder(root);
        // System.out.println("postorder(후위 순회) 실행");
        // postorder(root);
        // System.out.println("testorder(테스트 순회) 실행");
        // testorder(root);
        // System.out.println("testorder2(테스트 순회) 실행");
        // testorder2(root);

        System.out.println(bstToGst(root));

    }

    private static TreeNode bstToGst(TreeNode root) {

        // 1. 순회
        //  - 우측 아래의 노드부터 쭉 계산하는 식으로 해야할 듯하다.
        //  - 오른쪽 노드 -> 루트 -> 왼쪽 노드 순.
        //  - 순회를 통한 해당 노드의 합계 값을 찾았으나, 이를 TreeNode로 반환할 때의 표현은 어떻게 정의하는가?!
        //    -> root를 그대로 덮어쓰기 하는 식으로 하니까 원하는 답안이 나오긴 했다.
        //    -> 다만, 해당 root.val를 합계를 할 때 static으로 바깥 변수로 처리를 했는데 내부 변수로 할 수 없을까?
        //    -> 책에서 확인한 결과, sum(책에서 val)는 계속 누적되야하는 값이기 때문에 클래스 멤버 변수로 선언을 했다.
        testorder(root);

        return root;
    }

    private static void preorder(TreeNode root) {
        // 전위 순회(루트, 왼쪽 노드, 오른쪽 노드 순으로 조회)
        if(root != null) {
            System.out.println("root.val = " + root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static void inorder(TreeNode root) {
        // 중위 순회(왼쪽 노드, 루트, 오른쪽 노드 순으로 조회)
        if(root != null) {
            inorder(root.left);
            System.out.println("root.val = " + root.val);
            inorder(root.right);
        }
    }

    private static void postorder(TreeNode root) {
        // 후위 순회(왼쪽 노드, 오른쪽 노드, 루트 순으로 조회)
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println("root.val = " + root.val);
        }
    }

    private static void testorder(TreeNode root) {
        // 테스트 순회(오른쪽 노드, 루트, 왼쪽 노드 순으로 조회)
        if(root != null) {
            testorder(root.right);
            // System.out.println("root = " + root + " root.val = " + root.val);
            sum += root.val;
            // System.out.println("sum = " + sum);
            root.val = sum;
            testorder(root.left);
        }
    }

    private static void testorder2(TreeNode root) {
        // 테스트 순회2(오른쪽 노드, 왼쪽 노드, 루트 순으로 조회)
        if(root != null) {
            testorder2(root.right);
            testorder2(root.left);
            System.out.println("root = " + root + " root.val = " + root.val);
        }
    }


}
