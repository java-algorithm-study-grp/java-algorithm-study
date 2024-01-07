package 승재.ch12;

import java.util.*;

public class P41 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (List<String> strings : tickets) {
            map.putIfAbsent(strings.get(0), new PriorityQueue<>());
            map.get(strings.get(0)).add(strings.get(1));
        }

        dfs(map, results, "JFK");

        return results;
    }

    public static void main(String[] args) {
        P41 solution = new P41();
        final List<String> itinerary = solution.findItinerary(List.of(
                List.of("MUC", "LHR"),
                List.of("JFK", "MUC"),
                List.of("SFO", "SJC"),
                List.of("LHR", "SFO")
        ));

        for (String s : itinerary) {
            System.out.println(s);
        }
    }

    private void dfs(Map<String, Queue<String>> map, List<String> results, String location) {
        while (map.containsKey(location) && !map.get(location).isEmpty()) {
            dfs(map, results, map.get(location).poll());
        }
        results.add(0, location);
    }
}
