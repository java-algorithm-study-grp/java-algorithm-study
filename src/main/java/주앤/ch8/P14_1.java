package 주앤.ch8;
/*
문제 : 21. Merge Two Sorted Lists
실행시간 및 메모리 : 0 ms / 41.8 MB
풀이 : [책] 둘 중 하나의 리스트를 head로 return하고 그 전에 재귀로 들어가면서, 다음 next를 하나씩 찾아서 연결하여 병합하는 방식
못풀었던 이유 :
    - 결과에 필요한 노드를 다 생성해서 return하고 연결해야 한다고 생각 함.
    - 재귀를 떠올리지 못함.
나만의 연상 하는 방법 만들기 :
    - 둘 중 하나로 결론을 내어놓고(헤드), 그 둘을 계속 비교하며 찾는 것 -> 재귀 연상

체감 난이도 : 4/5
 */
public class P14_1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
