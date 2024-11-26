package graphsassignmentquestions;
import java.util.*;
public class Problem7 
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adjList.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int node : adjList.keySet()) {
            if (adjList.get(node).size() == 1) {
                queue.add(node);
            }
        }

        while (n > 2) {
            int currLen = queue.size();
            n -= currLen;
            for (int i = 0; i < currLen; i++) {
                int curr = queue.poll();
                for (int neighbor : adjList.get(curr)) {
                    adjList.get(neighbor).remove(curr);
                    if (adjList.get(neighbor).size() == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        Problem7 solution = new Problem7();
        List<Integer> minHeightTrees = solution.findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees); // Output: [1]

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};

        minHeightTrees = solution.findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees); // Output: [3, 4]
    }
}
