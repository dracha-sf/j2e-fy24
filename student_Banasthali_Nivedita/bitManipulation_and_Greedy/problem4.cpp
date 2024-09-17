/*
You have N pills of characteristic values [a1, a2…..an]
On each day i, you can take the ith pill and increase your health by ai points or Do nothing and take 1 point of
damage
H = H - 1, where H is a value denoting your health.
You die if your health becomes zero. Initially H = V (where V is a value given in the input).
What is the minimum number of pills you should take to survive for N days.
*/

#include<bits/stdc++.h>
using namespace std;

int minimumPills(int N, int V, vector<int>& a) {
    
    sort(a.begin(), a.end());

    int pillsTaken = 0;
    int health = V;
    int daysSurvived = 0;

    while (health > 0 && daysSurvived < N) {
        // If the current pill can increase health to a level greater than or equal to the next day's damage
        if (health >= a[pillsTaken]) {
            health -= a[pillsTaken];
            pillsTaken++;
        }
        // If the current pill cannot increase health , take damage and survive using the next pill
        else {
            health--;
        }
        daysSurvived++;
    }

    return pillsTaken;
}

int main() {
    int N=5, V=2;
 
    vector<int> a{1,3,1,1,3};

    int minPillsToSurvive = minimumPills(N, V, a);
    cout << "Minimum number of pills to survive: " << minPillsToSurvive << endl;

    return 0;
}

