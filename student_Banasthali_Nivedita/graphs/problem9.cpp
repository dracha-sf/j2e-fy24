/*
 Implement a function to find the number of paths in a directed acyclic graph (DAG) from the source node to the
destination nod
*/

#include<bits/stdc++.h>

using namespace std;

int countPaths(vector<vector<int>>& graph, int source, int destination) {
    int n = graph.size();

    //store the number of paths for each node
    vector<int> numPaths(n, 0);

    numPaths[destination] = 1;

    for (int i = n - 1; i >= 0; i--) {
        for (int j = 0; j < graph[i].size(); j++) {
            int nextNode = graph[i][j];
            numPaths[i] += numPaths[nextNode];
        }
    }

    return numPaths[source];
}

int main() {
    vector<vector<int>> graph = {
        {0, 1},
        {0, 2},
        {1, 2},
        {1, 3},
        {2, 3}
    };

    int source = 0;
    int destination = 3;

    int numPaths = countPaths(graph, source, destination);
    cout << "Number of paths: " << numPaths << endl;

    return 0;
}

