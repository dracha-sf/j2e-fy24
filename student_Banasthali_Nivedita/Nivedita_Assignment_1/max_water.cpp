/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
the i th line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*/

#include <iostream>
using namespace std;

int maxArea(int height[], int n) {
    int maxWater = 0;
    int l = 0;
    int r = n - 1;
    
    while (l < r) {
        int currentWater = (r - l) * min(height[l], height[r]);
        maxWater = max(maxWater, currentWater);
        
        if (height[l] < height[r]) {
            l++;
        } else {
            r--;
        }
    }
    
    return maxWater;
}

int main() {
    int height[] = {1,1};
    int n = sizeof(height) / sizeof(height[0]);
    
    int maxWater = maxArea(height, n);
    cout << "Maximum amount of water that can be stored: " << maxWater << endl;
    
    return 0;
}

/*
time complexity --> O(n) 
*/
