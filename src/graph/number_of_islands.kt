package graph

class Solution {

    private var row = -1
    private var col = -1

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        var count = 0
        row = grid.size
        col = grid[0].size

        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j)
                    count++
                }
            }
        }

        return count
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
            return
        }

        grid[i][j] = '0'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j + 1)
        dfs(grid, i, j - 1)
    }
}