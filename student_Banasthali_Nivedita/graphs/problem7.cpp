/*
Implement a function to find the minimum height trees (MHTs) of a undirected graph, where an MHT is a root of the
graph that has the minimum height among all possible roots.

*/

#include<bits/stdc++.h>

using namespace std;

vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
    // Base cases
    if (n == 1) {
        return {0};
    } else if (n == 2) {
        return {0, 1};
    }

    // Create adjacency list representation of the graph
    vector<vector<int>> adj(n);
    vector<int> degree(n, 0);

    for (const vector<int>& edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj[u].push_back(v);
        adj[v].push_back(u);
        degree[u]++;
        degree[v]++;
    }

    // Create a queue to store the leaf nodes
    queue<int> leaves;
    for (int i = 0; i < n; i++) {
        if (degree[i] == 1) {
            leaves.push(i);
        }
    }

    int remainingNodes = n;
    while (remainingNodes > 2) {
        int numLeaves = leaves.size();
        remainingNodes -= numLeaves;

        for (int i = 0; i < numLeaves; i++) {
            int leaf = leaves.front();
            leaves.pop();

            for (int neighbor : adj[leaf]) {
                degree[neighbor]--;

                if (degree[neighbor] == 1) {
                    leaves.push(neighbor);
                }
            }
        }
    }
    
    vector<int> minHeightTrees;
    while (!leaves.empty()) {
        minHeightTrees.push_back(leaves.front());
        leaves.pop();
    }

    return minHeightTrees;
}

int main() {
    int n = 6;
    vector<vector<int>> edges = {
        {0, 1},
        {0, 2},
        {0, 3},
        {3, 4},
        {4, 5}
    };

    vector<int> mhtRoots = findMinHeightTrees(n, edges);

    cout << "Minimum Height Trees (MHTs): ";
    for (int root : mhtRoots) {
        cout << root << " ";
    }
    cout << endl;

    return 0;
}

