package 떨개.ch12;

import java.util.*;

public class P41 {

    public static void main(String[] args) {
        // Ch12. 그래프
        //  - 41. 일정 재구성
        //   1) [from, to]로 구성된 항공권 목록을 이용해 JFK에서 출발하는 여행일정을 구성하라.
        //      여러 일정이 있는 경우 사전 어휘순으로 방문한다.
        //    - input1: [["MUC", "ICN"], ["JFK", "MUC"], ["SFO", "SJC"], ["ICN", "SFO"]]
        //    - output1: ["JFK", "MUC", "ICN", "SFO", "SJC"]
        //    - input2: [["JFK", "ICN"], ["JFK", "ATL"], ["ICN", "ATL"], ["ATL", "ICN"], ["ATL", "JFK"]]
        //    - output2: ["JFK", "ATL", "ICN", "ATL", "JFK", "ICN"]

        List<List<String>> tickets = new ArrayList<>() {{
            // input 1
            // add(List.of("MUC", "ICN"));
            // add(List.of("JFK", "MUC"));
            // add(List.of("SFO", "SJC"));
            // add(List.of("ICN", "SFO"));

            // input 2
            add(List.of("JFK", "ICN"));
            add(List.of("JFK", "ATL"));
            add(List.of("ICN", "ATL"));
            add(List.of("ATL", "ICN"));
            add(List.of("ATL", "JFK"));
        }};

        System.out.println(findItinerary(tickets));
    }

    private static List<String> findItinerary(List<List<String>> tickets) {

        List<String> travel = new LinkedList<>();
        Map<String, PriorityQueue<String>> ticket_map = new HashMap<>();

        // HashMap으로 넣는 건 책을 봤음. 이 후 작업을 스스로 깨닫기 전까지 계속 해보려고 함.
        //  - 사전 어휘순으로 해야한다니까, HashMap에서 만들어 질 때부터 순서를 진행해야 할 듯 하다.
        //  - 그래서 해당 값에 PriorityQueue(우선순위 큐)를 넣어서 출력하는 식으로 생각했다.
        //    이유는 해당 우선순위 큐의 기본 정렬 값은 오름차순 이기 때문.

        for (List<String> ticket : tickets) {
            if(!ticket_map.containsKey(ticket.get(0)))
                ticket_map.put(ticket.get(0), new PriorityQueue<>(List.of(ticket.get(1))));
            else {
                PriorityQueue<String> value = ticket_map.get(ticket.get(0));
                value.add(ticket.get(1));
                ticket_map.put(ticket.get(0), value);
            }
        }

        System.out.println("ticket_map = " + ticket_map);

        // dfs1(travel, ticket_map, "JFK");
        // dfs2(travel, ticket_map, "JFK");
        dfs3(travel, ticket_map);

        return travel;
    }

    private static void dfs1(List<String> travel, Map<String, PriorityQueue<String>> ticket_map, String start) {

        // 1. 재귀 DFS 형식
        travel.add(start);

        // 해당하는 출발 지점의 키가 존재하거나, Value가 남아있는 경우
        if(ticket_map.containsKey(start) && !ticket_map.get(start).isEmpty()) {

            // 해당 사전 어휘 순의 값을 꺼낸다.
            PriorityQueue<String> queue = ticket_map.get(start);
            String next = queue.poll();

            // 이 후 Map을 갱신하고
            ticket_map.put(start, queue);

            // 재귀를 작동한다.
            dfs1(travel, ticket_map, next);
        }
    }

    private static void dfs2(List<String> travel, Map<String, PriorityQueue<String>> ticket_map, String start) {

        // 2. 반복문 형식
        //  - 좀 특이한 형태의 문제라서 반복문이 가능할 거 같다.

        // 현재 본인이 풀어 본 방식
        while(!ticket_map.isEmpty()) {
            if(!ticket_map.containsKey(start) || ticket_map.get(start).isEmpty()) return;

            travel.add(start);

            PriorityQueue<String> queue = ticket_map.get(start);
            String next = queue.poll();

            // While문을 멈추게 하기 위해 위와 다르게 삭제를 추가함.
            if(queue.isEmpty()) ticket_map.remove(start);
            else ticket_map.put(start, queue);

            start = next;
        }

        travel.add(start);

    }

    private static void dfs3(List<String> travel, Map<String, PriorityQueue<String>> ticket_map) {

        // 3. 반복문 형식
        //  - 책에서 풀이를 본 방식
        Deque<String> stack = new ArrayDeque<>();

        // 출발지 삽입
        stack.push("JFK");
        while(!stack.isEmpty()) {
            // 스택에서 추출될 값을 출발지로 한 도착지 처리
            while(ticket_map.containsKey(stack.getFirst()) && !ticket_map.get(stack.getFirst()).isEmpty()) {
                // 여러 도착지 중 사전 어휘순으로 추출해 스택에 삽입
                stack.push(ticket_map.get(stack.getFirst()).poll());
            }

            // 위 반복문이 모두 실행된 이후에는 스택에서 값이 하나씩 추출되어 정답으로 구성된다.
            travel.add(0, stack.pop());
        }
    }
}
