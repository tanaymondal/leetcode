package dp;

import java.util.Arrays;

public class subset_sum {
    // int[] array = {1, 2, 4, 5};
    // int sum = 9;
    // Find out if there is any subset, whose sum is equal to 9
    // The answer should be true or false. 4 + 5 = 9

    static int[][] dp;

    public static void main(String[] args) {
        int[] array = {1, 3, 2};
        int sum = 6;
        dp = new int[array.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(subsetSum(array, array.length, sum));
        System.out.println(subsetSumBottomUp(array, array.length, sum));
    }

    static boolean subsetSum(int[] array, int n, int sum) {
        if (dp[n][sum] != -1) {
            return dp[n][sum] == 1;
        }
        if (n == 0 && sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }

        if (array[n - 1] > sum) {
            dp[n][sum] = subsetSum(array, n - 1, sum) ? 1 : 0;
        } else {
            dp[n][sum] = (subsetSum(array, n - 1, sum) || subsetSum(array, n - 1, sum - array[n - 1])) ? 1 : 0;
        }
        return dp[n][sum] == 1;
    }


    static boolean subsetSumBottomUp(int[] array, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1];

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
