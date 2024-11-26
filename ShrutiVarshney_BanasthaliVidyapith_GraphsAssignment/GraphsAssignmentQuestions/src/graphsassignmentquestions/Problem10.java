package graphsassignmentquestions;
import java.util.*;
public class Problem10 
{
    public int countComponents(int n, int[][] edges)
    {
        // Create adjacency list from the input edges
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u); // For undirected graph, add both directions
        }

        // Create an array to mark visited nodes
        boolean[] visited = new boolean[n];

        // Perform DFS to count the connected components
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                dfs(i, adjList, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, List<Integer>[] adjList, boolean[] visited)
    {
        visited[node] = true;
        for (int neighbor : adjList[node]) 
        {
            if (!visited[neighbor])
            {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args)
    {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        Problem10 solution = new Problem10();
        int count = solution.countComponents(n, edges);
        System.out.println(count); // Output: 2
    }
}
