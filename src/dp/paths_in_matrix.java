package dp;

public class paths_in_matrix {
    static int[][] dp;
    static int m;
    static int n;

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 0, 0}
        };
        m = mat.length; // row
        n = mat[0].length; // column
        dp = new int[m + 1][n + 1];
        System.out.println(pathsInMatrix(mat, m, n));
    }

    static int pathsInMatrix(int[][] mat, int i, int j) {
        if (i == 0 || j == 0 || mat[i - 1][j - 1] == 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        } else if (i == m - 1 && j == n - 1) {
            return 1;
        } else {
            dp[i][j] = pathsInMatrix(mat, i - 1, j) + pathsInMatrix(mat, i, j - 1);
            return dp[i][j];
        }
    }
}
