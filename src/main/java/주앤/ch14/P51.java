package 주앤.ch14;

/*
문제 : 617. Merge Two Binary Trees (두 이진 트리 병합)
풀이 : 두 트리의 각 노드를 동일한 위치에 있는 노드끼리 합쳐서 새로운 트리를 생성함.
	재귀 호출되는 메서드는 현재 노드의 값을 합산하고, 왼쪽 서브트리와 오른쪽 서브트리에 대해 재귀적으로 메서드를 호출하여,
	새로운 서브트리를 생성한다.

	한 트리가 NULL이면, 다른 트리를 반환하여 병합이 이루어진다.
 */
public class P51 {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return merge(root1, root2);
	}

	public TreeNode merge(TreeNode root1, TreeNode root2){

		if(root1 == null){
			return root2;
		}
		if(root2 == null){
			return root1;
		}
		return new TreeNode(root1.val + root2.val, merge(root1.left, root2.left), merge(root1.right, root2.right));
	}
}
