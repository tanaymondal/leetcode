package array

fun main() {

    println(getConcatenation(intArrayOf(1,2,6)).contentToString())



}

fun getConcatenation(nums: IntArray): IntArray {
    val size = nums.size * 2
    val array = IntArray(size)
    for(i in nums.indices) {
        array[i] = nums[i]
    }
    for(i in nums.indices) {
        array[nums.size + i] = nums[i]
    }
    return array
}