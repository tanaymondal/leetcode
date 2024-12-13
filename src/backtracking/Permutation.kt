package backtracking

// by swapping
object Permutation {

    private val result = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return listOf()
        backtrack(nums, 0)
        return result
    }

    private fun backtrack(nums: IntArray, index: Int) {
        if (nums.size == index) { // when index is out of bound
            result.add(nums.toList())
            return
        }

        for (i in index until nums.size) {
            nums.swap(i, index)
            backtrack(nums, index + 1)
            nums.swap(i, index)
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

// using boolean array to check picked or not
object Permutation1 {

    private val result = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return listOf()
        backtrack(nums, mutableListOf(), BooleanArray(nums.size))
        return result
    }

    private fun backtrack(nums: IntArray, permutation: MutableList<Int>, picked: BooleanArray) {
        if (nums.size == permutation.size) {
            result.add(permutation.toList())
            return
        }

        for (i in nums.indices) {
            if (!picked[i]) {
                permutation.add(nums[i])
                picked[i] = true
                backtrack(nums, permutation, picked)
                permutation.removeAt(permutation.size - 1)
                picked[i] = false
            }
        }
    }
}

fun main() {
    val array = intArrayOf(1,2,3)
    //println(Permutation.permute(array))
    println(Permutation1.permute(array))
}