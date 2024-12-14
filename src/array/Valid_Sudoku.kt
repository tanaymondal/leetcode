package array

fun main() {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val squares = Array(9) { HashSet<Char>() }

        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val value = board[r][c]

                if (value == '.')
                    continue

                val squareIdx = (r / 3) * 3 + (c / 3)
                if (value in rows[r] || value in cols[c] || value in squares[squareIdx]) {
                    return false
                }

                rows[r].add(value)
                cols[c].add(value)
                squares[squareIdx].add(value)
            }
        }

        return true
    }

//          ['5','3','.','.','7','.','.','.','.']
//          ['6','.','.','1','9','5','.','.','.']
//          ['.','9','8','.','.','.','.','6','.']
//          ['8','.','.','.','6','.','.','.','3']
//          ['4','.','.','8','.','3','.','.','1']
//          ['7','.','.','.','2','.','.','.','6']
//          ['.','6','.','.','.','.','2','8','.']
//          ['.','.','.','4','1','9','.','.','5']
//          ['.','.','.','.','8','.','.','7','9']

    println(isValidSudoku(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    ))

}