package dp;

public class minimum_sum_path {

    // grid = [[1,3,1],[1,5,1],[4,2,1]]

    static int[][] dp;

    public static void main(String[] args) {
        int[][] mat = {
                {3, 2, 12, 15, 10},
                {6, 19, 7, 11, 17},
                {8, 5, 12, 32, 21},
                {3, 20, 2, 9, 7}
        };
        System.out.println(minimumSumPath(mat));
    }

    static int minimumSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        return cost(grid, 0, 0);
    }

    static int cost(int[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        } else if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        } else {
            dp[i][j] = grid[i][j] + Math.min(cost(grid, i + 1, j), cost(grid, i, j + 1));
            return dp[i][j];
        }
    }
}
