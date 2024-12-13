package backtracking

fun main() {
    val candidates = intArrayOf(2,3,6,7)
    val target = 7
    println(combinationSum(candidates, target))
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    val combination = mutableListOf<Int>()

    fun dfs(index: Int, total: Int) {
        if(total == target) {
            result.add(combination.toList())
            return
        } else if (total > target || index >= candidates.size) {
            return
        }

        combination.add(candidates[index])
        dfs(index, total + candidates[index])

        combination.removeAt(combination.size - 1)

        dfs(index + 1, total)

    }

    dfs(0, 0)

    return result
}