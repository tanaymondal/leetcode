package strings

object reverse_words_in_a_string_ii {


    @JvmStatic
    fun main(args: Array<String>) {

        // Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
        // Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']

        val array = charArrayOf('t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e')
        println(array)

        reverse(array, 0, array.size - 1)

        var startIndex = 0
        var endIndex = 0
        for (i in 0 until array.size) {
            if (array[i] == ' ') {
                endIndex = i - 1
                reverse(array, startIndex, endIndex)
                startIndex = i + 1
            }
        }
        reverse(array, startIndex, array.size - 1)

        println(array)

    }

    fun reverse(array: CharArray, startIndex: Int, endIndex: Int) {
        var left = startIndex
        var right = endIndex
        while (left <= right) {
            val temp = array[right]
            array[right] = array[left]
            array[left] = temp
            left++
            right--
        }
    }
}