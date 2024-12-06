package array

fun main() {

    // Input: nums = [1,1,1,2,2,3], k = 2
    // Output: [1,2]

    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2

    println(topKFrequent(nums, k).joinToString())

}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (data in nums) {
        map[data] = map.getOrDefault(data, 0) + 1
    }

    val array = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
    map.forEach { (k, v) -> array[v].add(k) }

    val resultArray = IntArray(k)
    var count = 0
    for (index in array.size - 1 downTo 0) {
        if (array[index].isNotEmpty()) {
            for (data in array[index]) {
                resultArray[count] = data
                count++
                if (count == k) {
                    return resultArray
                }
            }
        }
    }
    return resultArray
}

fun topKFrequent2(nums: IntArray, k: Int): IntArray {
    val map = nums.toList().groupingBy { it }.eachCount()
    val list = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
    map.forEach { (k, v) -> list[v].add(k) }
    return list.flatMap { it }.takeLast(k).toIntArray()
}