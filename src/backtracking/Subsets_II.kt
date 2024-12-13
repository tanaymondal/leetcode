package backtracking

fun main() {
    val nums = intArrayOf(4, 4, 4, 1, 4)
    println(subsetsWithDup(nums))
}

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()

    val result = mutableListOf<List<Int>>()

    val subset = mutableListOf<Int>()

    //val set = HashSet<List<Int>>() // we can solve using HashSet also to eliminate duplicate

    fun dfs(index: Int) {
        if (index >= nums.size) {
            result.add(subset.sorted().toList())
            return
        }

        subset.add(nums[index])
        dfs(index + 1)
        subset.removeAt(subset.size - 1)

        var j = index
        while (j + 1 < nums.size && nums[j] == nums[j + 1]) {
            j++
        }

        dfs(j + 1)
    }

    dfs(0)
    return result
}