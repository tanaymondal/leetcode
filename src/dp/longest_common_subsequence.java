package dp;

import java.util.Arrays;

public class longest_common_subsequence {

    static int[][] dp;

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "bc";
        int m = text1.length();
        int n = text2.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lcs(text1, text2, m, n));

        System.out.println(lcsBottomUp(text1, text2));
    }

    static int lcs(String x, String y, int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            dp[m][n] = 1 + lcs(x, y, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
        }
        return dp[m][n];
    }

    static int lcsBottomUp(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] t = new int[m + 1][n + 1];
/*        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }*/

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[m][n];
    }
}
