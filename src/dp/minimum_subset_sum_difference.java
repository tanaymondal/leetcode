package dp;

public class minimum_subset_sum_difference {

    static Boolean[][] dp;
    static boolean[][] t;

    // Exact similar problem: https://leetcode.com/problems/last-stone-weight-ii/description/
    public static void main(String[] args) {
        int[] array = {1, 2, 7};
        // we need to find minimum subset difference
        // ex: {1,2} = 3 and {7} = 7
        // diff = mof (3 - 7) = 4. This is the minimum difference possible
        // Approach:
        //          1. do subset sum of totalSum (1,2,7 = 10)
        //          2. in the last row, sum - 2 * i is the answer


        int size = array.length;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = size + array[i];
        }

        dp = new Boolean[array.length + 1][sum + 1];

        //boolean val = findSubsetSumDifference(array, array.length, (sum + 1) / 2);
        boolean val = findSubsetSumDifferenceBottomUp(array, array.length, sum);
        int diff = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (t[array.length][i]) {
                diff = sum - 2 * i;
                break;
            }
        }
        System.out.println(diff);
    }

    // This is not working...
    static boolean findSubsetSumDifference(int[] array, int n, int sum) {
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }
        if (n == 0 && sum == 0) {
            dp[n][sum] = true;
            return true;
        }
        if (n == 0) {
            dp[n][sum] = false;
            return false;
        }
        if (sum == 0) {
            dp[n][sum] = true;
            return true;
        }

        if (array[n - 1] > sum) {
            dp[n][sum] = findSubsetSumDifference(array, n - 1, sum);
        } else {
            dp[n][sum] = findSubsetSumDifference(array, n - 1, sum) || findSubsetSumDifference(array, n - 1, sum - array[n - 1]);
        }

        return dp[n][sum];
    }

    static boolean findSubsetSumDifferenceBottomUp(int[] array, int n, int sum) {
        t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (array[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - array[i - 1]];
                }
            }
        }

        return t[n][sum];
    }
}
