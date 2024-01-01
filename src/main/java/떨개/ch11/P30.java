package 떨개.ch11;

import 떨개.Object.MyHashMap;

import java.util.HashMap;

public class P30 {

    public static void main(String[] args) {
        // Ch11. 해시 테이블
        //  - 30. 해시맵 디자인
        //   1) 다음과 같은 기능을 제공하는 해시맵을 디자인하라.
        //   2) put(key, value): 키, 값을 해시맵에 삽입한다. 만약 이미 존재하는 키라면 업데이트한다.
        //   3) get(key): 키에 해당하는 값을 조회한다. 만약 키가 존재하지 않는다면 -1을 리턴한다.
        //   4) remove(key): 키에 해당하는 키, 값을 해시맵에서 삭제한다.

        // hashMap1();
        hashMap2();
    }

    private static void hashMap1() {

        // 1. 개별 체이닝 방식을 이용한 해시 테이블 구현
        //  - Node와 MyHashMap을 이용한 방식, Node 클래스만 구현 후 기능을 스스로 만드는 중.
        //  - 도무지 이해가 가지 않는 방식이다... 왜 next가 있고 prev가 있는지 감도 잡히지 않는다.

        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1)); // 1 리턴
        System.out.println(hashMap.get(3)); // -1 리턴
        System.out.println(hashMap.get(2)); // 2 리턴
        hashMap.put(2, 1); // Key 2에 해당하는 Value를 1로 갱신
        System.out.println(hashMap.get(2)); // 1 리턴
        hashMap.remove(2); // Key 2에 해당하는 Key, Value를 삭제
        System.out.println(hashMap.get(2)); // -1 리턴

    }

    private static void hashMap2() {
        // 2. HashMap을 이용한 방식
        //  - 구현체 HashMap을 이용하는 방식. 매우 쉬울 것.
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1)); // 1 리턴
        System.out.println(hashMap.get(3)); // null 리턴
        System.out.println(hashMap.get(2)); // 2 리턴
        hashMap.put(2, 1); // Key 2에 해당하는 Value를 1로 갱신
        System.out.println(hashMap.get(2)); // 1 리턴
        hashMap.remove(2); // Key 2에 해당하는 Key, Value를 삭제
        System.out.println(hashMap.get(2)); // null 리턴

    }
}
