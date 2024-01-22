package 주앤.ch15;
/*
문제 : L215.배열의 K번째 큰 엘리먼트 (정렬없이)
풀이 : 배열로 최대힙을 구현하여 활용
힙 개념 : 항상 추출할 때는 가장 큰 값이 추출되고, 다른 값들은 정렬되어 있지 않다.
		힙은 최댓값이나 최솟값을 추출할 때 효율적으로 사용되는 완전이진트리 자료구조이다.
		힙으로 최댓값을 추출하는 시간복잡도는 O(log n) 이다. (반면, 브루트포스 활용 시, O(n) )
 */
public class P60 {
	static class MaxHeap{
		int[] heap;
		int size;
		int maxSize;

		MaxHeap(int maxSize){
			heap = new int[maxSize + 1]; // 인덱스는 1부터 시작임으로 1을 더함.
			size = 0;
			this.maxSize = maxSize;
		}

		void push(int item){

			size++;
			int current = size;

			while (current != 1 && heap[current/2] < item){ // 현재 위치가 루트가 아니고, 부모의 값보다 크다면

				// 현재 위치에 부모의 값을 저장
				heap[current] = heap[current/2];

				// 현재 위치를 부모 위치로 저장
				current = current/2;
			}
			heap[current] = item;
		}

		void pop(){
			if (size == 1){  // 값이 한 개라면 return
				return;
			}

			int lastVal = heap[size];
			int current = 1;
			int child = 2;
			size--;

			while (child <= size){

				// 왼쪽 자식과 오른쪽 자식 중에 더 큰 자식의 인덱스를 저장
				if (child + 1 <= size){
					if (heap[child] < heap[child+1]){
						child = child + 1;
					}
				}

				// 자식보다 현재 값이 더 작다면, 자식을 현재 위치에 저장
				if (lastVal >= heap[child]){
					break;
				}

				// 현재 위치에 자식의 값을 저장
				heap[current] = heap[child];

				// 현재 위치를 자식 위치로 저장
				current = child;
				// 현재 위치의 자식 위치를 구하여 자식 위치에 저장
				child = current*2;
			}

			heap[current] = lastVal;
		}
	}


	public int findKthLargest(int[] nums, int k) {
		MaxHeap maxHeap = new MaxHeap(nums.length);

		for (int num : nums){
			maxHeap.push(num);
		}

		for (int i = 1; i < k; i++){
			maxHeap.pop();
		}

		return maxHeap.heap[1];
	}
}
