package strings

// https://leetcode.com/problems/reverse-string/description/?envType=problem-list-v2&envId=string
fun main() {

    val array = charArrayOf('h', 'e', 'l', 'l', 'o')
    reverseString(array)
    println(array)
}

fun reverseString(s: CharArray): Unit {
    var startIndex = 0
    var endIndex = s.size - 1

    while (startIndex <= endIndex) {

        val temp = s[endIndex]
        s[endIndex] = s[startIndex]
        s[startIndex] = temp

        startIndex++
        endIndex--
    }
}