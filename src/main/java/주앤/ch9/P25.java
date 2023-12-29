package 주앤.ch9;

/**
 * 문제 : 622. Design Circular Queue
 * 풀이 : [책]
 * 해결 과정 : 처음엔 ArrayDeque 클래스를 사용하려고 했으나, 해당 문제는 큐가 한 번 가득 차면 이후에 추가할 수 없다는 조건을 가지고 있는데,
 * ArrayDeque 내부에선 동적으로 배열의 크기를 늘리기 때문에, 사용하기에 적합하지 않았다.
 *
 * 따라서, 책에서 투포인터로 맨 앞을 가리키는 front, 맨 뒤를 가리키는 rear 를 두고 구현한 방식을 이해하였다.
 * 배열은 그냥 저장 메모리일 뿐이고, front에서 rear까지의 요소가 하나의 원형 큐가 된다.
 *
 * 데이터는 항상 배열의 index 0부터 시작되어야 한다는 선입견 때문에 해당 생각을 떠올리지 못했다.
 */
public class P25 {
	class MyCircularQueue {
	    private int[] q;
	    private int front = 0, rear = -1, len = 0;

	    public MyCircularQueue(int k) {
	        q = new int[k];
	    }

	    public boolean enQueue(int value) {

	        if(!isFull()){
	            this.rear = (this.rear + 1) % this.q.length;
	            q[rear] = value;
	            len++;

	            return true;
	        }

	        return false;
	    }

	    public boolean deQueue() {
	        if(!isEmpty()){
	            this.front = (this.front + 1) % this.q.length;
	            len--;
	            return true;
	        }

	        return false;
	    }

	    public int Front() {
	        return isEmpty() ? -1 : q[front];
	    }

	    public int Rear() {
	        return isEmpty() ? -1 : q[rear];
	    }

	    public boolean isEmpty() {
	        return this.len == 0;
	    }

	    public boolean isFull() {
	        return this.q.length == this.len;
	    }
	}
}
