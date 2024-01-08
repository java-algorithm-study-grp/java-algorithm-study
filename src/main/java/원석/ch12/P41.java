package 원석.ch12;

import java.util.*;

public class P41 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // 그래프 형성
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        List<String> itinerary = new ArrayList<>();
        dfs("JFK", graph, itinerary);

        // Reverse the result since we are using DFS
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, itinerary);
        }

        itinerary.add(airport);
    }

    public static void main(String[] args) {
        P41 solution = new P41();

        // Example 1
        List<List<String>> tickets1 = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );
        System.out.println(solution.findItinerary(tickets1));

        // Example 2
        List<List<String>> tickets2 = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );
        System.out.println(solution.findItinerary(tickets2));
    }
}