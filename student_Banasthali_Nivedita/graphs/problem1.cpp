/*
Given a directed acyclic graph (DAG), implement a function to find the longest path between any two vertices in
the graph
*/

#include<bits/stdc++.h>

using namespace std;

int longestPath(vector<vector<int>>& graph, int start, int end) {
    int n = graph.size();
    vector<int> inDegree(n, 0);
    vector<int> dist(n, 0);

	//calculate in degree of each vertex
    for (auto& edges : graph) {
        for (int v : edges) {
            inDegree[v]++;
        }
    }
		
    queue<int> q;
    for (int i = 0; i < n; i++) {
        if (inDegree[i] == 0) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        // Traverse all outgoing edges
        for (int next : graph[curr]) {
            // Update the longest path to the next vertex
            dist[next] = max(dist[next], dist[curr] + 1);

            // Decrease the in-degree of the next vertex
            if (--inDegree[next] == 0) {
                q.push(next);
            }
        }
    }

    //return the longest path
    return dist[end];
}

int main() {
    vector<vector<int>> graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 6}};
    int start = 1;
    int end = 6;

    int longest = longestPath(graph, start, end);
    cout << "Longest path: " << longest << endl;

    return 0;
}

