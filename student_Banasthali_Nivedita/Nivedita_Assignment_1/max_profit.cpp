/*
You are given an integer array prices where prices[i] is the price of a given stock on the i
th day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

*/

#include <iostream>
#include <vector>
using namespace std;

int maxProfit(vector<int>& prices) {
    int maxProfit = 0;
    int minPrice = prices[0];

    for (int i = 1; i < prices.size(); ++i) {
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        } else {
            int currentProfit = prices[i] - minPrice;
            maxProfit = max(maxProfit, currentProfit);
        }
    }

    return maxProfit;
}

int main() {
    int priceArr[] = {1,2,3,4,5};
	vector<int> prices(priceArr, priceArr + sizeof(priceArr) / sizeof(priceArr[0]));

    int result = maxProfit(prices);

    cout << "Maximum profit: " << result << endl;

    return 0;
}

