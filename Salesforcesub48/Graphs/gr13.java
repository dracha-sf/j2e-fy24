/*
Problem 13:

Given a list of airline tickets represented as pairs of origin and destination airports, implement a function to
reconstruct the itinerary in order, assuming that the itinerary starts from "JFK".


Example:
Input:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output:
["JFK", "MUC", "LHR", "SFO", "SJC"]

*/

import java.util.*;
class gr13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<String>> tickets = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String origin = sc.next();
            String dest = sc.next();
            List<String> ticket = new ArrayList<>();
            ticket.add(origin);
            ticket.add(dest);
            tickets.add(ticket);
        }
        List<String> itinerary = findItinerary(tickets);
        System.out.println(itinerary);
        sc.close();
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (!adjList.containsKey(origin)) {
                adjList.put(origin, new PriorityQueue<>());
            }
            adjList.get(origin).offer(dest);
        }
        List<String> itinerary = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (adjList.containsKey(curr) && !adjList.get(curr).isEmpty()) {
                stack.push(adjList.get(curr).poll());
            } else {
                itinerary.add(0, stack.pop());
            }
        }
        return itinerary;
    }
}
