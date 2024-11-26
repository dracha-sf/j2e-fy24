package graphsassignmentquestions;
import java.util.*;
class Node 
{
    int label;
    List<Node> neighbors;

    public Node(int label) 
    {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}

public class Problem3 
{
    public static Node cloneGraph(Node node) 
    {
        if (node == null) 
        {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        return cloneNode(node, visited);
    }

    private static Node cloneNode(Node node, Map<Node, Node> visited) 
    {
        if (visited.containsKey(node)) 
        {
            return visited.get(node);
        }

        Node clone = new Node(node.label);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) 
        {
            clone.neighbors.add(cloneNode(neighbor, visited));
        }

        return clone;
    }

    public static void main(String[] args) 
    {
        // Create the input graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node5);
        node5.neighbors.add(node1);

        // Clone the graph
        Node clonedGraph = cloneGraph(node1);

        // Print the cloned graph
        List<List<Integer>> result = new ArrayList<>();
        printGraph(clonedGraph, result);

        // Print the output in the requested format
        System.out.println("Output:");
        for (List<Integer> edge : result) {
            System.out.println(Arrays.toString(edge.toArray()));
        }
    }

    private static void printGraph(Node node, List<List<Integer>> result) 
    {
        Set<Node> visited = new HashSet<>();
        dfs(node, visited, result);
    }

    private static void dfs(Node node, Set<Node> visited, List<List<Integer>> result) 
    {
        visited.add(node);

        for (Node neighbor : node.neighbors) 
        {
            result.add(Arrays.asList(node.label, neighbor.label));
            if (!visited.contains(neighbor)) 
            {
                dfs(neighbor, visited, result);
            }
        }
    }
}
