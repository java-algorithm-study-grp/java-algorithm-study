package src.main.java.우형.ch12;

import java.util.*;

public class P41 {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));

        }

        dfs(results, fromToMap, "JFK");
        return results;
    }

    public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap,
                    String from) {
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }

        results.add(0, from);

    }
}
