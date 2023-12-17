package 떨개.ch8;

import 떨개.Object.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class P13 {

    public static void main(String[] args) {
        // Ch08. 연결 리스트
        //  - 13. 펠린드롬 연결 리스트
        //   1) 연결 리스트가 팰린드롬(6장 참고) 구조인지 판별하라.
        //    - 펠린드롬이란?
        //     -> 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말, 숫자, 문자열 등을 의미한다.
        LinkedList<Integer> list = new LinkedList<>(List.of(1,2,3,3,2,1));
        ListNode node = ListNode.of(1,2,3,4,3,2,1);

        // System.out.println(isPalindrome1(list));
        // System.out.println(isPalindrome2(node));
        System.out.println(isPalindrome3(node));

    }

    private static boolean isPalindrome1(LinkedList<Integer> list) {

        // 1. LinkedList (연결 리스트)에 넣어서 직접 확인하는 방법
        //  - 스스로 문제를 확인하여 풀어본 방식
        //  - 해당 풀이는 풀이 2. '데크'를 이용한 풀이와 동일하다.
        
        // List가 비어있지 않거나 개수가 2개 이상인 경우에만 체크하는 식
        while(!list.isEmpty() && list.size() > 1) {
            // 해당 기능은 LinkedList의 Stack, Queue, Deque 지원으로 전용 메서드를 받아 사용하고 있다.
            // pollFirst : LinkedList 제일 앞의 노드를 갖고온 후 제거(Stack)
            // pollLast : LinkedList 제일 뒤의 노드를 갖고온 후 제거(Stack)
            if(!Objects.equals(list.pollFirst(), list.pollLast())) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome2(ListNode node) {
        // 2. ListNode를 사용하여 풀어보는 방법
        //  - 풀이 1. '스택'을 이용한 풀이를 이용한 방식
        //  - Leetcode에서는 'ListNode'라는 아예 다른 객체를 이용하여 사용하고 있다.

        // 책에서 스택을 이런 식으로 선언하면 안된다고 되어있지만, Stack이 주인 9장에서 설명한다고 쓰여있다.
        Stack<Integer> stack = new Stack<>();

        // 연결 노드를 스택에 삽입
        ListNode node1 = node;
        while(node1 != null) {
            stack.add(node1.val);
            node1 = node1.next;
        }

        // 연결 노드가 모두 빌 때까지 비교
        while(node != null) {
            if(node.val != stack.pop()) {
                return false;
            }

            node = node.next;
        }

        return true;
    }

    private static boolean isPalindrome3(ListNode node) {

        // 3. ListNode를 사용하여 풀어보는 방법
        //  - 풀이 3. '러너'을 이용한 우아한 풀이
        //  - 러너란? 러너(Runner)는 연결 리스트를 순회할 때 2개의 포인터를 동시에 사용하는 기법
        //  - 아무리 봐도 제일 이해가 가질 않아서 몇 번 정독해야 할 것 같다.
        ListNode fast = node, slow = node;

        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만든다.
        ListNode rev = null;
        while(slow != null) {
            // 느린 러너로 역순 연결 리스트를 만든다.

            // 연결 리스트 [1,2,3,4,3,2,1] 기준
            // slow = ListNode{val=4, next=ListNode{val=3, next=ListNode{val=2, next=ListNode{val=1, next=null}}}}
            // rev = null
            // next = ListNode{val=3, next=ListNode{val=2, next=ListNode{val=1, next=null}}}

            // slow = ListNode{val=3, next=ListNode{val=2, next=ListNode{val=1, next=null}}}
            // rev = ListNode{val=4, next=null}
            // next = ListNode{val=2, next=ListNode{val=1, next=null}}

            // slow = ListNode{val=2, next=ListNode{val=1, next=null}}
            // rev = ListNode{val=3, next=ListNode{val=4, next=null}}
            // next = ListNode{val=1, next=null}

            // slow = ListNode{val=1, next=null}
            // rev = ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=null}}}
            // next = null

            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }

        // System.out.println(node.toString());
        // System.out.println(rev.toString());

        // rev 연결 리스트를 끝까지 이동하여 비교
        while(rev != null) {
            // 역순 연결 리스트 rev와 기존 연결 리스트 node를 차례대로 비교
            if(rev.val != node.val) {
                return false;
            }
            rev = rev.next;
            node = node.next;
        }


        return true;
    }
}
