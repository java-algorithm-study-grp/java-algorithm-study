package 주앤.ch14;

/*
문제 : 105. Construct Binary Tree from Preorder and Inorder Traversal

풀이 : [책] 전위 순회 결과로 중위 순회 분할 반복
		왼쪽 서브트리, 오른쪽 서브트리로 분할하는 노드를 중심으로 재귀 호출을 통해 트리 형성
못 푼 이유 : 왼쪽 서브트리 오른쪽 서브트리로 나누는 것 까진 계산 했으나, 이후 막힘.
			책 풀이를 보고도 이해하는데까지 1시간 30분 걸림.
			중위 순회 결과-> 특정 노드를 중심으로 왼쪽 순회는 왼쪽 서브트리, 오른쪽 순회는 오른쪽 서브트리로 분할됨.
 */
public class P59 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return dfs(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode dfs(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder){
		if(preIndex > preorder.length - 1 || inStart > inEnd){
			return null;
		}

		int inIndex = 0;

		// 전위순회결과의 현재 값을 가지는 중위순회결과의 인덱스를 찾아 저장
		for(int i = inStart; i <= inEnd; i++){
			if(preorder[preIndex] == inorder[i]){
				inIndex = i;
			}
		}

		// 전위순회결과의 현재 값으로 노드 생성
		TreeNode node = new TreeNode(preorder[preIndex]);
		preIndex++;

		// 중위 순회 결과에서 중심 인덱스의 오른쪽 서브트리 생성을 위한 재귀 호출
		node.left = dfs(preIndex, inStart, inIndex - 1, preorder, inorder);

		// preIndex에 현재 중위 순회에서의 인덱스를 더하여 오른쪽 서브트리로 이동
		// 중위순회결과 중심인덱스의 오른쪽서브트리 생성을 위한 메서드 호출
		node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
		return node;
	}
}
