package 주앤.ch14;

/*
문제 : L1038. 이진 탐색 트리(BST)를 더 큰 수 합계 트리로
핵심 : [책] 중위순회로 노드 값 누적 (재귀)
못 푼 이유 : 누적 임에 재귀를 써야한다는 것, 그리고 중위순회까지는 생각을 했다.
		그러나, 중위순회는 왼쪽자식->부모->오른쪽자식 방향만 가능한 줄 알아서 막막했다.
		생각해보면 반대 방향이 되는 것이 당연한 건데 안일했다.
발상 키워드 : 누적 -> 재귀 / 트리 누적탐색 -> 이진탐색트리
 */
public class P56 {
	int sum = 0;

	public TreeNode bstToGst(TreeNode root) {
		if(root == null){
			return null;
		}

		// 오른쪽 노드부터 탐색
		bstToGst(root.right);

		sum += root.val;
		root.val = sum;

		// 왼쪽 노드도 탐색
		bstToGst(root.left);

		return root;
	}
}
