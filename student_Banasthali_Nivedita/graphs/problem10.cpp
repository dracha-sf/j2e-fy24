/*
10. Implement a function to find the number of connected components in an undirected graph.
*/

#include<bits/stdc++.h>

using namespace std;

void dfs(vector<vector<int>>& graph, int node, vector<bool>& visited) {
    visited[node] = true;

    for (int neighbor : graph[node]) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited);
        }
    }
}

int countConnectedComponents(int n, vector<vector<int>>& edges) {
    vector<vector<int>> graph(n);
    vector<bool> visited(n, false);
    int count = 0;

    //adjacency list representation of the graph
    for (const vector<int>& edge : edges) {
        int u = edge[0];
        int v = edge[1];
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    // DFS to count the number of connected components
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            count++;
            dfs(graph, i, visited);
        }
    }

    return count;
}

int main() {
    int n = 5;
    vector<vector<int>> edges = {
        {0, 1},
        {1, 2},
        {3, 4}
    };

    int numComponents = countConnectedComponents(n, edges);
    cout << "Number of connected components: " << numComponents << endl;

    return 0;
}

