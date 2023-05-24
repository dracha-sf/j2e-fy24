/*
1.Given a directed acyclic graph (DAG), implement a function to find the longest path between any two vertices in the graph.
Example: Input: graph = [[1,2],[2,3],[3,4],[4,5],[5,6],[7,6]] Output: 6
*/
import java.util.*;
class solution
{static class AdjListNode {
    int v;
    int weight;
  AdjListNode(int _v, int _w)
    {
      v = _v;
      weight = _w;
    }
    int getV() { return v; }
    int getWeight() { return weight; }
  }
 static class Graph {
    int V; 
ArrayList<ArrayList<AdjListNode>> adj;
    Graph(int V) 
    {
      this.V = V;
      adj = new ArrayList<ArrayList<AdjListNode>>(V);
 
      for(int i = 0; i < V; i++){
        adj.add(new ArrayList<AdjListNode>());
      }
    }
 
    void addEdge(int u, int v, int weight)
    {
      AdjListNode node = new AdjListNode(v, weight);
      adj.get(u).add(node); 
    }
  void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {visited[v] = true;
  for (int i = 0; i<adj.get(v).size(); i++) {
        AdjListNode node = adj.get(v).get(i);
        if (!visited[node.getV()])
          topologicalSortUtil(node.getV(), visited, stack);
      }
stack.push(v);
    }
void longestPath(int s)
    {
      Stack<Integer> stack = new Stack<Integer>();
      int dist[] = new int[V];
for (int i = 0; i < V; i++)
        visited[i] = false;
 for (int i = 0; i < V; i++)
        if (visited[i] == false)
          topologicalSortUtil(i, visited, stack);
for (int i = 0; i < V; i++)
        dist[i] = Integer.MIN_VALUE;
 
      dist[s] = 0;
       
      while (stack.isEmpty() == false)
      {
         
        
        int u = stack.peek();
        stack.pop();
 
        if (dist[u] != Integer.MIN_VALUE)
        {
          for (int i = 0; i<adj.get(u).size(); i++)
          {
            AdjListNode node = adj.get(u).get(i);
            if (dist[node.getV()] < dist[u] + node.getWeight())
              dist[node.getV()] = dist[u] + node.getWeight();
          }
        }
      }
 
      
      for (int i = 0; i < V; i++)
        if(dist[i] == Integer.MIN_VALUE)
          System.out.print("INF ");
      else
        System.out.print(dist[i] + " ");
    }
  }
