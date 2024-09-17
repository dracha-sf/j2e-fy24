/*
3. Implement a function to clone a directed graph, where each node contains a label and a list of its neighbors.
*/

#include<bits/stdc++.h>

using namespace std;

class Node {
public:
    int label;
    vector<Node*> neighbors;

    Node(int label) : label(label) {}
};

Node* clone_graphs(Node* node, unordered_map<Node*, Node*>& visited) {
    // If the current node is null, return null
    if (!node) {
        return nullptr;
    }

    if (visited.count(node)) {
        return visited[node];
    }

    // Create a new node with the same label
    Node* clonedNode = new Node(node->label);

    visited[node] = clonedNode;

    for (Node* neighbor : node->neighbors) {
        clonedNode->neighbors.push_back(clone_graphs(neighbor, visited));
    }

    return clonedNode;
}

Node* clone_graphs(Node* node) {
    unordered_map<Node*, Node*> visited;
    return clone_graphs(node, visited);
}

void printGraph(Node* node, unordered_map<Node*, bool>& visited) {
    if (!node || visited[node]) {
        return;
    }

    visited[node] = true;

    cout << "[" << node->label << "] ";

    for (Node* neighbor : node->neighbors) {
        cout << neighbor->label << " ";
    }

    cout << endl;

    // Print the graph for each neighbor
    for (Node* neighbor : node->neighbors) {
        printGraph(neighbor, visited);
    }
}

int main() {
    // Create graph
    Node* node1 = new Node(1);
    Node* node2 = new Node(2);
    Node* node3 = new Node(3);
    Node* node4 = new Node(4);
    Node* node5 = new Node(5);

    node1->neighbors.push_back(node2);
    node2->neighbors.push_back(node3);
    node3->neighbors.push_back(node4);
    node4->neighbors.push_back(node5);
    node5->neighbors.push_back(node1);

    // Clone the graph
    Node* clonedGraph = clone_graphs(node1);

    // Print the cloned graph
    unordered_map<Node*, bool> visited;
    printGraph(clonedGraph, visited);

    return 0;
}

