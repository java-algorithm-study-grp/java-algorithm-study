package 주앤.ch11;
/**
 * 문제 : 706. Design HashMap
 * 핵심 : [책] 참고. 연결리스트+배열로 연결 체이닝으로 HashMap 구현.
 * 		해시함수는 Integer의 hashCode 메소드 활용
 **/
public class p30 {
	class MyHashMap {
	    private Node[] list;
	    private static final int SIZE = 10000;

	    public MyHashMap() {
	        list = new Node[SIZE];
	    }

	    // 세 가지 경우 :
	    // 1. 인덱스에 노드가 없을 때, 새 노드 삽입
	    // 2. 인덱스에 노드가 있고 키가 같을 때, 값만 수정
	    // 3. 인덱스에 노드가 있으나 키는 없을 때, 마지막 노드로 새 노드 삽입
	    public void put(int key, int value) {
	        int index = getIndex(key);
	        Node head = list[index];
	        Node node = new Node(key, value);

	        if(head == null){
	            list[index] = node;
	            return;
	        }

	        while(head != null){
	            if(head.key == key){
	                head.value = value;
	                return;
	            }
	            if(head.next == null){
	                break;
	            }
	            head = head.next;
	        }
	        head.next = node;
	    }

	    public int get(int key) {
	        int index = getIndex(key);
	        Node head = list[index];

	        while(head != null){
	            if(head.key == key){
	                return head.value;
	            }
	            head = head.next;
	        }

	        return -1;
	    }

	    public void remove(int key) {
	        int index = getIndex(key);
	        Node head = list[index];

	        if(head == null){
	            return;
	        }

	        // 첫 번째 노드가 키가 같은 경우
	        if(head.key == key){
	            if(head.next == null){ // 노드가 하나인 경우
	                list[index] = null;
	                return;
	            }else{ // 노드가 둘 이상인 경우
	                list[index] = head.next;
	                return;
	            }
	        }

	        // 두 번째 이상의 노드와 키가 같은 경우
	        while(head.next != null){
	            if(head.next.key == key){
	                head.next = head.next.next;
	                return;
	            }
	            head = head.next;
	        }
	    }

	    public int getIndex(int key){
	        return Integer.hashCode(key) % SIZE;
	    }

	    static class Node{
	        int key;
	        int value;
	        Node next;

	        Node(){}

	        Node(int key, int value){
	            this.key = key;
	            this.value = value;
	        }
	    }
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
}
