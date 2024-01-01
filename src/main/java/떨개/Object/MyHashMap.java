package 떨개.Object;

import java.util.Arrays;
import java.util.Map;

public class MyHashMap {

    static class Node {

        int key;
        int value;

        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    final Node[] map = new Node[100000];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = key % map.length;

        // 해당하는 index에 아무것도 없다면 새로운 Node를 만들어 종료한다.
        if(map[index] == null) {
            map[index] = new Node(key, value);
            return;
        }

        // 노드를 탐색하면서 종료 조건을 2가지로 가진다.
        //  1. 이미 키가 존재하는 경우 값을 업데이트하고 바로 빠져나가는 경우
        //  2. 다음 노드가 없을 때 루프를 빠져나가는 경우. 개별 체이닝을 통한 방식인데 이게 좀 이해가 가지 않는다.
        //   -> 1) node = node.next가 있는데 굳이 node.next == null 일 때 break를 걸 이유가 있을까?
        //   -> 2) 지금 예시가 Integer, Integer라서 확인이 불가하는것 같다.
        //      키가 유동적인 값일 텐데 그럼 next가 있을 이유로 확인이 가능할 거 같다.
        Node node = map[index];
        // System.out.println("put : node.key = " + node.key + " node.value = " + node.value + " node.next = " + node.next);
        while(node != null) {
            // 동일한 키가 있다면 값을 업데이트 하고 종료.
            //  -> 현재 P30에서는 Key가 숫자이므로 Index의 값과 동일하므로 이 if문이 항상 나타날 것이다.
            if(node.key == key) {
                node.value = value;
                return;
            }

            // 다음 노드가 없다면 종료
            if(node.next == null)
                break;

            // 다음 노드로 진행
            node = node.next;
        }

        // 마지막 노드 다음으로 연결
        node.next = new Node(key, value);
    }

    public int get(int key) {
        int index = key % map.length;
        if(map[index] == null)
            return -1;

        Node node = map[index];
        // System.out.println("get : node.key = " + node.key + " node.value = " + node.value + " node.next = " + node.next);
        while(node != null) {
            if(node.key == key) {
                return node.value;
            }

            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        // 해싱 결과를 인덱스로 지정
        int index = key % map.length;

        // 해당 인덱스에 노드가 없으면 종료
        if(map[index] == null)
            return;

        // 첫 번째 노드일 때 삭제 처리
        Node node = map[index];
        if(node.key == key) {
            // 다음 노드가 없으면 해당 인덱스는 null 처리
            if(node.next == null)
                map[index] = null;
            // 다음 노드가 있다면 다음 노드는 해당 인덱스로 지정
            else
                map[index] = node.next;
        }

        // 연결 리스트 노드일 때의 삭제 처리
        Node prev = node;
        while(node != null) {
            // 일치하는 키가 있다면
            if(node.key == key) {
                // 이전 노드의 다음에 현재 노드의 다음을 연결하고 리턴
                prev.next = node.next;
                return;
            }

            // 노드 한 칸씩 이동
            prev = node;
            node = node.next;
        }

    }
}
