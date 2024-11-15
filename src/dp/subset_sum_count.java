package dp;

import java.util.Arrays;

public class subset_sum_count {
    // int[] array = {1, 2, 4, 5};
    // int sum = 9;
    // Find out if there is any subset, whose sum is equal to 9
    // The answer should be true or false. 4 + 5 = 9

    static int[][] dp;

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 5;
        dp = new int[array.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(subsetSum(array, array.length, sum));
        System.out.println(subsetSubBottomUp(array, array.length, sum));
    }


    static int subsetSum(int[] array, int n, int sum) {
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        // base case:: when n (array size) and sum both of them 0, the 1 subset is possible, which is blank subset {}
        if (n == 0 && sum == 0) {
            return 1;
        }
        if (n == 0) {
            dp[n][sum] = 0;
            return 0;
        }
        if (sum == 0) {
            dp[n][sum] = 1;
            return 1;
        }


        if (array[n - 1] > sum) {
            dp[n][sum] = subsetSum(array, n - 1, sum);
        } else {
            dp[n][sum] = subsetSum(array, n - 1, sum) + subsetSum(array, n - 1, sum - array[n - 1]);
        }
        return dp[n][sum];
    }

    static int subsetSubBottomUp(int[] array, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (array[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - array[i - 1]];
                }
            }
        }
        return t[n][sum];
    }
}
