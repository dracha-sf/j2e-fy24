package graphsassignmentquestions;
import java.util.*;
public class Problem13 
{
    public List<String> findItinerary(List<List<String>> tickets) 
    {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> itinerary = new ArrayList<>();

        // Build the graph
        for (List<String> ticket : tickets) 
        {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Start DFS from "JFK"
        dfs("JFK", graph, itinerary);

        // Reverse the itinerary to get the correct order
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) 
    {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty())
        {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, itinerary);
        }

        itinerary.add(airport);
    }

    public static void main(String[] args) 
    {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        Problem13 solution = new Problem13();
        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary); // Output: [JFK, MUC, LHR, SFO, SJC]
    }
}
