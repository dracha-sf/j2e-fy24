/*
Given a list of airline tickets represented as pairs of origin and destination airports, implement a function to
reconstruct the itinerary in order, assuming that the itinerary starts from "JFK".

*/

#include<bits/stdc++.h>

using namespace std;

void dfs(string& currentAirport, unordered_map<string, vector<string>>& flights, vector<string>& itinerary) {
    vector<string>& destinations = flights[currentAirport];

    while (!destinations.empty()) {
        string nextAirport = destinations.back();
        destinations.pop_back();
        dfs(nextAirport, flights, itinerary);
    }

    itinerary.push_back(currentAirport);
}

vector<string> reconstructItinerary(vector<vector<string>>& tickets) {
    unordered_map<string, vector<string>> flights;
    vector<string> itinerary;

    // Build the graph of flights
    for (const vector<string>& ticket : tickets) {
        string from = ticket[0];
        string to = ticket[1];
        flights[from].push_back(to);
    }

    // Sort the destinations in lexical order
    for (auto& entry : flights) {
        sort(entry.second.begin(), entry.second.end(), greater<string>());
    }

    // Reconstruct the itinerary starting from "JFK"
    dfs("JFK", flights, itinerary);

    reverse(itinerary.begin(), itinerary.end());
    return itinerary;
}

int main() {
    vector<vector<string>> tickets = {
        {"MUC", "LHR"},
        {"JFK", "MUC"},
        {"SFO", "SJC"},
        {"LHR", "SFO"}
    };

    vector<string> itinerary = reconstructItinerary(tickets);
    cout << "Reconstructed itinerary: ";
    for (const string& airport : itinerary) {
        cout << airport << " ";
    }
    cout << endl;

    return 0;
}

