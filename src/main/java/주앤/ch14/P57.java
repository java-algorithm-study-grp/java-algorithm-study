package 주앤.ch14;

/*
문제 : L938. Range Sum of BST
풀이 : 중위순회를 돌며, 범위 안에 드는 수를 합한다.
이진 탐색 트리라 중위순회로 돌게 되면 오름차순으로 탐색을 하게 되는게 설명에 편리하기 때문에 사용했는데,
사실 모든 노드를 순회할 수 있다면 굳이 중위 순회를 사용하지 않고 DFS, BFS 등 모두 사용할 수 있다.
 */
public class P57 {
	int sum = 0;

	public int rangeSumBST(TreeNode root, int low, int high) {
		if(root == null){
			return 0;
		}

		if(root.left != null){
			rangeSumBST(root.left, low, high);
		}

		int num = root.val;
		if(num >= low && num <= high){
			sum += root.val;
		}

		if(root.right != null){
			rangeSumBST(root.right, low, high);
		}

		return sum;
	}
}
