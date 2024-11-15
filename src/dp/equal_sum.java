package dp;

import java.util.Arrays;

public class equal_sum {

    static int[][] dp;

    public static void main(String[] args) {
        int[] array = {1, 5, 11, 5};
        System.out.println(equalSum(array));
    }

    static boolean equalSum(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum = sum + j;
        }
        if (sum % 2 != 0) {
            return false; // when the sum is Odd, equal sum is not possible in the array
        }
        sum = sum / 2;
        dp = new int[array.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(eqSumBottomUp(array, sum));
        return eqSumTopDown(array, sum, array.length);
    }

    static boolean eqSumTopDown(int[] array, int sum, int n) {
        if (dp[n][sum] != -1) {
            return dp[n][sum] == 1;
        }
        if (sum == 0) {
            dp[n][sum] = 1;
            return true;
        }
        if (n == 0) {
            dp[n][sum] = 0;
            return false;
        }

        boolean val;
        if (array[n - 1] > sum) {
            val = eqSumTopDown(array, sum, n - 1);
        } else {
            val = eqSumTopDown(array, sum, n - 1) || eqSumTopDown(array, sum - array[n - 1], n - 1);
        }
        dp[n][sum] = val ? 1 : 0;
        return dp[n][sum] == 1;
    }

    static boolean eqSumBottomUp(int[] array, int sum) {
        int n = array.length;
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
