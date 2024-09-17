/*
0/1 Knapsack Problem: We are given N items where each item has some weight and profit associated with it. We are also
given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The target is to put the items into the bag such that
the sum of profits associated with them is the maximum possible.
The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of
an item into the bag].
 */
package salesforce.recursion;

public class problem6 {
    public static int knapsack(int N, int W, int[] profit, int[] weight) {
        int[][] mat = new int[N + 1][W + 1];

        // Build the dp table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i - 1] <= j) {
                    mat[i][j] = Math.max(profit[i - 1] + mat[i - 1][j - weight[i - 1]], mat[i - 1][j]);
                } else {
                    mat[i][j] = mat[i - 1][j];
                }
            }
        }

        return mat[N][W];
    }

    public static void main(String[] args) {
        int N = 3;
        int W = 50;
        int[] profit = {60,100,120};
        int[] weight = {10,20,30};

        int maxProfit = knapsack(N, W, profit, weight);
        System.out.println(maxProfit);
    }
}
